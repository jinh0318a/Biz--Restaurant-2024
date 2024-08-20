package com.callor.finedust.service.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.finedust.config.DataGoConfig;
import com.callor.finedust.model.ApiResponse;
import com.callor.finedust.model.Finedust;
import com.callor.finedust.service.FineDustService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FineDustServiceImpl implements FineDustService {

	@Override
	public List<Finedust> findedustList() {
//		String apiURL = DataGoConfig.FINEDUST_URL;
//
//		URI arriveURI = null;
//		try {
//			arriveURI = new URI(apiURL);
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		restTemplate.getInterceptors().add((request, body, execution) -> {
//			ClientHttpResponse response = execution.execute(request, body);
//			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//			return response;
//		});
//
//		ResponseEntity<Finedust> busArriveEntity = restTemplate.exchange(arriveURI, HttpMethod.GET, null,
//				Finedust.class);
//		log.debug(busArriveEntity.toString());

		String url = DataGoConfig.FINEDUST_URL;

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		String jsonResponse = response.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Finedust> finedustList = new ArrayList<Finedust>();
		try {
			ApiResponse apiResponse = objectMapper.readValue(jsonResponse, ApiResponse.class);

			if (apiResponse != null) {
				finedustList = apiResponse.getResponse().getItems();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return finedustList;
	}

	@Override
	public List<Finedust> lastData() {
		String url = DataGoConfig.FINEDUST_URL;

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		String jsonResponse = response.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Finedust> finedustList = new ArrayList<Finedust>();
		try {
			ApiResponse apiResponse = objectMapper.readValue(jsonResponse, ApiResponse.class);

			if (apiResponse != null) {
				finedustList = apiResponse.getResponse().getItems();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

		finedustList.sort((f1, f2) -> {
			LocalDateTime dateTime1 = LocalDateTime.parse(f1.COLLECTION_DATE, formatter);
			LocalDateTime dateTime2 = LocalDateTime.parse(f2.COLLECTION_DATE, formatter);
			return dateTime1.compareTo(dateTime2);
		});

		Map<String, Finedust> latestDataMap = new HashMap<>();

		for (Finedust finedust : finedustList) {
			latestDataMap.put(finedust.place, finedust);
		}

		List<Finedust> lastData = new ArrayList<>(latestDataMap.values());

		return lastData;
	}

}
