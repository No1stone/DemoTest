package com.example.demo.config;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.demo.ciscospark.Spark;
import com.example.demo.model.UserInfo;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.dialogflow.v2beta1.Intent.Message.RbmSuggestedAction.RbmSuggestedActionShareLocationOrBuilder;

@Configuration
public class GDFConfig {

	@Value("${webex.chatbot.accesstoken}")
	private String CHATBOT_ACCESS_TOKEN;
	@Autowired
	private ApplicationContext resourceLoader;
	
//	@Bean
//	public Spark spark() {
//		
//		//java.util.logging.Logger logger = java.util.logging.Logger.getLogger(WebConfig.class.getName());
//		
//		Spark spark = Spark.builder()
//				.baseUrl(URI.create("https://webexapis.com/v1"))
//				//.logger(logger)
//				//.accessToken(this.MSGBOT_ACCESS_TOKEN)
//				.build();
//		return spark;
//	}
	@Bean(name = "spark")
	public Spark chatbotSpark() {
		
		Spark spark = Spark.builder()
				.baseUrl(URI.create("https://webexapis.com/v1"))
				.accessToken(this.CHATBOT_ACCESS_TOKEN)
				.build();
		System.out.println(spark);
		return spark;
	}
	
	//@Bean
//	public GoogleCredentials gdfCredential() throws IOException{
//		Resource resource = resourceLoader.getResource("classpath:genuine-axe-310600.json");
//		return GoogleCredentials.fromStream(resource.getInputStream())
//							.createScoped(Collections.singletonList("https://www.googleapis.com/auth/dialogflow"));
//	}
	@Bean
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		HttpClient client = HttpClientBuilder.create()
								.setMaxConnTotal(50)
								.setMaxConnPerRoute(20).build();
		factory.setHttpClient(client);
		factory.setConnectTimeout(10000);
		factory.setReadTimeout(5000);

		return new RestTemplate(factory);
	}
}
