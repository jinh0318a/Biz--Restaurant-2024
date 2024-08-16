package com.callor.finedust.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.finedust.model.Finedust;
import com.callor.finedust.service.FineDustService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final FineDustService fineDustService;

	public HomeController(FineDustService fineDustService) {
		super();
		this.fineDustService = fineDustService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		List<Finedust> finedustList = fineDustService.lastData();
		model.addAttribute("FINEDUST_LIST", finedustList);

		return "list";
	}

}
