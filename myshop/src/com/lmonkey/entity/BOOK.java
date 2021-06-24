package com.lmonkey.entity;

public class BOOK {
	private int BOOK_ID;
	private String BOOK_NAME;
	private int BOOK_PRICE;
	private String BOOK_FILENAME;

	public BOOK(int bOOK_ID, String bOOK_NAME, int bOOK_PRICE,
			String bOOK_FILENAME) {
		super();
		BOOK_ID = bOOK_ID;
		BOOK_NAME = bOOK_NAME;
		BOOK_PRICE = bOOK_PRICE;
		BOOK_FILENAME = bOOK_FILENAME;
	}

	public int getBOOK_ID() {
		return BOOK_ID;
	}

	public void setBOOK_ID(int bOOK_ID) {
		BOOK_ID = bOOK_ID;
	}

	public String getBOOK_NAME() {
		return BOOK_NAME;
	}

	public void setBOOK_NAME(String bOOK_NAME) {
		BOOK_NAME = bOOK_NAME;
	}

	public int getBOOK_PRICE() {
		return BOOK_PRICE;
	}

	public void setBOOK_PRICE(int bOOK_PRICE) {
		BOOK_PRICE = bOOK_PRICE;
	}

	public String getBOOK_FILENAME() {
		return BOOK_FILENAME;
	}

	public void setBOOK_FILENAME(String bOOK_FILENAME) {
		BOOK_FILENAME = bOOK_FILENAME;
	}

}
