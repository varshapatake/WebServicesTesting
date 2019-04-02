package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {
    public Properties prop;
	public BaseClass() 
	{
		try{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D://VarshaWithNaveenSelenium//WebServicesTesting//RestApiTesting//src//main//java//com//qa//config//config.properties");
			prop.load(ip);
			System.out.println(prop.get("url"));
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
