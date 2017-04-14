package com.sam.demo.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsumeWebService {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://localhost:8081/demo/getDetails");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		
		if(conn.getResponseCode()!=200){
			throw new RuntimeException("Failed : Http error code :" +conn.getResponseCode());			
		}		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;
		System.out.println("Output from server...\n");
		
		while((output=br.readLine())!=null){
			System.out.println(output);
		}
		conn.disconnect();
	}
}
