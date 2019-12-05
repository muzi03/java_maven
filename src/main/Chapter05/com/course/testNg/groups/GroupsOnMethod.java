package com.course.testNg.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
//测试中的方法分组测试
public class GroupsOnMethod {
	@Test(groups="server")
	public void test1() {
		System.out.println("这是服务端的测试方法1111组！");
	}
	@Test(groups="server")
	public void test2() {
		System.out.println("这是服务端的测试方法2222组！");
	}	
	@Test(groups="client")
	public void test3() {
		System.out.println("这是客户端的测试方法3333组！");
	}	
	@Test(groups="client")
	public void test4() {
		System.out.println("这是客户端的测试方法4444组！");
	}
	@BeforeGroups("server")
	public void beforeGoupsOnServer() {
		System.out.println("这是服务端组运行之前执行！");
	}
	@AfterGroups("server")
	public void afterGoupsOnServer() {
		System.out.println("这是服务端组运行之后执行！！！！！！");
	}
	@BeforeGroups("client")
	public void beforeGoupsOnClient() {
		System.out.println("这是客户端组运行之前执行！");
	}
	@AfterGroups("client")
	public void afterGoupsOnClient() {
		System.out.println("这是客户端组运行之后执行！！！！！！");
	}
}
