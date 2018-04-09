package ca.wet.play.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ca.wet.model.FormBean03;
import ca.wet.model.SubformBean01;
import ca.wet.model.Enum01;
import ca.wet.stsm.business.entities.SeedStarter;
import ca.wet.user.model.User;
import ca.wet.user.service.UserService;

@Controller
@RequestMapping(value = "/play")
@SessionAttributes("formBean03")
public class MyController {
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);
	@Autowired
	private UserService userService;

	@ModelAttribute("allFeatures")
	public List<Integer> populateFeatures() {
		return Arrays.asList(1, 2);
	}
	
	@ModelAttribute("formBean03")
	public FormBean03 addStuffToRequestScope() {
		System.out.println("Inside of addStuffToRequestScope");
		FormBean03 bean = new FormBean03();
		bean.setId("999");
		return bean;
	}
 

	@ModelAttribute("subformBean01")
	public SubformBean01 getSubformBean01FromSession() {
		SubformBean01 bean = new SubformBean01();
		bean.setFeatures("1");
		return bean;
	}
	//
	// @ModelAttribute("formBean03")
	// public SubformBean01 getFormBean03FromSession() {
	// FormBean03
	// return new SubformBean01();
	// }

	@RequestMapping(value = "/p1", method = RequestMethod.GET)
	public String loadP1(Model model, HttpServletRequest request, HttpSession session) {

		System.out.println("--- Model data ---");
		Map modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}

		System.out.println("=== Request data ===");
		java.util.Enumeration reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = (String) reqEnum.nextElement();
			System.out.println(s);
			System.out.println("==" + request.getAttribute(s));
		}

		System.out.println("*** Session data ***");
		java.util.Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
			System.out.println("**" + session.getAttribute(s));
		}

		// subformBean01.setEnum01Choice(Enum01.TWO);

		return "page1";
	}

	@RequestMapping(value = "/searchUsers", method = RequestMethod.GET)
	public String showGuestList(Model model) {
		model.addAttribute("users", userService.getAllUsersMock());

		return "results :: resultsList";
	}

	@RequestMapping(value = "/removeRange", method = RequestMethod.GET)
	public String removeGuestList(Model model) {
		model.addAttribute("users", null);

		return "";
	}
}
