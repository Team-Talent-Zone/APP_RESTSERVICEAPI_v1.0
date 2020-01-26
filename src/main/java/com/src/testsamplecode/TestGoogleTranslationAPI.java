package com.src.testsamplecode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.Translation;
import com.google.cloud.translate.v3.TranslationServiceClient;

public class TestGoogleTranslationAPI {

	public static void main(String[] args) throws Exception {
		ArrayList<TestStaticContent> arrayList = new ArrayList<TestStaticContent>();
		TestStaticContent testStaticContent1 = new TestStaticContent();
		testStaticContent1.setContent(
				"A platform that publishes N number of service (sites) to a individual or a company into a technology to manage their business features");

		TestStaticContent testStaticContent2 = new TestStaticContent();
		testStaticContent2.setContent(
				"A platform that provides an employment to the freelancer to grow finically and the career opportunity");

		TestStaticContent testStaticContent3 = new TestStaticContent();
		testStaticContent3.setContent("The platform will built in Web Version , Android and IOS");

		TestStaticContent testStaticContent4 = new TestStaticContent();
		testStaticContent4.setContent("It comes with English, Hindi and Telugu languages");

		arrayList.add(testStaticContent1);
		arrayList.add(testStaticContent2);
		arrayList.add(testStaticContent3);
		arrayList.add(testStaticContent4);
		
		translateText(arrayList);
	}

	public static void translateText(ArrayList<TestStaticContent> arrayList) throws IOException {
		// TODO(developer): Replace these variables before running the sample.
		String projectId = "astral-scout-261009";
		// Supported Languages: https://cloud.google.com/translate/docs/languages
		String targetLanguage = "te";
		for (TestStaticContent tsc : arrayList) {
			translateText(projectId, targetLanguage, tsc.getContent());
		}
	}

	// Translating Text
	public static void translateText(String projectId, String targetLanguage, String text) throws IOException {

		// Initialize client that will be used to send requests. This client only needs
		// to be created
		// once, and can be reused for multiple requests. After completing all of your
		// requests, call
		// the "close" method on the client to safely clean up any remaining background
		// resources.
		try (TranslationServiceClient client = TranslationServiceClient.create()) {
			// Supported Locations: `global`, [glossary location], or [model location]
			// Glossaries must be hosted in `us-central1`
			// Custom Models must use the same location as your model. (us-central1)
			LocationName parent = LocationName.of(projectId, "global");
			Locale locale = new Locale(targetLanguage);
			locale.getISO3Language();
			// Supported Mime Types:
			// https://cloud.google.com/translate/docs/supported-formats
			TranslateTextRequest request = TranslateTextRequest.newBuilder().setParent(parent.toString())
					.setMimeType("text/plain").setTargetLanguageCode(locale.getISO3Language()).addContents(text)
					.build();

			TranslateTextResponse response = client.translateText(request);

			// Display the translation for each input text provided
			for (Translation translation : response.getTranslationsList()) {
				System.out.printf(locale.getDisplayLanguage() + " Translated text: %s\n", translation.getTranslatedText());
			}
		}
	}
}
