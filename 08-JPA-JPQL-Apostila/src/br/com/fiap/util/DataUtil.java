package br.com.fiap.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	//Formata a data
	public static String formatar(Calendar data) {
		return sdf.format(data.getTime());
	}
	
	//Transforma a String em um Calendar
	public Calendar parse(String data) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(data));
		return calendar;
	}
	
}
