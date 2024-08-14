package com.callor.restaurant.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.callor.restaurant.config.DataGoConfig;
import com.callor.restaurant.model.ImageVO;
import com.callor.restaurant.service.ImageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

	@Override
	public List<ImageVO> imageList() {
		String apiURI = DataGoConfig.IMAGES_URL;
		apiURI += "?serviceKey=" + DataGoConfig.GO_API_KEY;

		URI imgURI = null;
		try {
			imgURI = new URI(apiURI);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getInterceptors().add((request, body, execution) -> {
			ClientHttpResponse response = execution.execute(request, body);
			response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
			return response;
		});

		ResponseEntity<ImageVO> imgListEntity = restTemplate.exchange(imgURI, HttpMethod.GET, null, ImageVO.class);
		List<ImageVO> imgList = (List<ImageVO>) imgListEntity;

		log.debug("받은데이터 {}", imgList.toString());

		return null;
	}

}
