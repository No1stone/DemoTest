package com.example.demo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {
	
	/**
	 * 지정된 날짜를 지정된 포맷형식으로 변환한다.
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date,
									  String format) {

		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}

	/**
	 * 현재 날짜를 지정된 포맷형식으로 변환한다.
	 * @param format
	 * @return
	 */
	public static String dateToString(String format) {

		return dateToString(new Date(), format);
	}
	
	/**
	 * 문자열을 날짜로 변환한다
	 * @param format
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String format, String date) throws ParseException {
		
		//SimpleDateFormat sf = new SimpleDateFormat(format);
		//return sf.parse(date);
		
		String oldstring = date;
		return new SimpleDateFormat(format).parse(oldstring);
		
	}
	
}
