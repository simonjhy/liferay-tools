package com.liferay.tools.sass.api;

public enum SourceComments {
	NONE(0), DEFAULT(1), MAP(2);
	
	
	int value;
	private SourceComments(int value) {
		this.value=value;
	}
	public int value() {
		return value;
	}
}
