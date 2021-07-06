package com.example.demo.gsonbuilder;

import javax.json.*;

import  com.example.demo.model.ActionItem;


import java.util.Map;

public class WebexCardBuilder {
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

    public static JsonObject buildContainerItems(JsonObject items) {
        return Json.createObjectBuilder().add("type", "Container")
                .add("items", Json.createArrayBuilder().add(items))
                .build();
    }
    
    
	
	public static JsonArray SelectCardAttachments(JsonObject cardcontents){
		return Json.createArrayBuilder().add(
				Json.createObjectBuilder()
				.add("contentType", "application/vnd.microsoft.card.adaptive")
				.add("content", cardcontents)
				.build()).build();
		}
	
	public static JsonObject SelectCardContents(JsonArrayBuilder ja){
		return Json.createObjectBuilder()
				.add("type", "AdaptiveCard")
				.add("version", "1.0")
				.add("body",ja).build();
		}
	

	//말그대로 텍스트의 이름(검색어를눌러주세여)
	public static JsonObject SelectCardActionTextTitle(String TextTitle) {
		return Json.createObjectBuilder()
				.add("type", "TextBlock")
				.add("width", "auto")
				.add("text", TextTitle)
				.add("color", "dark")
				.build();
		}

	//클릭될 라인의 텍스트와 설정될 데이터값이다.
	public static JsonObject SelectCardActionName(String IMText, String item){
		return Json.createObjectBuilder()
				.add("type","Container")
				.add("style", "emphasis")
				.add("items", Json.createArrayBuilder().add(Json.createObjectBuilder()
						.add("type", "TextBlock")
						.add("width", "auto")
						.add("color", "accent")
						.add("text", IMText).build())
						.build())
				.add("selectAction", Json.createObjectBuilder()
						.add("type", "Action.Submit")
						.add("data", item).build())
				.build();
		}
	
	public static JsonObject SelectCardSendName(String IMText){
		return Json.createObjectBuilder()
				.add("type","Container")
				.add("style", "emphasis")
				.add("items", Json.createArrayBuilder().add(Json.createObjectBuilder()
						.add("type", "TextBlock")
						.add("color", "default")
						.add("text", IMText).build())
						.build())
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
