package CodeTest.etc;

import java.util.Arrays;
import java.util.List;

public class DefineCode {

    public interface GDFEntity {
        public static final String ASSIGNMENT = "assignment";
        public static final String ASSIGNMENT_RESULT = "assignment_result";
        public static final String ASSIGNMENT_SUBMIT_STATE = "submit_state";
        public static final String ASSIGNMENT_SCHEDULE = "assignment_schedule";
        public static final String CONTINUE = "continue";
        public static final String EVALUATION = "evaluation";
        public static final String RESULT_OPEN = "result_open";
        public static final String RESULT_RATIO = "result_ratio";
        public static final String SUBMIT = "submit";
        public static final String SUBMIT_STATE = "submit_state";
        public static final String START = "start";
        public static final String END = "enddate";
        public static final String HELP = "help";
    }
    public interface ChatbotService {

        public String service();
        public String serviceName();

        public static ChatbotService findService(String serviceName) {
            ChatbotService service = null;
            ProfessorService professorService = ProfessorService.getService(serviceName);
            if(professorService != null)
                service = professorService;
            else
                service = StudentService.getService(serviceName);
            return service;
        }
    }
    
    public static enum CommonService implements ChatbotService {
        HEL_SERVICE("common-help", "도움말");

        private String service;
        private String serviceName;
        private CommonService(String service, String serviceName) {
            this.service = service;
            this.serviceName = serviceName;
        }
        public String serviceName() {
            return serviceName;
        }

        public String service() {
            return service;
        }

        public static CommonService getService(String name) {
            CommonService commonService = null;
            for(CommonService service : CommonService.values()) {
                if(name.equals(service.service())) {
                    commonService = service;
                    break;
                }
            }
            return commonService;
        }
    }

    public static enum ProfessorService implements ChatbotService {
        ASSIGNMENT_SCHEDULE_SERVICE("pf-schedule", "과제 제출 기간"),
        ASSIGNMENT_START_SCHEDULE_SERVICE("pf-start-schedule", "과제 제출 시작일"),
        ASSIGNMENT_END_SCHEDULE_SERVICE("pf-end-schedule", "과제 제출 종료일"),
        ASSIGNMENT_CONTINUE_SERVICE("pf-continue-schedule", "과제 연장 제출 기간"),
        ASSIGNMENT_CONTINUE_START_SCHEDULE_SERVICE("pf-continue-start-schedule", "과제 연장 제출 시작일"),
        ASSIGNMENT_CONTINUE_END_SCHEDULE_SERVICE("pf-continue-end-schedule", "과제 연장 제출 종료일"),
        ASSIGNMENT_SUBMITTER_SERVICE("pf-submitter", "과제 제출자"),
        ASSIGNMENT_UN_SUBMITTER_SERVICE("pf-un-submitter", "과제 미제출자"),
        ASSIGNMENT_RE_SUBMITTER_SERVICE("pf-re-submitter", "과제 재제출자"),
        ASSIGNMENT_CONTINUE_SUBMITTER_SERVICE("pf-continue-submitter", "과제 연장 제출자"),
        ASSIGNMENT_EVALUATION_SCHEDULE_SERVICE("pf-ev-schedule", "과제 평가 일정"),
        ASSIGNMENT_EVALUATION_SCORE("pf-ev-score", "과제 평가 점수"),
        ASSIGNMENT_EVALUATION_INFO_RATIO_SERVICE("pf-ev-ratio", "과제 평가 비율 정보"),
        ASSIGNMENT_EVALUATION_INFO_OPEN_SERVICE("pf-ev-open", "과제 평가 공개 여부"),
        ASSIGNMENT_EVALUATION_INFO_CONTINUE_SERVICE("pf-ev-continue", "과제 연장 평가 비율");

        private String service;
        private String serviceName;
        private ProfessorService(String service, String serviceName) {
            this.service = service;
            this.serviceName = serviceName;
        }
        public String serviceName() {
            return serviceName;
        }

        public String service() {
            return service;
        }

        public static ProfessorService getService(String name) {
            ProfessorService professorService = null;
            for(ProfessorService service : ProfessorService.values()) {
                if(name.equals(service.service())) {
                    professorService = service;
                    break;
                }
            }
            return professorService;
        }

    }

