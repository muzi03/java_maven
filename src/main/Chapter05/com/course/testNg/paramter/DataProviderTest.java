package com.course.testNg.paramter;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 参数化测试-DataProvider参数化
 * @author Administrator
 *     数据提供者用@打他provider注解方法，
 *     这个annotation只有一个字符串属性：name(它的名称)。若没有提供name,则数据提供者的名称就默认采用方法的名称；
 *     同时可以通过方法名去传递参数
 */
public class DataProviderTest {
	@Test(dataProvider="data",enabled=true)
	public void testDataProvider(String name,int age) {
		System.out.println("name="+name+",age="+age);
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
	@Test(dataProvider="methodData")
	public void test1(String name,int age) {
		System.out.println("test111方法：name="+name+",age="+age);
	}
	@Test(dataProvider="methodData")
	public void test2(String name,int age) {
		System.out.println("test222方法：name="+name+",age="+age);
	}
	@DataProvider(name="methodData")
	public Object[][] methodData(Method method){
		Object[][] result = null;
		
		if(method.getName().equals("test1")) {
			result=new Object[][] {
				{"linda",20},
				{"susan",18}
			};
		}else if(method.getName().equals("test2")) {
			result = new Object[][] {
				{"halen",30},
				{"amy",21}
			};
		}
		return result;
	}
}
