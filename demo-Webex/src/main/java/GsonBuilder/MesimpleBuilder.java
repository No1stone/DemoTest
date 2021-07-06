package GsonBuilder;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;


public class MesimpleBuilder {
	
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
				.add("version", "1.1")
				.add("body",ja).build();
		}
	

	//말그대로 텍스트의 이름(검색어를눌러주세여)
	public static JsonObject SelectCardActionTextTitle(String TextTitle) {
		return Json.createObjectBuilder()
				.add("type", "TextBlock")
				.add("text", TextTitle)
				.add("color", "dark")
				.build();
		}

	//클릭될 라인의 텍스트와 설정될 데이터값이다.
	public static JsonObject SelectCardActionName(String IMText, String ImDATA){
		return Json.createObjectBuilder()
				.add("type","Container")
				.add("style", "emphasis")
				.add("items", Json.createArrayBuilder().add(Json.createObjectBuilder()
						.add("type", "TextBlock")
						.add("color", "accent")
						.add("text", IMText).build())
						.build())
				.add("selectAction", Json.createObjectBuilder()
						.add("type", "Action.Submit")
						.add("data", ImDATA).build())
				.build();
		}
	
	//유알엘센더.
	public static JsonObject SelectCardURL(String IMText,String URLa){
		return Json.createObjectBuilder()
				.add("type","Container")
				.add("style", "emphasis")
				.add("items", Json.createArrayBuilder().add(Json.createObjectBuilder()
						.add("type", "TextBlock")
						.add("color", "accent")
						.add("text", IMText).build())
						.build())
				.add("selectAction", Json.createObjectBuilder()
						.add("type", "Action.OpenUrl")
						.add("url", URLa).build())
				.build();
		}
	

	}
