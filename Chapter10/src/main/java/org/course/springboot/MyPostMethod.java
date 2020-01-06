package org.course.springboot;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.course.bean.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="/",produces="这是我全部的post请求")
@RequestMapping("/v1")//这个类下面的所有方法前都要加一个v1
public class MyPostMethod {
	//这个变量是用来装我们的cookies信息
	private static Cookie cookie;
	
	
	//模拟用户登陆成功获取到cookies，然后在访问其他接口获取到列表
	
	@RequestMapping(value = "login",method=RequestMethod.POST)
	@ApiOperation(value="登录接口，成功后获取cookies信息",httpMethod="POST")
	public String login(HttpServletResponse response,
			@RequestParam(value="userName",required = true) String username,
			@RequestParam(value="password",required = true) String password) {
		if (username.equals("lisa") && password.equals("123456")) {
			cookie=new Cookie("login","true");
			response.addCookie(cookie);
			return "success!";
		}
		return "用户名或密码错误！";
	}
	
	@RequestMapping(value="/getUserList",method=RequestMethod.POST)
	@ApiOperation(value="获取用户列表",httpMethod="POST")
	public String getUserList(HttpServletRequest request,
			@RequestBody User u) {
		//获取cookies
		User user;
		Cookie[] cookies=request.getCookies();
		//验证cookies是否合法
		for(Cookie c : cookies) {
			if (c.getName().equals("login") 
				&& c.getValue().equals("true")
				&& u.getUserName().equals("lisa")
				&& u.getPassword().equals("123456")) {
				user = new User();
				user.setName("lisa");
				user.setAge("18");
				user.setSex("man");
				return user.toString();
			}
		}
		return "参数不合法";
	}
	
}
