package com.callor.go.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BusArrive {
	public String ARRIVE; // 레코드 구분
	public String LINE_ID; // 노선 ID 3 1 1
	public String LINE_NAME; // 노선 명 40 1 순환01
	public String BUS_ID; // 버스 ID 6 1 775243
	public String METRO_FLAG; // 광역 노선 구분 2 1 0 0: 광주,1:나주, 2:담양, 3:장성, 4:화순
	public String CURR_STOP_ID; // 현재 정류소 ID 5 1 92
	public String BUSSTOP_NAME; // 현재 정류소 명칭 (국문) 30 1 광주역육교
	public String REMAIN_MIN; // 도착 예정 시간 2 1 8
	public String REMAIN_STOP; // 남은 정류소 개수 2 1 5
	public String DIR_START; // 기점명 30 1 상무지구
	public String DIR_END; // 종점명 30 1 상무지구
	public String LOW_BUS; // 저상버스 2 1 0
	public String ENG_BUSSTOP_NAME; // 현재 정류소 위치 (영문) 60 1 GwangjuStation Overpass
	public String ARRIVE_FLAG; // 곧도착 FLAG 2 1 0 0: 일반, 1:곧도착
	public String LINE_KIND; // 노선 구분 2 1 0 1:급행간선2:간선 3:지,4:마을버스 5:공항버스

}
