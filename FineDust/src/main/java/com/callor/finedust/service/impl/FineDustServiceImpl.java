package com.callor.finedust.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.finedust.config.DataGoConfig;
import com.callor.finedust.model.Finedust;
import com.callor.finedust.service.FineDustService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FineDustServiceImpl implements FineDustService {

	@Override
	public List<Finedust> findedustList() {
		String apiURL = DataGoConfig.FINEDUST_URL;

		URI arriveURI = null;
		try {
			arriveURI = new URI(apiURL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getInterceptors().add((request, body, execution) -> {
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});

		ResponseEntity<Finedust> busArriveEntity = restTemplate.exchange(arriveURI, HttpMethod.GET, null,
				Finedust.class);
		log.debug(busArriveEntity.toString());

		return null;
	}

}
