package org.odds.learn.mentor_demo.util;

public enum SHAMode {
	SHA256("SHA-256", 0),
	SHA512("SHA-512", 1);

	private String label;
	private int i;

	SHAMode(String label, int i) {
		this.label = label;
		this.i = i;
	}

	public String getLabel() {
		return label;
	}

	public int getIndex() {
		return i;
	}
}
