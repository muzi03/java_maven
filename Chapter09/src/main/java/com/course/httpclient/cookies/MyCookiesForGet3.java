package com.course.httpclient.cookies;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForGet3 {
	//定义url存放url
	private String url;
	//利用bunndle来读取配置文件
	private ResourceBundle bundle;
	//用来存储cookies信息的变量
	private CookieStore store;
	
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
		String uri = bundle.getString("test.getCookies.uri");
		String testUrl = this.url+uri;
		//测试逻辑代码书写
		HttpGet get = new HttpGet(testUrl);
		
		//新建一个store变量，用于获取clinet中的cookies信息
		this.store = new BasicCookieStore();
		
		//设置cookie
		CloseableHttpClient client = 
				HttpClients.custom().setDefaultCookieStore(store).build();
		CloseableHttpResponse response = client.execute(get);
		
		//将返回的结果存储在result中
		result =EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(result);
		
		//获取cookie信息
		//将store的数据保存为List
		List<Cookie> cookieList=store.getCookies();
		
		//for循环，为所有cookie的key和value赋值
		for(Cookie cookie:cookieList) {
			String name = cookie.getName();
			String value = cookie.getValue();
			//打印结果
			System.out.println("cookie name="+ name+"; cook value ="+value);
		}
	}
	
	//依赖测试获取到cookie后再进行后续测试
	@Test(dependsOnMethods= {"testGetCookies"})
	public void testGetWithCookies() throws ClientProtocolException, IOException {
		String uri = bundle.getString("test.get.with.cookies");
		String testUrl = this.url+uri;
		HttpGet get = new HttpGet(testUrl);
		//设置cookie
		CloseableHttpClient client = 
				HttpClients.custom().setDefaultCookieStore(store).build();
		
		HttpResponse response = client.execute(get);
		//获取响应的状态码
		int statusCode=response.getStatusLine().getStatusCode();
		System.out.println("statusCode="+statusCode);
		
		if (statusCode == 200) {
			//如果状态为200就返回响应结果
			String result = EntityUtils.toString(response.getEntity(),"utf-8");
			System.out.println(result);
		}
	}
}
