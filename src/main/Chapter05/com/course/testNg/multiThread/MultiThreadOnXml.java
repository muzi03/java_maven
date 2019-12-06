package com.course.testNg.multiThread;

import org.testng.annotations.Test;

/**
 * 多线程测试-xml文件实现
 * @author Administrator
 *
 */
public class MultiThreadOnXml {
	@Test
	public void thread1() {
		System.out.printf("Thread id:%s%n",Thread.currentThread().getId());
	}
	@Test
	public void threa2() {
		System.out.printf("Thread ID:%s%n", Thread.currentThread().getId());
	}
	@Test
	public void thread3() {
		System.out.printf("Thread ID:%s%n", Thread.currentThread().getId());
	}

}
