package com.callor.restaurant.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.restaurant.service.ImageService;
import com.callor.restaurant.service.MimbapService;
import com.callor.restaurant.service.WhiteRiceService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final ImageService imageService;
	private final WhiteRiceService whiteRiceService;
	private final MimbapService mimbapService;

	public HomeController(ImageService imageService, WhiteRiceService whiteRiceService, MimbapService mimbapService) {
		super();
		this.imageService = imageService;
		this.whiteRiceService = whiteRiceService;
		this.mimbapService = mimbapService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws MalformedURLException, IOException {
		mimbapService.mimBapList();
		return "home";
	}

}
