package ecomsite.java.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


	

	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "index";
	}
	
	

	/*
	 * @RequestMapping("/spring_security_login") public String
	 * authorizer(HttpSession session) { session.setAttribute("time", "" + new
	 * Timestamp(new Date().getTime())); return "authority"; }
	 * 
	 * @RequestMapping("/j_spring_security_check") public String authorizer() {
	 * return "security"; }
	 * 
	 * @RequestMapping("/authority") public String authorizer2(HttpSession session)
	 * { session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
	 * return "authority"; }
	 */
	

	

}
