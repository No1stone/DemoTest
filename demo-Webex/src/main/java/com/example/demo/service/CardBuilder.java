package com.example.demo.service;

import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

public class CardBuilder {
	 public final static String CARD_CONTENT_TYPE = "application/vnd.microsoft.card.adaptive";
	    public static JsonArray buildAdaptiveCard(JsonArray bodys) {
	        return Json.createArrayBuilder().add(Json.createObjectBuilder()
	                .add("contentType", CARD_CONTENT_TYPE)
	                .add("content", Json.createObjectBuilder()
	                        .add("$schema", "http://adaptivecards.io/schemas/adaptive-card.json")
	                        .add("version", "1.1")
	                        .add("type", "AdaptiveCard")
	                        .add("body", bodys).build()
	                ).build()).build();
	    }
	    public static JsonObject buildContainer() {
	        return Json.createObjectBuilder().add("type", "Container").build();
	    }

	    public static JsonObject buildTextBlock(String text) {
	        return Json.createObjectBuilder().add("type", "TextBlock").add("wrap", JsonValue.TRUE)
	                .add("text", text).add("weight", "bold").add("horizontalAlignment", "Center")
	                .add("size", "Large").build();
	    }
	    
	    public static JsonObject buildAction(ActionType type, String title, String data) {
	        String dataKey = (type == ActionType.OPEN_URL) ? "url" : "data";
	        return Json.createObjectBuilder().add("type", type.type())
	                .add("title", title)
	                .add(dataKey, data).build();
	    }
//
	    public static JsonObject buildAction(ActionType type, String title, Map<String, String> data) {
	        String dataKey = (type == ActionType.OPEN_URL) ? "url" : "data";
	        JsonObjectBuilder builder = Json.createObjectBuilder();
	        data.forEach(builder::add);
	        JsonObject obj = builder.build();
	        return Json.createObjectBuilder().add("type", type.type())
	                .add("title", title)
	                .add(dataKey, obj).build();
	    }

	    public static JsonObject buildActionItems(boolean isHorizontal, JsonArray actions) {
	        return Json.createObjectBuilder().add("type", "ActionSet")
	                                        .add("actions", actions)
	                                        .build();
	    }
	    
	    public static JsonObject buildSelectAction(boolean isHorizontal, JsonArray actions) {
	    	
	    	
	        return Json.createObjectBuilder().add("type", "ActionSet")
                    .add("selectAction", actions)
                    .build();
}

	    public static JsonObject buildContainerItems(JsonObject items) {
	        return Json.createObjectBuilder().add("type", "Container")
	                .add("items", Json.createArrayBuilder().add(items))
	                .build();
	    }

	    public enum ActionType {
	        SUBMIT("Action.Submit")
	        , OPEN_URL("Action.OpenUrl");
	        private String type;
	        private ActionType(String type) {
	            this.type = type;
	        }

	        public String type() {
	            return type;
	        }
	    }
}
