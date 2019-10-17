package ecomsite.java.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
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
