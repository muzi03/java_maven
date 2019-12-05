package com.course.testNg;

import org.testng.annotations.Test;

public class IgnoreTest {
	@Test
	public void ignore1() {
		System.out.println("ignore1 运行！");
	}
	//忽略测试
	@Test(enabled=false)
	public void ignore2() {
		System.out.println("ignore2 运行！");
	}
	@Test(enabled=true)
	public void ignore3() {
		System.out.println("ignore3 运行！");
	}
}
