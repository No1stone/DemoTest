package com.example.demo.gsonbuilder;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.example.demo.ciscospark.Attachment;
import com.example.demo.ciscospark.Message;
import com.example.demo.ciscospark.Spark;
import com.example.demo.model.ActionItem;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

@Component
public class WebexHandler {
    private final Logger logger = LoggerFactory.getLogger(WebexHandler.class);
    @Value("${webex.chatbot.email}")
    private String botEmail;
    @Autowired
    private Spark chatbotSpark;
//    @Autowired
//    private BotMapper botMapper;

    public boolean isBotMessage(String personEmail) {
        return botEmail.equals(personEmail);
    }
//    public String findMessage(MsgRoomData roomData) {
//        String messageId = roomData.getId();
//
//        Message message = chatbotSpark.messages().path("/".concat(messageId)).get();
//        if(ObjectUtils.isEmpty(message) || StringUtils.isEmpty(message.getText())) return null;
//
//        return message.getText();
//    }

    public void sendCardMessage(String title, Message message) {

        JsonObject titleBlock = WebexCardBuilder.buildTextBlock(title);
        JsonObject textBlock = WebexCardBuilder.buildTextBlock(message.getText());

        JsonArray bodys = Json.createArrayBuilder().add(titleBlock).add(textBlock).build();
        JsonArray attachmentsArry = WebexCardBuilder.buildAdaptiveCard(bodys);
        message.setAttachments(attachmentsArry);

        this.sendMessage(message);
    }

    public void sendMarkdownMessage(String title, Message message) {
        String boldTile = "**".concat(title).concat("**\n");
        String body = "- ".concat(message.getText());
        message.setMarkdown(boldTile.concat(body));
        this.sendMessage(message);
    }
    public void sendMessage(Message message) {
        chatbotSpark.messages().post(message);
    }

    @Async
    public void sendAsyncMessage(String id, String message) {
        logger.info("- async send message");
        Message msg = new Message();
        msg.setToPersonId(id);
        msg.setText(message);
        chatbotSpark.messages().post(msg);
    }

//    public Attachment findAttachment(MsgRoomData actionData) {
//        if(actionData == null) return null;
//        String actionId = actionData.getId();
//
//        Attachment attachment = chatbotSpark.attachment().path("/".concat(actionId)).get();
//
//        return attachment;
//    }

    public void replyKeyword(String title, Message message, List<ActionItem> actionItems) {
        JsonArrayBuilder bodyBuilder = Json.createArrayBuilder();
        JsonObject textBlock = WebexCardBuilder.buildTextBlock(title);
        bodyBuilder.add(textBlock);

        // action set max 갯수가 5개밖에 안됨..
        List<List<ActionItem>> parts = Lists.partition(actionItems, 5);
        Gson gson = new Gson();
        for(List<ActionItem> items : parts) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for(ActionItem item : items) {
                String data = gson.toJson(item);
                JsonObject obj = WebexCardBuilder.buildAction(WebexCardBuilder.ActionType.SUBMIT, String.format("%s:%s", item.getCourseName(), item.getTitle()), data);
                arrayBuilder.add(obj);
            }
            JsonObject containerItems = WebexCardBuilder.buildContainerItems(WebexCardBuilder.buildActionItems(false, arrayBuilder.build()));
            bodyBuilder.add(containerItems);
        }

        JsonArray bodys = bodyBuilder.build();
        JsonArray attachmentsArry = WebexCardBuilder.buildAdaptiveCard(bodys);
        /*Map<String, String> data = new HashMap<>();
        data.put("type", "1234");
        data.put("msg", "text");
        data.put("result", "나와라");
        JsonObject actionOne = WebexCardBuilder.buildAction(WebexCardBuilder.ActionType.SUBMIT, "java2", data);
        JsonObject actionTwo = WebexCardBuilder.buildAction(WebexCardBuilder.ActionType.SUBMIT, "c#", "c# data");
        JsonObject actionThree = WebexCardBuilder.buildAction(WebexCardBuilder.ActionType.OPEN_URL, "naver", "http://www.naver.com");
        JsonArray items = Json.createArrayBuilder().add(actionOne)
                                                    .add(actionTwo)
                                                    .add(actionThree).build();*/

        message.setText("body");
        message.setAttachments(attachmentsArry);
        chatbotSpark.messages().post(message);
    }

    public void replyQuestion(String title, Message message, List<ActionItem> actionItems) {
        JsonArrayBuilder bodyBuilder = Json.createArrayBuilder();
        JsonObject textBlock = WebexCardBuilder.buildTextBlock(title);
        bodyBuilder.add(textBlock);

        // action set max 갯수가 5개밖에 안됨..
        List<List<ActionItem>> parts = Lists.partition(actionItems, 5);
        Gson gson = new Gson();
        for(List<ActionItem> items : parts) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            for(ActionItem item : items) {
                String data = gson.toJson(item);
                JsonObject obj = WebexCardBuilder.buildAction(WebexCardBuilder.ActionType.SUBMIT, item.getTitle(), data);
                arrayBuilder.add(obj);
            }
            JsonObject containerItems = WebexCardBuilder.buildContainerItems(WebexCardBuilder.buildActionItems(false, arrayBuilder.build()));
            bodyBuilder.add(containerItems);
        }

        JsonArray bodys = bodyBuilder.build();
        JsonArray attachmentsArry = WebexCardBuilder.buildAdaptiveCard(bodys);

        message.setText("body");
        message.setAttachments(attachmentsArry);
        chatbotSpark.messages().post(message);
    }
    

    
}
