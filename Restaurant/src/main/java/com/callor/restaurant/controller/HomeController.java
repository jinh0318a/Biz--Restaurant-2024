package com.callor.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.restaurant.service.ImageService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final ImageService imageService;

	public HomeController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		imageService.imageList();
		return "home";
	}

}
