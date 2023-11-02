package com.api.nba.nba.api.test.model;

import java.util.List;

public class Data {

	private List<PlayerData> data;
	private Meta meta;
	public List<PlayerData> getData() {
		return data;
	}
	public void setData(List<PlayerData> data) {
		this.data = data;
	}
	public Meta getMeta() {
		return meta;
	}
	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	

}
