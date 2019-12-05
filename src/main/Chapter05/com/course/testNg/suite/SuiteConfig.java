package com.course.testNg.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//测试套件前需要运行的方法（共有的）
public class SuiteConfig {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite running!");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite running!");
	}
	@BeforeTest
	public void BeforeTest(){
		System.out.println("before test running!");
	}
	@AfterTest
	public void afterTest() {
		System.out.println( "After Test running!");
	}

}
