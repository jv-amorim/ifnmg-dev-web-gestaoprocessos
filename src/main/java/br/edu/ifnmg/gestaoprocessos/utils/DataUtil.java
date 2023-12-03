package br.edu.ifnmg.gestaoprocessos.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

abstract public class DataUtil{

	static public String formatDateToBrazilianFormat(LocalDateTime localDate) {
		Date data = Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dateFormat.format(data);
	}

}
