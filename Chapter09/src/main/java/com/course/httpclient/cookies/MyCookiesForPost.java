package com.course.httpclient.cookies;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCookiesForPost {
	//用来存放读取配置文件的url
	private String url;
	//声明一个bundle变量用于获取配置文件的资源
	private ResourceBundle bundle;
	//用来存储cookie信息的变量
	private CookieStore store;
	
	@BeforeTest
	public void befroeTest() {
		bundle = ResourceBundle.getBundle("resource/application",Locale.CHINA);
		url=bundle.getString("test.url");
	}
	@Test
	public void testCookieForPost() throws ClientProtocolException, IOException {
		String uri = bundle.getString("test.getCookies.uri");
		String testUrl =this.url+uri;
		//设置请求方式和类型
		HttpGet get = new HttpGet(testUrl);
		//声明一个变量，用于获取client中的cookie信息
		this.store = new BasicCookieStore();
		//创建client对象
		CloseableHttpClient client= 
				HttpClients.custom().setDefaultCookieStore(store).build();
		//执行请求
		CloseableHttpResponse response = client.execute(get);
		EntityUtils.toString(response.getEntity());
		List<Cookie> list = this.store.getCookies();
		System.out.println(list);
		for(Cookie cookie:list) {
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println("cookie name = "+name+",cookie value = "+value);
		}
	}
	
	
	@Test(dependsOnMethods= {"testCookieForPost"})
	public void testPostMethod() throws ClientProtocolException, IOException, InterruptedException {
		String uri = bundle.getString("test.post.with.cookies");
		//拼接URL
		String testUrl = this.url+uri;
		//声明一个client对象，设置cookies信息用来进行方法的执行
		CloseableHttpClient client = 
				HttpClients.custom().setDefaultCookieStore(this.store).build();

		//声明一个方法，这个方法是post方法
		HttpPost post = new HttpPost(testUrl);
		
		//添加参数,生成json对象
		JSONObject param = new JSONObject();
		param.put("name", "lisa");
		param.put("age", "18");
		System.out.println(param);
		
		//设置请求头信息,设置header信息
		post.setHeader("content-type","application/json");
		
		//将参数信息添加到方法中	
		StringEntity entity = new StringEntity(param.toString(),"utf-8");
//		entity.setContentType(ContentType.APPLICATION_JSON.toString());
		post.setEntity(entity);

		//声明一个对象来进行响应结果的存储
		String results;
		
		//执行post方法
		CloseableHttpResponse response = client.execute(post);
		System.out.println("响应结果："+response);

		//获取响应结果
		results=EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println("results:"+results);
		
		//处理结果，判断返回结果是否符合预期
		//1、将返回的响应结果字符串转化成为json对象
		JSONObject resultjson = new JSONObject(results);
		
		//2、获取到结果值
		String success = (String) resultjson.get("lisa");
		String status = (String) resultjson.get("status");
		
		//3、具体的判断返回结果的值
		Assert.assertEquals("success", success);
		Assert.assertEquals("1", status);
	}
}
