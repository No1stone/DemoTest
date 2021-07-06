package com.example.demo.service;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.dialogflow.v2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

@Component
public class GDFHandler {
	private final String languageCode = "ko";

	@Autowired
	private ApplicationContext resourceLoader;

	public GoogleCredentials gdfCredentialFileSelect(String FileName) throws IOException {
		Resource resource = resourceLoader.getResource(String.format("classpath:%s", FileName));
		return GoogleCredentials.fromStream(resource.getInputStream())
				.createScoped(Collections.singletonList("https://www.googleapis.com/auth/dialogflow"));
	}

	public GoogleCredentials ChoiceGoogleCredentials(int SiteCD) {

		GoogleCredentials gdfCredential = null;
		String FileName = null;

		switch (SiteCD) {
		case 1:
			System.out.println("1번 GDF");
			FileName = "genuine-axe-310600.json";
			break;

		case 2:
			System.out.println("2번 GDF");
			FileName = "genuine-axe-310600.json";
			break;

		case 5:
			System.out.println("5번 GDF");
			FileName = "genuine-axe-310600.json";
			break;
						
		case 6:
			System.out.println("6번 GDF");
			FileName = "genuine-axe-310600.json";
			break;

		case 14:
			System.out.println("14번 GDF");
			FileName = "genuine-axe-310600.json";
			break;

		case 31:
			System.out.println("14번 GDF");
			FileName = "genuine-axe-310600.json";
			break;

		default:
			System.out.println("디폴트");
			FileName = "genuine-axe-310600.json";
			break;
		}

		try {
			gdfCredential = gdfCredentialFileSelect(FileName);
		} 
		catch (IOException e){
			e.printStackTrace();
		}

		return gdfCredential;
	}

	public QueryResult detectIntentTexts(String message, int SiteCD) {
		QueryResult queryResult = null;
		GoogleCredentials gdfCredential = ChoiceGoogleCredentials(SiteCD);

		try {
			String projectId = ((ServiceAccountCredentials) gdfCredential).getProjectId();

			SessionsClient sessionsClient = createSessionClient(SiteCD);
			SessionName sessionName = SessionName.of(projectId, UUID.randomUUID().toString());

			// Set the text (hello) and language code (en-US) for the query
			TextInput.Builder textInput = TextInput.newBuilder().setText(message).setLanguageCode(languageCode);

			// Build the query with the TextInput
			QueryInput queryInput = QueryInput.newBuilder().setText(textInput).build();

			// Performs the detect intent request
			DetectIntentResponse response = sessionsClient.detectIntent(sessionName, queryInput);

			// Display the query result
			queryResult = response.getQueryResult();

			System.out.println("====================");
			System.out.format("Query Text: '%s'\n", queryResult.getQueryText());
			System.out.format("Detected Intent: %s (confidence: %f)\n", queryResult.getIntent().getDisplayName(),
					queryResult.getIntentDetectionConfidence());
			System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return queryResult;
	}

	private SessionsClient createSessionClient(int SiteCD) throws IOException {
		// authentication refresh
		GoogleCredentials gdfCredential = ChoiceGoogleCredentials(SiteCD);
		gdfCredential.refreshIfExpired();
		SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
		SessionsSettings sessionsSettings = settingsBuilder
				.setCredentialsProvider(FixedCredentialsProvider.create(gdfCredential)).build();
		return SessionsClient.create(sessionsSettings);
	}
}
