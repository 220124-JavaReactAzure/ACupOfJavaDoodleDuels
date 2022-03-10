//package com.revature.JavaDoodleDuels.web.servlets;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.core.exc.StreamReadException;
//import com.fasterxml.jackson.databind.DatabindException;
//import com.revature.JavaDoodleDuels.services.UserService;
//
//import org.json.JSONObject;
//@RestController
//@RequestMapping("/UserService")
//public class LoginServlet extends HttpServlet{
//	
//	private final UserService userService;
//	
//	public LoginServlet(UserService userService) {
//		this.userService = userService;
//	}
//	
//	
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
//		
//			String email = req.getParameter("email");
//			String password = req.getParameter("password");
//			
//			String credentials = new JSONObject()
//					.put("email",email)
//					.put("password", password)
//					.toString();
//		try {
//			boolean wasValidated = userService.authenticatedUser(email, password);
//			
//			if(wasValidated) {
//				resp.setStatus(200);
//				resp.getWriter().write("User Validated");
//				resp.sendRedirect(homeServlet);
//			}else {
//				resp.setStatus(403);
//				resp.getWriter().write("Invalid username or password, try again");
//				resp.sendRedirect("/LoginServlet");
//			}
//			
//			
//		} catch (StreamReadException | DatabindException e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}catch(Exception e) {
//			resp.setStatus(500);
//			e.printStackTrace();
//		}
//	}
//}
