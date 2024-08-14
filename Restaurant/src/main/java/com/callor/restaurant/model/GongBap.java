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
public class GongBap {
	public String foodUid; // 데이터번호
	public String mainMenu; // 메뉴명
	public String newAddr; // 주소
	public String mainImgUrl; // 메인이미지url
	public String openDay; // 개업일
	public String holiday; // 휴무일
	public String tel; // 대표전화
	public String openTime; // 영업시작시간
	public String closeTime; // 영업종료시간
	public String isReserve; // 예약여부
	public String tableCnt; // 테이블좌적수
	public String seatCnt; // 룸좌석수
	public String isPaking; // 주차여부
	public String parkingDetail; // 주차상세정보
	public String posy; // 위도
	public String posx; // 경도
	public String storeNm; // 업체명

}
