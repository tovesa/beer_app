package org.beer.app.dao;

public enum DataStorage {
	RAMDIRECTORY("ramDirectory"), ELASTICSEARCH("elasticsearch"), MONGO("mongo");
	private String value;

	private DataStorage(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
