package com.example.coco.sendwhatsappmessageusingjava;

import com.squareup.okhttp.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SendWhatsappMessageUsingJavaApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SendWhatsappMessageUsingJavaApplication.class, args);
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"typing_time\":0,\"to\":\"<PHONE_NUMBER>\",\"body\":\"Hello Coco Bhaiya\"}");
		Request request = new Request.Builder()
				.url("https://gate.whapi.cloud/messages/text")
				.post(body)
				.addHeader("accept", "application/json")
				.addHeader("content-type", "application/json")
				.addHeader("authorization", "Bearer <TOKEN>")
				.build();

		Response response = client.newCall(request).execute();
		System.out.println("Response :" + response);
	}

}
