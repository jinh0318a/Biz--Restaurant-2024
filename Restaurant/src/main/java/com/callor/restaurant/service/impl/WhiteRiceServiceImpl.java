package com.callor.restaurant.service.impl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.restaurant.config.DataGoConfig;
import com.callor.restaurant.model.WhiteRice;
import com.callor.restaurant.service.WhiteRiceService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WhiteRiceServiceImpl implements WhiteRiceService {

	@Override
	public List<WhiteRice> whiteRiceList() throws IOException {

		StringBuilder urlBuilder = new StringBuilder(DataGoConfig.WHITERICE_URL); /* URL */
		urlBuilder.append("?serviceKey=" + DataGoConfig.GO_API_KEY); /* Service Key */

		URL url;
		try {
			url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String apiURI = DataGoConfig.WHITERICE_URL;
//		apiURI += "?serviceKey=" + DataGoConfig.GO_API_KEY;
//
//		URI whiteRiceURI = null;
//		try {
//			whiteRiceURI = new URI(apiURI);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
//
//		log.debug(apiURI);
//
//		RestTemplate restTemplate = new RestTemplate();
//
//		restTemplate.getInterceptors().add((request, body, execution) -> {
//			ClientHttpResponse response = execution.execute(request, body);
//			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//			return response;
//		});
//
//		ResponseEntity<WhiteRiceList> whiteRiceListEntity = restTemplate.exchange(whiteRiceURI, HttpMethod.GET, null,
//				WhiteRiceList.class);
//		List<WhiteRiceVO> whiteRiceList = whiteRiceListEntity.getBody().list;
//
//		log.debug("받은데이터 {}", whiteRiceList.toString());

		return null;
	}

}
