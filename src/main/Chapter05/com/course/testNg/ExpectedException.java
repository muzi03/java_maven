package com.course.testNg;

import javax.management.openmbean.OpenDataException;

import org.testng.annotations.Test;

/**
 * @author Administrator
 *什么时候会用到异常测试？
 *在期望结果为某一个异常的时候，比如：我们传入一些非法的参数程序抛出了异常
 *也就是说我的预期结果就是这个异常
 *那么就会引用到这个异常测试
 */

//这是一个测试结果会失败的异常测试
public class ExpectedException {
	@Test(expectedExceptions=RuntimeException.class)
	public void runTime() {
		System.out.println("这是一个失败的异常测试！");
	}
	
//这是一个成功的异常测试
	@Test(expectedExceptions=OpenDataException.class)
	public void runTimeExceptionSuccess() throws OpenDataException {
		System.out.println("这是我的异常测试");
		throw new OpenDataException();
	}
}
