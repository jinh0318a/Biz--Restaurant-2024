package com.callor.finedust.model;

import java.util.List;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
	private Response response;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@Getter
	@Setter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Response {
		private String resultCode;
		private String resultMsg;
		private int totalCount;
		private String dataType;
		private List<Finedust> items;

	}
}