    public static enum StudentService implements ChatbotService {
        ASSIGNMENT_SCHEDULE_SERVICE("st-schedule", "과제 제출 기간"),
        ASSIGNMENT_START_SCHEDULE_SERVICE("st-start-schedule", "과제 제출 시작일"),
        ASSIGNMENT_END_SCHEDULE_SERVICE("st-end-schedule", "과제 제출 종료일"),
        ASSIGNMENT_CONTINUE_SERVICE("st-continue-schedule", "과제 연장 제출 기간"),
        ASSIGNMENT_CONTINUE_START_SCHEDULE_SERVICE("st-continue-start-schedule", "과제 연장 제출 시작일"),
        ASSIGNMENT_CONTINUE_END_SCHEDULE_SERVICE("st-continue-end-schedule", "과제 연장 제출 종료일"),
        ASSIGNMENT_EVALUATION_INFO_RATIO_SERVICE("st-ev-ratio", "과제 성적 반영 비율"),
        ASSIGNMENT_EVALUATION_INFO_OPEN_SERVICE("st-ev-open", "과제 성적 공개 여부"),
        ASSIGNMENT_EVALUATION_INFO_CONTINUE_SERVICE("st-ev-continue", "과제 연장 성적 반영 비율"),
        ASSIGNMENT_EVALUATION_SCORE("st-ev-score", "과제 평가 점수"),
        ASSIGNMENT_SUBMIT_SERVICE("st-submit", "");

        private String service;
        private String serviceName;
        private StudentService(String service, String serviceName) {
            this.service = service;
            this.serviceName = serviceName;
        }

        public String service() {
            return service;
        }
        public String serviceName() {
            return serviceName;
        }
        public static StudentService getService(String name) {
            StudentService studentService = null;
            for(StudentService service : StudentService.values()) {
                if(name.equals(service.service())) {
                    studentService = service;
                    break;
                }
            }
            return studentService;
        }
    }

    public static enum Intent {
        // 과제 기간
        ASSIGNMENT_SCHEDULE(1, "assignment-schedule", Arrays.asList(GDFEntity.ASSIGNMENT, GDFEntity.ASSIGNMENT_SCHEDULE), false)
        // 과제 연장 기간
        , ASSIGNMENT_CONTINUE_SCHEDULE(2, "assignment-continue-schedule", Arrays.asList(GDFEntity.CONTINUE, GDFEntity.ASSIGNMENT_SCHEDULE), false)
        // 과제 평가 기간
        , ASSIGNMENT_EVALUATION_SCHEDULE(3, "assignment-evaluation-schedule", Arrays.asList(GDFEntity.ASSIGNMENT_SCHEDULE, GDFEntity.EVALUATION), false)
        // 과제 평가 정보
        , ASSIGNMENT_EVALUATION_INFO(4, "assignment-evaluation-info", Arrays.asList(GDFEntity.ASSIGNMENT_RESULT, GDFEntity.CONTINUE, GDFEntity.RESULT_RATIO, GDFEntity.RESULT_OPEN), false)
        // 과제 제출
        , ASSIGNMENT_SUBMIT(5, "assignment-submit", Arrays.asList(GDFEntity.SUBMIT, GDFEntity.ASSIGNMENT_SCHEDULE), true)
        // 과제 제출자
        , ASSIGNMENT_SUBMITTER(6, "assignment-submitter", Arrays.asList(GDFEntity.ASSIGNMENT, GDFEntity.ASSIGNMENT_SUBMIT_STATE), false)
        , HELP(7, "help", Arrays.asList(GDFEntity.HELP), false);

        private int code;
        private String value;
        private List<String> entities;
        private boolean isOnlyStudent;

        private Intent(int code, String value, List<String> entities, boolean isOnlyStudent) {
            this.code = code;
            this.value = value;
            this.entities = entities;
            this.isOnlyStudent = isOnlyStudent;
        }

        public int code() {
            return code;
        }
        public String value() {
            return value;
        }
        public List<String> entities() {
            return entities;
        }
        public boolean isOnlyStudent() {
            return isOnlyStudent;
        }

        public static Intent getIntent(String value) {
            Intent intent = null;
            for(Intent i : Intent.values()) {
                if(i.value().equals(value)) {
                    intent = i;
                    break;
                }
            }
            return intent;
        }
    }
}
