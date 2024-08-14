package com.callor.restaurant.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.restaurant.config.DataGoConfig;
import com.callor.restaurant.model.Mimbap;
import com.callor.restaurant.model.MimbapList;
import com.callor.restaurant.service.MimbapService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MimbapServiceImpl implements MimbapService {

	@Override
	public List<Mimbap> mimBapList() throws IOException {
		// API 요청 URL 구성
		StringBuilder urlBuilder = new StringBuilder(DataGoConfig.MimbapList_URL); /* URL */
		urlBuilder.append("?serviceKey=" + DataGoConfig.GO_API_KEY); /* 서비스키 */

		URL url = new URL(urlBuilder.toString());
		System.out.println(url);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		// Accept 헤더를 설정하여 JSON 응답을 요청
		conn.setRequestProperty("Accept", "application/json");

		URI uri = null;
		try {
			uri = new URI(url.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 응답 코드 출력
		System.out.println("Response code: " + conn.getResponseCode());

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getInterceptors().add((request, body, execution) -> {
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});

		// API 요청 및 응답을 MimbapList 객체로 변환
		ResponseEntity<MimbapList> responseEntity = restTemplate.getForEntity(uri, MimbapList.class);

		List<Mimbap> mimBapList = responseEntity.getBody().items;

		log.debug("받은데이터 {}", mimBapList.toString());

		return null;
	}

}
