package com.course.httpclient.demo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class MyHttpClient {
	@Test
	public void test1() throws ClientProtocolException, IOException {
		//用来存放返回的结果
		String result;
		//创建一个get请求对象
		HttpGet get = new HttpGet("http://www.baidu.com");
		//创建一个client来处理get请求
		CloseableHttpClient client2 = HttpClients.createDefault();
		//将client执行后的对象放在response 结果里
		CloseableHttpResponse response = client2.execute(get);
		//将获取的内容转换成字符进行存放
		result = EntityUtils.toString(response.getEntity(),"utf-8");
		System.out.println(result);//打印出字符串结果
	}
}
