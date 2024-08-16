package com.callor.finedust.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

		String url = "http://openapi.airgwangsan.kr:8080/Gwangsan/getDustDataAPI?apiId=01";

		RestTemplate restTemplate = new RestTemplate();

		// 헤더 설정
		HttpHeaders headers = new HttpHeaders();
		// Accept 헤더 비우기 (헤더를 설정하지 않음)

		// 요청 생성
		HttpEntity<String> entity = new HttpEntity<>(headers);

		// API 호출
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		String jsonResponse = response.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Finedust> finedustList = new ArrayList<Finedust>();
		try {
			ApiResponse apiResponse = objectMapper.readValue(jsonResponse, ApiResponse.class);

			// ApiResponse 객체에서 데이터 추출
			if (apiResponse != null) {
				finedustList = apiResponse.getResponse().getItems();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return finedustList;
	}

}
