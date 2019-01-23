package br.com.app.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

public class AppUtil {

	private static DecimalFormat df = null;
	static {
		Locale Local = new Locale("pt","BR");  
		df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Local));  
		df.setMaximumFractionDigits(2);
	}
	public static String toString(Double value){
		return df.format(value);
	}

	public static Double toDouble(String valueStr){
		try {
			return df.parse(valueStr).doubleValue();
		} catch (ParseException e) {
			throw new RuntimeException();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println( toString(1024.34D) );
		System.out.println( toDouble("1.024,32") );
	}
}