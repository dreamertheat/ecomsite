package ecomsite.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecomsite.java.dbmodels.AboutModel;
import ecomsite.java.services.AboutService;

@Controller
public class AboutController {

	AboutService service;

	@Autowired
	public AboutController(AboutService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/about", params = { "layer" })
	public synchronized ModelAndView about(@Valid @ModelAttribute AboutModel aboutModel, BindingResult result,
			ModelMap model, @RequestParam(value = "layer") String layer) {
		
		if (result.hasErrors()) {
			System.out.println("errors " + result.getErrorCount());
			// return new ModelAndView("error");
		}
		// handle create
		if (layer.equalsIgnoreCase("add_about")) {
			try {
				service.getAboutdao().createAbout(aboutModel);
			} catch (DataAccessException e) {
				System.out.println(e);
			}
		}
		// handle delete
		if (layer.contains("delete_about")) {
			System.out.println("deletion!");
			try {

				int _id = Integer.parseInt("" + layer.replaceAll("[^0-9]", ""));

				service.getAboutdao().deleteAbout(_id);
				
			} catch (DataAccessException e) {
				System.out.println(e);
			}
		}
		System.out.println("error is " + layer);
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
		return view;
	}
}