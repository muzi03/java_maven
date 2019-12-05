package com.course.testNg.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化测试-xml文件参数化
 * @author Administrator
 * 
 */
public class ParamterTest {
	@Test
	@Parameters({"name","age"})
	public void paramTest(String name,int age) {
		System.out.println("name="+name);
		System.out.println("age="+age);
	}

}
