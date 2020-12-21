package com.payroll.common;

import java.util.Arrays;
import java.util.List;

public class Common {
	public static final int SAL_DEFAULT = 0;

	public static List<String> convertStringToListString(String data) {
		String[] stringConverted = data.split(","); // chuyen 1 String thanh 1 mang String
		return Arrays.asList(stringConverted); // tra mang du lieu ve kieu list
	}

	public static int convertStringToInt(String string, int intDefault) {
		int value;
		try {
			value = Integer.parseInt(string); //chuyen tu String sang kieu int
		} catch (NumberFormatException e) {
			value = intDefault; //neu khong parse duoc thi gan ve gia tri default
		}
		return value;
	}
}
