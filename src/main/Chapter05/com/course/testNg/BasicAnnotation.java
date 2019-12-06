package com.course.testNg;
/**
 * 注解实战@test 标签
 * 注解实战beforeMethod和AfterMethod，每个测试方法执行之前都会被执行
 * 场景用在：测试方法之前必须要运行的东西可以写在该注解方法中
 * 注解实战beforeClass 和AfaterClass
 * 场景用在：类是否在执行前是否需要注册一些对象、或者静态的方法或变量赋值
 * 注解实战BeforeSuite和AfterSuite,在类运行之前和运行之后被执行的
 * 场景用在：suite包含多个class
 * @author Administrator
 *
 */

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicAnnotation {
	@Test
	public void testCase1() {
		System.out.printf("Thread id:%s%n",Thread.currentThread().getId());
		System.out.println("这是测试用例1");
	}
	@Test
	public void test2() {
		System.out.printf("Thread id:%s%n",Thread.currentThread().getId());
		System.out.println("这是测试用例2");
	}
	@BeforeMethod
	public void before() {
		System.out.println("@BeforeMethod这是在测试方法之前运行的");
	}
	@AfterMethod
	public void after() {
		System.out.println("@AfterMethod这是在测试方法之后运行的");
	}	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass在类之前运行的代码！");
	}	
	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass在类之后运行的代码！");
	}
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite测试套件");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite测试套件");
	}
}
