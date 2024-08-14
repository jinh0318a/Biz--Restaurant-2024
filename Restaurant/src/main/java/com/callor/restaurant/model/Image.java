package com.callor.restaurant.model;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Image {
	public String foodUid; // 데이터번호
	public String siteUid; // 사이트번호
	public String privewUrl; // 원본이미지경로

}
