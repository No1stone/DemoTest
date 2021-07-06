package CodeTest.etc;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

import org.json.simple.JSONObject;

import CodeTest.etc.WebexCardbuilder.ActionType;
import GsonBuilder.CardBuilderTest;
import io.grpc.netty.shaded.io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

public class WebexCardbuilderPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonArrayBuilder bodyBuilder = Json.createArrayBuilder();
        JsonObject textBlock = WebexCardbuilder.buildTextBlock("Text");
        bodyBuilder.add(textBlock);
		
		JsonObject obj = WebexCardbuilder.buildAction(WebexCardbuilder.ActionType.SUBMIT, ":asd", "asd");
		
		bodyBuilder.add(obj);
		
		CardBuilderTest at = new CardBuilderTest();
		
		
		
	}

}
