package com.revature.JavaDoodleDuels.web.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.JavaDoodleDuels.services.UserService;

import org.json.JSONObject;
@RestController
@RequestMapping("/UserService")
public class LoginServlet extends HttpServlet{
	
	private final UserService userService;
	
	public LoginServlet(UserService userService) {
		this.userService = userService;
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			String credentials = new JSONObject()
					.put("email",email)
					.put("password", password)
					.toString();
		try {
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
