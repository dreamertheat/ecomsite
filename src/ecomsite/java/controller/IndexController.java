package ecomsite.java.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("time", ""+new Timestamp(new Date().getTime())) ;
		return "index";
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView view = new ModelAndView("about");
			Map<String,String> map = new HashMap<>();
			map.put("about", "some text about");
			view.addAllObjects(map);
			return view;
	}
	
}
