package com.callor.restaurant.service;

import java.io.IOException;
import java.util.List;

import com.callor.restaurant.model.WhiteRice;

public interface WhiteRiceService {
	public List<WhiteRice> whiteRiceList() throws IOException;
}
