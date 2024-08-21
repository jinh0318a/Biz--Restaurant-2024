package com.callor.finedust.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	// 홈
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@RequestParam(name = "station", required = false, defaultValue = "") String station,
			Model model) {
		List<Finedust> finedustList = new ArrayList<Finedust>();
		if (station == null || station.isBlank()) {
			finedustList = fineDustService.lastData();
		} else {
			for (Finedust one : fineDustService.lastData()) {
				if (one.place.contains(station)) {
					finedustList.add(one);
				}
			}
		}

		model.addAttribute("FINEDUST_LIST", finedustList);

		return "list";
	}

	// 디테일
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam(name = "place", required = false, defaultValue = "") String place, Model model) {
		List<Finedust> finedustList = fineDustService.findedustList();

		List<Finedust> searchList = new ArrayList<Finedust>();

		for (Finedust one : finedustList) {
			if (one.place.equals(place)) {
				searchList.add(one);
			}
		}
		model.addAttribute("FINEDUST_LIST", searchList);

		return "detail";
	}

	// 한눈에 보기
	@RequestMapping(value = "/once", method = RequestMethod.GET)
	public String once(Model model) throws JsonProcessingException {
		List<Finedust> finedustList = fineDustService.lastData();

		double PM10 = 0;
		double PM2_5 = 0;
		double humidity = 0;
		double CO2 = 0;

		for (Finedust one : finedustList) {
			PM10 += Double.valueOf(one.PM10);
			PM2_5 += Double.valueOf(one.PM2_5);
			humidity += Double.valueOf(one.HUMIDITY);
			CO2 += Double.valueOf(one.CO2);
		}

		PM10 = PM10 / finedustList.size();
		PM2_5 = PM2_5 / finedustList.size();
		humidity = humidity / finedustList.size();
		CO2 = CO2 / finedustList.size();

		String PM10Avg = String.format("%.2f", PM10);
		String PM2_5Avg = String.format("%.2f", PM2_5);
		String humidityAvg = String.format("%.2f", humidity);
		String CO2Avg = String.format("%.2f", CO2);

		ObjectMapper objectMapper = new ObjectMapper();
		String finedustListJson = objectMapper.writeValueAsString(finedustList);

		model.addAttribute("finedustList", finedustListJson);
		model.addAttribute("PM10", PM10Avg);
		model.addAttribute("PM2_5", PM2_5Avg);
		model.addAttribute("HUMIDITY", humidityAvg);
		model.addAttribute("CO2", CO2Avg);

		return "once";
	}

}
