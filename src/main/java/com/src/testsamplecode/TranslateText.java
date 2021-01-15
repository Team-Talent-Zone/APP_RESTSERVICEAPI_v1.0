package com.src.testsamplecode;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Locale;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;

public class TranslateText {
	 
	 public static void main(String[] arguments) throws IOException, GeneralSecurityException
	    {
	        Translate t = new Translate.Builder(
	                GoogleNetHttpTransport.newTrustedTransport()
	                , GsonFactory.getDefaultInstance(), null)
	                // Set your application name
	                .setApplicationName("kaamkarega")
	                .build();
	        Locale locale = new Locale("hi");
			locale.getISO3Language();
	        Translate.Translations.List list = t.new Translations().list(
	                Arrays.asList(
	                        // Pass in list of strings to be translated
	                        "<html><body><h1>hello</body>",
	                        "How to use Google Translate from Java"),
	                // Target language
	                locale.getISO3Language()).setFormat("text");
 
	        // TODO: Set your API-Key from https://console.developers.google.com/
	        list.setKey("AIzaSyBDDFawIBF3roB7RB1lI7g1D6qbn2e6oB4");
	        TranslationsListResponse response = list.execute();
	        for (TranslationsResource translationsResource : response.getTranslations())
	        {
	        	System.out.printf(locale.getDisplayLanguage() + " Translated text: %s\n", translationsResource.getTranslatedText());
	        }
	    }
	 
 
}
