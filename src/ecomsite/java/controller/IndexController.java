package ecomsite.java.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ecomsite.java.dbmodels.AboutModel;
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

	@RequestMapping(value = "/about")
	public ModelAndView about(@Valid @ModelAttribute AboutModel aboutModel, BindingResult result, ModelMap model) {
		// viewing
		List<AboutModel> models = service.getModels();
		ModelAndView view = new ModelAndView("about");
		Map<String, Object> map = new HashMap<>();
		System.out.println("-" + models.get(0).getAbout());
		map.put("about", "-" + models.get(0).getAbout());
		map.put("corporation", "-" + models.get(0).getCorporation());
		map.put("service", models);
		view.addAllObjects(map);
		
		// adding data
		model.addAttribute("aboutModel", aboutModel);
		model.addAttribute("name", aboutModel.getName());
		model.addAttribute("description", aboutModel.getDescription());
		model.addAttribute("sequence", aboutModel.getSequence());
		if (result.hasErrors()) {
			System.out.println("errors "+result.getErrorCount());
			//return new ModelAndView("error");
		}
		try {
			service.getAboutdao().createAbout(aboutModel);
		}catch(DataAccessException e) {
			System.out.println(e);
		}
		return view;
	}

	

}
