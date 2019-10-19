package ecomsite.java.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecomsite.java.dbmodels.AboutModel;
import ecomsite.java.dbmodels.UsersModel;
import ecomsite.java.services.AboutService;

@Controller
public class IndexController {
	
	private AboutService service;
	
	@Autowired
	public void setService(AboutService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("time", "" + new Timestamp(new Date().getTime()));
		return "index";
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		List<AboutModel> models = service.getModels();
		ModelAndView view = new ModelAndView("about");
		Map<String, Object> map = new HashMap<>();
		System.out.println("-"+models.get(0).getAbout());
		map.put("about", "-"+models.get(0).getAbout());
		map.put("corporation", "-"+models.get(0).getCorporation());
		map.put("service", models);
		view.addAllObjects(map);
		return view;
	}

}
