package com.course.testNg.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 参数化测试-DataProvider参数化
 * @author Administrator
 *
 */
public class DataProviderTest {
	@Test(dataProvider="data")
	public void testDataProvider(String name,int age) {
		System.out.println("name="+name);
		System.out.println("age="+age);
	}
	@DataProvider(name="data")
	public Object[][] providerDate(){
		Object[][] obj = new Object[][] {
			{"linda",10},
			{"susan",12},
			{"amy",18}
		};
		return obj;
	}
}
