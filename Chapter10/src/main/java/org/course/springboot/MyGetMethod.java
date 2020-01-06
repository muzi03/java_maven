package org.course.springboot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import io.swagger.annotations.Api;

@RestController
@Api(value="/",produces="这是我全部的get方法")
public class MyGetMethod {
	@RequestMapping(value="/getCookies",method=RequestMethod.GET)
	public String getCookies(HttpServletResponse response) {
		//httpServerletRequest 装请求信息的类
		//HttpServerletResponse 装响应信息的类
		Cookie cookie =new Cookie("login", "true");
		response.addCookie(cookie);
		return "恭喜你获得cookies成功";
	}
	/**
	 * 要求客户端携带cookies访问
	 * 这是一个需要携带cookies信息才能访问的get请求
	 */
	@RequestMapping(value="/get/with/cookies",method = RequestMethod.GET)
	public String getWithCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		//判断cookies对象不为空
		if (Objects.isNull(cookies)) {
			return "你必须携带cookies信息";
		}
		for(Cookie cookie:cookies) {
			if (cookie.getName().equals("login")&& 
					cookie.getValue().equals("true")) {
				return "恭喜你携带cookies访问成功！";
			}
		}
		return "你必须携带cookies信息";
	}
	/**
	 * 开发一个需要携带参数才能访问的get请求
	 * 第一种实现方式：url:key=value&key=value
	 * 模拟获取商品列表
	 */
	@RequestMapping(value="/get/with/param",method= RequestMethod.GET)
	public Map<String, Integer> getGoodsList(@RequestParam Integer start,
			@RequestParam Integer end){
		Map<String, Integer> goodslist =new HashMap<>();
		
		goodslist.put("苹果", 59);
		goodslist.put("猕猴桃", 99);
		goodslist.put("哈密瓜", 29);
		
		return goodslist;
	}
	/**
	  * 开发一个需要携带参数才能访问的get请求
	 * 第二种实现方式：url:ip:port/get/with/param/10/20
	 * 模拟获取商品列表
	 */
	@RequestMapping(value="/get/with/param/{start}/{end}",method= RequestMethod.GET)
	public Map<String, Integer> getgoodsList1(@PathVariable Integer start,
			@PathVariable Integer end) {
		Map<String, Integer> goodslist = new HashMap<>();
		goodslist.put("苹果", 59);
		goodslist.put("猕猴桃", 99);
		goodslist.put("哈密瓜", 29);
		return goodslist;
	}
}
