package com.callor.finedust.service;

import java.util.List;

import com.callor.finedust.model.Finedust;

public interface FineDustService {
	public List<Finedust> findedustList();

	public List<Finedust> lastData();
}
