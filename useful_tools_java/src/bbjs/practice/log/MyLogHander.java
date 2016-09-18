package bbjs.practice.log;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyLogHander extends Formatter { 
	 
	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		return record.getLevel() + ":" + record.getMessage()+"\r\n"; 
	} 
}
