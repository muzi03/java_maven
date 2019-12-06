package com.course.testNg.multiThread;

import org.testng.annotations.Test;

/**
 * 多线程测试--注解方式实现
 * @author Administrator
 *
 */
public class MultiThreadOnAnnotion {
//注解参数中的invocationCount 标识执行次数，	threadPoolSize 表示线程数 timeOut 表示超时时间
	@Test(invocationCount=10,threadPoolSize=3)
	public void test() {
		System.out.println(1);
		//%s格式化的字符串  %n是换行符
		System.out.printf("Thread id:%s%n",Thread.currentThread().getId());
	}
	
}
