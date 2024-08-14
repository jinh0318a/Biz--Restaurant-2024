package com.callor.finedust.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Finedust {
	public String place; // : 하남동 홈플러스 하남점,
	public String PM1; // : 11.5,
	public String PM10; // : 14.6 미세먼지
	public String PM2_5; // : 12.6 초미세먼지
	public String CO2; // : 459.0,
	public String TEMPERATURE; // : 42.0,
	public String HUMIDITY; // : 35.5,
	public String LATITUDE; // : 35.17861940,
	public String LONGITUDE; // : 126.8066483,
	public String COLLECTION_DATE; // : 2024-08-14 16:20:59.0
}
