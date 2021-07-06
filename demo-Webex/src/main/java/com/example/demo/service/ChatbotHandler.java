package com.example.demo.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.demo.model.UserInfo;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;

import CodeTest.etc.DefineCode;

public class ChatbotHandler {
    private GDFMessage gdfMessage;
    private UserInfo userInfo;
    private ChatbotHandler(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
    public GDFMessage getGdfMessage() {
        return gdfMessage;
    }

    /**
     * parse of google dialogflow
     * @param queryResult
     */
    private void parseOfGDF(QueryResult queryResult) {
        if(queryResult == null) return;

        GDFMessage gdfMessage = null;
        try {
            String intentName = queryResult.getIntent().getDisplayName();
            DefineCode.Intent intent = DefineCode.Intent.getIntent(intentName);

            final Struct struct = queryResult.getParameters();
            Map<String, Value> entities = struct.getFieldsMap();

            gdfMessage = new GDFMessage();
            gdfMessage.setIntentName(queryResult.getIntent().getDisplayName());

            Map<String, String> parameters = gdfMessage.getParameters();
            entities.entrySet().stream().forEach( e -> {
                parameters.put(e.getKey(), e.getValue().getStringValue());
            });

            gdfMessage.setQueryText(queryResult.getQueryText());
            gdfMessage.setResponseMessage(queryResult.getFulfillmentText());
            gdfMessage.setIntent(intent);
        } catch (Exception ex) {
            ex.printStackTrace();
            gdfMessage = null;
        }

        this.gdfMessage = gdfMessage;
    }

    /**
     * 사용자 별 검색해야 할 서비스 matching
     * @return service code
     */
    public DefineCode.ChatbotService findMatchService() {

        if(userInfo == null || StringUtils.isEmpty(userInfo.getUserType())) return null;
        DefineCode.ChatbotService chatbotService = null;

        if(gdfMessage.getIntent() == null) return null;
        boolean isStudent = "S".equals(userInfo.getUserType()) ? true : false;
        String startParam = null;
        String endParam = null;
        switch(gdfMessage.getIntent()) {
            case ASSIGNMENT_SCHEDULE:
                startParam = gdfMessage.getParameters().get(DefineCode.GDFEntity.START);
                endParam = gdfMessage.getParameters().get(DefineCode.GDFEntity.END);
                if(StringUtils.isEmpty(startParam) && StringUtils.isEmpty(endParam)) {
                    chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_SCHEDULE_SERVICE
                            : DefineCode.ProfessorService.ASSIGNMENT_SCHEDULE_SERVICE;
                } else {
                    if(StringUtils.isEmpty(startParam) == false) {
                        chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_START_SCHEDULE_SERVICE
                                : DefineCode.ProfessorService.ASSIGNMENT_START_SCHEDULE_SERVICE;
                    } else {
                        chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_END_SCHEDULE_SERVICE
                                : DefineCode.ProfessorService.ASSIGNMENT_END_SCHEDULE_SERVICE;
                    }
                }

                break;
            case ASSIGNMENT_CONTINUE_SCHEDULE:
                startParam = gdfMessage.getParameters().get(DefineCode.GDFEntity.START);
                endParam = gdfMessage.getParameters().get(DefineCode.GDFEntity.END);
                if(StringUtils.isEmpty(startParam) && StringUtils.isEmpty(endParam)) {
                    chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_CONTINUE_SERVICE
                            : DefineCode.ProfessorService.ASSIGNMENT_CONTINUE_SERVICE;
                } else {
                    if(StringUtils.isEmpty(startParam) == false) {
                        chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_CONTINUE_START_SCHEDULE_SERVICE
                                : DefineCode.ProfessorService.ASSIGNMENT_CONTINUE_START_SCHEDULE_SERVICE;
                    } else {
                        chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_CONTINUE_END_SCHEDULE_SERVICE
                                : DefineCode.ProfessorService.ASSIGNMENT_CONTINUE_END_SCHEDULE_SERVICE;
                    }
                }
                break;
            case ASSIGNMENT_EVALUATION_SCHEDULE:
                if(isStudent)
                    break;

                chatbotService = DefineCode.ProfessorService.ASSIGNMENT_EVALUATION_SCHEDULE_SERVICE;
                break;
            case ASSIGNMENT_EVALUATION_INFO:
                String continueParam = gdfMessage.getParameters().get(DefineCode.GDFEntity.CONTINUE);
                if(StringUtils.isEmpty(continueParam) == false) {
                    // 연장 평가비율 정보
                    chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_EVALUATION_INFO_CONTINUE_SERVICE
                            : DefineCode.ProfessorService.ASSIGNMENT_EVALUATION_INFO_CONTINUE_SERVICE;
                    break;
                }

                String ratioParam = gdfMessage.getParameters().get(DefineCode.GDFEntity.RESULT_RATIO);
                String openParam = gdfMessage.getParameters().get(DefineCode.GDFEntity.RESULT_OPEN);
                if(StringUtils.isEmpty(ratioParam) == false && StringUtils.isEmpty(openParam)) {
                    // 평가 비율 정보
                    chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_EVALUATION_INFO_RATIO_SERVICE
                            : DefineCode.ProfessorService.ASSIGNMENT_EVALUATION_INFO_RATIO_SERVICE;
                } else if(StringUtils.isEmpty(ratioParam) && StringUtils.isEmpty(openParam) == false) {
                    // 평가 공개 정보
                    chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_EVALUATION_INFO_OPEN_SERVICE
                            : DefineCode.ProfessorService.ASSIGNMENT_EVALUATION_INFO_OPEN_SERVICE;
                } else if(StringUtils.isEmpty(ratioParam) && StringUtils.isEmpty(openParam)){
                    chatbotService = isStudent ? DefineCode.StudentService.ASSIGNMENT_EVALUATION_SCORE
                            : DefineCode.ProfessorService.ASSIGNMENT_EVALUATION_SCORE;
                } else {
                    // TODO : 둘다 입력 했다면 뭘 우선으로 할것인? 아니면 없을으로 return 할 지 확인 필요
                    chatbotService = null;
                }
                break;
            case ASSIGNMENT_SUBMIT:
                if(isStudent == false)
                    break;
                chatbotService = DefineCode.StudentService.ASSIGNMENT_SUBMIT_SERVICE;
                break;
            case ASSIGNMENT_SUBMITTER:
                if(isStudent) break;

                Map<String, String> entities = gdfMessage.getParameters();
                if(CollectionUtils.isEmpty(entities) == false) {
                    String state = entities.get(DefineCode.GDFEntity.SUBMIT_STATE);
                    if(StringUtils.isEmpty(state) || state.equals("submitter")) {
                        chatbotService = DefineCode.ProfessorService.ASSIGNMENT_SUBMITTER_SERVICE;
                        break;
                    }

                    if(state.equals("un-submitter")) {
                        chatbotService = DefineCode.ProfessorService.ASSIGNMENT_UN_SUBMITTER_SERVICE;
                    } else if (state.equals("re-submitter")) {
                        chatbotService = DefineCode.ProfessorService.ASSIGNMENT_RE_SUBMITTER_SERVICE;
                    } else if (state.equals("continue-submitter")) {
                        chatbotService = DefineCode.ProfessorService.ASSIGNMENT_CONTINUE_SUBMITTER_SERVICE;
                    }
                }
                break;
//            case FUNCTION:    
//            	  chatbotService = DefineCode.CommonService.FUNCTION_SEARCH;
//                  break;
            case HELP:
            default:
                chatbotService = DefineCode.CommonService.HEL_SERVICE;
                break;
        }

        return chatbotService;
    }

    public class GDFMessage {
        private String queryText;
        private String responseMessage;
        private String intentName;
        private Map<String, String> parameters;
        private DefineCode.Intent intent;

        public GDFMessage() {
            this.parameters = new HashMap<>();
        }
        public String getQueryText() {
            return queryText;
        }

        public void setQueryText(String queryText) {
            this.queryText = queryText;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        public String getIntentName() {
            return intentName;
        }

        public void setIntentName(String intentName) {
            this.intentName = intentName;
        }

        public Map<String, String> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, String> parameters) {
            this.parameters = parameters;
        }
        public void setIntent(DefineCode.Intent intent) {
            this.intent = intent;
        }
        public DefineCode.Intent getIntent() {
            return intent;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UserInfo userInfo;
        private QueryResult queryResult;

        public Builder userInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
            return this;
        }
        public Builder queryResult(QueryResult queryResult) {
            this.queryResult = queryResult;
            return this;
        }

        public ChatbotHandler build() {
            ChatbotHandler chatbotHandler = new ChatbotHandler(userInfo);
            chatbotHandler.parseOfGDF(queryResult);
            return chatbotHandler;
        }
    }
}
