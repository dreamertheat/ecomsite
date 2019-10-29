package ecomsite.java.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	private static Logger logger = Logger.getLogger(IndexController.class);
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		logger.debug("index");
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "index";
	}
	
	@RequestMapping("/logged_out")
	public String logged_out(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "logged_out";
	}

	@RequestMapping("/access_denied")
	public String access_denied(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "access_denied";
	}

	@RequestMapping("/logs")
	public String logs(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "logs";
	}

	@RequestMapping("/spring_security_login")
	public String authorizer(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "authority";
	}

	@RequestMapping("/j_spring_security_check")
	public String authorizer() {
		return "security";
	}

	@RequestMapping("/authority")
	public String authorizer2(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "authority";
	}

}
