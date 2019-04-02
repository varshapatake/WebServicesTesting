package com.qa.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import junit.framework.Assert;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.client.RestClient;
import com.qa.util.Utility;

public class TestWebService extends BaseClass{
	BaseClass b;
	String Serviceurl;
	public String ApiUrl;
	public String url;
	RestClient r;
	CloseableHttpResponse closeableHttpResponse;
	@BeforeMethod
	public void setup()
	{
		b=new BaseClass();
		Serviceurl=prop.getProperty("url");
		ApiUrl=prop.getProperty("serviceUrl");
		url=Serviceurl+ApiUrl;
	}
  @Test(priority=1)
  public void getApiTest() throws ClientProtocolException, IOException {
	  r=new RestClient();
	  closeableHttpResponse=r.get(url);
	  
	  
	      //fetching status code
			int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("StatusCode : "+statusCode);
		    Assert.assertEquals(statusCode, 200);
			
			//feaching response body
		    String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		  
		    //converting string into json
		    JSONObject ResponsejsonObject=new JSONObject(responseString);
		    System.out.println("Response Body"+ResponsejsonObject);
		    
		    String perpage=Utility.getValueByPath(ResponsejsonObject,"/per_page");
		    System.out.println("value of per page is--->"+perpage);
		    Assert.assertEquals(Integer.parseInt(perpage), 3);
		    
		    String total=Utility.getValueByPath(ResponsejsonObject, "/total");
		    System.out.println("value of total is----->"+total);
		    Assert.assertEquals(Integer.parseInt(total), 12);
		    
		    //getting values fron JSON array
		    String last_name=Utility.getValueByPath(ResponsejsonObject, "/data[0]/last_name");
		    String id=Utility.getValueByPath(ResponsejsonObject, "/data[0]/id");
		    String avatar=Utility.getValueByPath(ResponsejsonObject, "/data[0]/avatar");
		    String first_name=Utility.getValueByPath(ResponsejsonObject, "/data[0]/first_name");
		    
		    System.out.println("value of lastname is---->"+last_name);
		    System.out.println("value of id is---->"+id);
		    System.out.println("value of avatar is---->"+avatar);
		    System.out.println("value of first_name is---->"+first_name);
		    
		    Assert.assertEquals(last_name, "Holt");
		    Assert.assertEquals(Integer.parseInt(id),4);
		    Assert.assertEquals(avatar,"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
		    Assert.assertEquals(first_name, "Eve");
		   
		    //feaching headers
		    Header[] header=closeableHttpResponse.getAllHeaders();
		    HashMap<String,String> allheaders=new HashMap<String,String>();
		    
		    for(Header header1:header)
		    {
		    	allheaders.put(header1.getName(), header1.getValue());
		    }
		    System.out.println("all Headers "+allheaders);   	
  }
  
  @Test(priority=2)
  public void GetApiWithHeader() throws ParseException, IOException
  {
	         r=new RestClient();
	 
	        HashMap<String,String> headerMap=new HashMap<String,String>();
	        headerMap.put("Content-Type","application/json");
	        closeableHttpResponse=r.get(url,headerMap);
	
	      //fetching status code
			int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("StatusCode"+statusCode);
		    Assert.assertEquals(statusCode, 200);
			
			//feaching response body
		    String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		  
		    //converting string into json
		    JSONObject ResponsejsonObject=new JSONObject(responseString);
		    System.out.println("Response Body"+ResponsejsonObject);
		    
		    String perpage=Utility.getValueByPath(ResponsejsonObject,"/per_page");
		    System.out.println("value of per page is--->"+perpage);
		    Assert.assertEquals(Integer.parseInt(perpage), 3);
		    
		    String total=Utility.getValueByPath(ResponsejsonObject, "/total");
		    System.out.println("value of total is----->"+total);
		    Assert.assertEquals(Integer.parseInt(total), 12);
		    
		    //getting values fron JSON array
		    String last_name=Utility.getValueByPath(ResponsejsonObject, "/data[0]/last_name");
		    String id=Utility.getValueByPath(ResponsejsonObject, "/data[0]/id");
		    String avatar=Utility.getValueByPath(ResponsejsonObject, "/data[0]/avatar");
		    String first_name=Utility.getValueByPath(ResponsejsonObject, "/data[0]/first_name");
		    
		    System.out.println("value of lastname is---->"+last_name);
		    System.out.println("value of id is---->"+id);
		    System.out.println("value of avatar is---->"+avatar);
		    System.out.println("value of first_name is---->"+first_name);
		    
		    Assert.assertEquals(last_name, "Holt");
		    Assert.assertEquals(Integer.parseInt(id),4);
		    Assert.assertEquals(avatar,"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");
		    Assert.assertEquals(first_name, "Eve");
		   
		    //feaching headers
		    Header[] header=closeableHttpResponse.getAllHeaders();
		    HashMap<String,String> allheaders=new HashMap<String,String>();
		    
		    for(Header header1:header)
		    {
		    	allheaders.put(header1.getName(), header1.getValue());
		    }
		    System.out.println("all Headers "+allheaders);   
  }
}

		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
