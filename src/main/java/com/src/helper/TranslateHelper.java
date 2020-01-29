package com.src.helper;

import java.io.IOException;
import java.util.Locale;

import com.google.cloud.translate.v3.LocationName;
import com.google.cloud.translate.v3.TranslateTextRequest;
import com.google.cloud.translate.v3.TranslateTextResponse;
import com.google.cloud.translate.v3.Translation;
import com.google.cloud.translate.v3.TranslationServiceClient;
import com.src.constant.UtilityConfig;

public class TranslateHelper {

	// Translating Text
	public String translateText(String targetLanguage, String text, String type) throws IOException {

		String mimeType = "text/plain";
		if (type.equals("html")) {
			mimeType = "text/html";
		}

		String translationText = null;
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
			LocationName parent = LocationName.of(UtilityConfig.PROJECT_ID_DEV, "global");
			Locale locale = new Locale(targetLanguage);
			locale.getISO3Language();

			// Supported Mime Types:
			// https://cloud.google.com/translate/docs/supported-formats
			// Supported Languages: https://cloud.google.com/translate/docs/languages

			TranslateTextRequest request = TranslateTextRequest.newBuilder().setParent(parent.toString())
					.setMimeType(mimeType).setTargetLanguageCode(locale.getISO3Language()).addContents(text).build();

			TranslateTextResponse response = client.translateText(request);

			// Display the translation for each input text provided
			for (Translation translation : response.getTranslationsList()) {
				System.out.printf(locale.getDisplayLanguage() + " Translated text: %s\n",
						translation.getTranslatedText());
				translationText = translation.getTranslatedText();
			}
			return translationText;
		}
	}
}
