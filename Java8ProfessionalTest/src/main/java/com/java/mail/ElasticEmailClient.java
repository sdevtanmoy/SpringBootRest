package com.java.mail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class ElasticEmailClient {

	
	public static void main(String[] args) {
		
		String userName = "info@greenlifeinsurancebroking.com";
		String apiKey = "14b10213-a41c-41ff-ab2b-eac727fd10ae"; 
		String from = "info@greenlifeinsurancebroking.com"; 
		String fromName = from; 
		String subject = "Test Mail"; 
		String body = "Test mail body";
		String to = "tanmoy140388@gmail.com";
		String isTransactional="True";
		
		Send(userName, apiKey, from, fromName, subject, body, to, isTransactional);
		System.out.println("Done");
	}
	
	public static String Send(String userName, String apiKey, String from, String fromName, String subject, String body,
			String to, String isTransactional) {

		try {

			String encoding = "UTF-8";

			String data = "apikey=" + URLEncoder.encode(apiKey, encoding);
			data += "&from=" + URLEncoder.encode(from, encoding);
			data += "&fromName=" + URLEncoder.encode(fromName, encoding);
			data += "&subject=" + URLEncoder.encode(subject, encoding);
			data += "&bodyHtml=" + URLEncoder.encode(body, encoding);
			data += "&to=" + URLEncoder.encode(to, encoding);
			data += "&isTransactional=" + URLEncoder.encode(isTransactional, encoding);

			URL url = new URL("https://api.elasticemail.com/v2/email/send");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String result = rd.readLine();
			wr.close();
			rd.close();
			System.out.println(result);
			return result;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
