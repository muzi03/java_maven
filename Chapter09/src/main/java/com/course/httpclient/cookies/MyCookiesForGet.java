package com.course.httpclient.cookies;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForGet {
	//定义url存放url
	private String url;
	//利用bunndle来读取配置文件
	private ResourceBundle bundle;
	
	@BeforeTest
	public void beforeTest() {
		//获取文件配置名，并规定为中文
		bundle=ResourceBundle.getBundle("resource/application",Locale.CHINA);
		url = bundle.getString("test.url");
	}
	@Test
	public void testGetCookies() throws ClientProtocolException, IOException {
		String result;
		//从配置文件中 拼接测试的url
		String uri = bundle.getString("getCookies.uri");
		String testUrl = this.url+uri;
		//测试逻辑代码书写
		HttpGet get = new HttpGet(testUrl);
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = client.execute(get);
		result =EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(result);
	}
}
