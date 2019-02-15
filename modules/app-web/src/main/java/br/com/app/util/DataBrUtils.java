package br.com.app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBrUtils {
	
	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static final DateFormat dfHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
    public static String toString(Date data){
    	return df.format(data);
    }
    
    public static Date toDate(String dataStr){
    	try {
			return df.parse(dataStr);
		} catch (ParseException e) {
			throw new RuntimeException();
		}
    }

	public static String toStringComHora(Date dataHora) {
		return dfHora.format(dataHora);
	}
}