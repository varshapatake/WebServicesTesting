package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

	//GET method without header
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url); //http get is request
		CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpGet);  //clicking send but or hit the url
		
		return closeableHttpResponse;
	}
	
	//Get method with header
	public CloseableHttpResponse get(String url,HashMap<String,String> headermap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url); //http get is request
		
		for(Map.Entry<String, String> entry:headermap.entrySet())
		{
			httpGet.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpGet);  //clicking send but or hit the url
		
		return closeableHttpResponse;
	}
	
	//Post method
	public CloseableHttpResponse post(String url,String entityString,HashMap<String,String> headerMap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(url);
		httpPost.setEntity(new StringEntity(entityString));
		
		for(Map.Entry<String, String> entry:headerMap.entrySet())
		{
			httpPost.addHeader(entry.getKey(), entry.getValue());
		}
	     CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpPost);
	     return closeableHttpResponse;
	}
}
