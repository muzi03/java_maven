package mavenDemo.Chapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Hello world!
 *
 */
public class  TestJunit 
{
	@Test
	public void test1() {
		System.out.println("test1");
	}
	@Test
	public void test2() {
		System.out.println("test2");
	}
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("在类之前运行的代码！");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("在类之后运行的代码！");
	}
}
