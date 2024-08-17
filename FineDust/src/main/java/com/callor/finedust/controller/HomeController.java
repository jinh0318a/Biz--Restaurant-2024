package com.callor.finedust.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.finedust.model.Finedust;
import com.callor.finedust.service.FineDustService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@GetMapping("/detail")
	public String detail(Model model) throws JsonProcessingException {
		List<Finedust> finedustList = fineDustService.lastData();

		// Convert list to JSON string
		ObjectMapper objectMapper = new ObjectMapper();
		String finedustListJson = objectMapper.writeValueAsString(finedustList);

		// Add JSON string to model
		model.addAttribute("finedustList", finedustListJson);

		return "detail";
	}

}
