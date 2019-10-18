package ecomsite.java.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomsite.java.dbmodels.UsersModel;

@Controller
public class IndexController {
	
	private UsersModel model;
	
	
	@Autowired
	public void setModel(UsersModel model) {
		this.model = model;
	}

	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "index";
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		
		ModelAndView view = new ModelAndView("about");
		Map<String, String> map = new HashMap<>();
		map.put("about", "some text about");
		map.put("corporation", "model "+model.getNotes());
		view.addAllObjects(map);
		return view;
	
	}

}
