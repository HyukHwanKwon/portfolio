package com.chungrim.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;

import com.chungrim.service.CleanerService;
import com.chungrim.vo.CleanerVO;

public class TestController {
	@Inject
	private CleanerService cleanerService;
	
	public void printLog() throws Exception {
		
		final String apiKey = "AAAA5h6zWnQ:APA91bFT9n0y6fysSy0w2O4zDyPPqpk7k93I6LJCbIdcUpVveSYRZ_bIcf0pTGOPEUvRKAT62T6QmOJCqtXnUQ0yMUWm1QwyNPW4O8_iXKZdA7WAtVFfBYi1YAJgp-s_Xx-VmXegq__0";
        URL url = new URL("https://fcm.googleapis.com/fcm/send");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "key=" + apiKey);
        conn.setDoOutput(true);
        
        CleanerVO cleaner = cleanerService.selectToken();
        String token = "";
        
        if(cleaner != null) {
        	token = cleaner.getCleanerToken();
        }
        
        String input = "{\"notification\" : {\"title\" : \" trashcan \", \"body\" : \"쓰레기통 비워 주세요.\"}, \"to\":\""+ token +"\", \"click_action\" : \"OPEN_ACTIVITY\"}";
        OutputStream os = conn.getOutputStream();
        System.out.println("dddd");
        System.out.println("성공");
        //�샇吏꾩씠 �룿 : f39FwzAWNt8:APA91bGiESTXT6RtvFCXHIeqzQnWJH9AZJLMnQ2Lu5dBdpIZ72DGsgP7ITsJ9JPxUUk-67TgEMFFDhWnNiyC6SMhHZlVom6vZxcekmarqV15PK2f9CbJnqbeU6RBvPqcgpDyESUIg5oK
        //�뿉裕� : dqqWwYT3ZHM:APA91bFo8NfhvShlvknUxO9Sp52aGHXBIUU5ed3dwzT5ruO0KOHyzY9IFnzmxOYtKqSzbmmQAEoEAQ0R0-ZW6KZ2GzzqwpGQnJVXSFyg3bazX5jZIj4psAtyCOJjYqcU8uRAPSfXBQ6z
        // �꽌踰꾩뿉�꽌 �궇�젮�꽌 �븳湲� 源⑥��뒗 �궗�엺�� �븘�옒泥섎읆  UTF-8濡� �씤肄붾뵫�빐�꽌 �궇�젮二쇱옄
        os.write(input.getBytes("UTF-8"));
        os.flush();
        os.close();

        int responseCode = conn.getResponseCode();
         
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + input);
        System.out.println("Response Code : " + responseCode);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // print result
        
        System.out.println(response.toString());
        
	}
	
}
