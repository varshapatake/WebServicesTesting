package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import junit.framework.Assert;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.BaseClass;
import com.qa.client.RestClient;
import com.qa.data.Users;
import com.qa.util.Utility;

public class TestPostWebService extends BaseClass{
	String Baseurl;
	String serviceUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	BaseClass base;
@BeforeMethod
public void setUp()
{   
	base=new BaseClass();
	Baseurl=prop.getProperty("url");
	serviceUrl=prop.getProperty("serviceUrlPost");
	url=Baseurl+serviceUrl;
}
  @Test
  public void testPostApi() throws JsonGenerationException, JsonMappingException, IOException {
	  restClient=new RestClient();
	  HashMap<String,String> headerMap=new HashMap<String,String>();
      headerMap.put("Content-Type","application/json");
      
      //jackson Api
      ObjectMapper mapper = new ObjectMapper();
      Users user=new Users("morphis","leader");
      //writting json into file
      mapper.writeValue(new File("D:\\VarshaWithNaveenSelenium\\WebServicesTesting\\RestApiTesting\\src\\main\\java\\com\\qa\\data\\users.json"),user);
      
      //convert json object to string
      String jsonobject=mapper.writeValueAsString(user);
      System.out.println(jsonobject);
      
      closeableHttpResponse=restClient.post(url, jsonobject, headerMap);
      int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
      System.out.println("value of status code is--->"+statusCode);
      Assert.assertEquals(statusCode, 201);
       
      String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
      JSONObject ResponsejsonObject=new JSONObject(responseString);
	  System.out.println("Response Body"+ResponsejsonObject);
	  
	  String name=Utility.getValueByPath(ResponsejsonObject,"/name");
	  System.out.println("value of name is--->"+name);
	  Assert.assertEquals(name, "morphis");
	  
	  String job=Utility.getValueByPath(ResponsejsonObject,"/job");
	  System.out.println("value of job is--->"+job);
	  Assert.assertEquals(job, "leader");
  }
}
