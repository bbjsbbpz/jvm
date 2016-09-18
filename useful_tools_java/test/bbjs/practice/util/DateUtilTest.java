package bbjs.practice.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {
	
	private String format = "yyyyMMdd";

	@Test
	public void testDateToString() {
		Date date = new Date();
		String expected = "20160209";
		String actual = DateUtil.dateToString(date, format);
		assertEquals("date converts to string failed", expected, actual);
	}

	@Test
	public void testStringToDate() {
		
	}

	@Test
	public void testIsWeekend() throws ParseException {
		String dateString = "20151231";
		String dateString2 = "20151226";
		String dateString3 = "20151227";
		Date date = DateUtil.stringToDate(dateString, format);
		Date date2 = DateUtil.stringToDate(dateString2, format);
		Date date3 = DateUtil.stringToDate(dateString3, format);
		
		assertEquals(false, DateUtil.isWeekend(date));
		assertEquals(true, DateUtil.isWeekend(date2));
		assertEquals(true, DateUtil.isWeekend(date3));
	}

	@Test
	public void testIsMonthEnd() throws ParseException {
		String dateString = "20151231";
		String dateString2 = "20150228";
		String dateString3 = "24000228";
		Date date = DateUtil.stringToDate(dateString, format);
		Date date2 = DateUtil.stringToDate(dateString2, format);
		Date date3 = DateUtil.stringToDate(dateString3, format);
		
		assertEquals(true, DateUtil.isMonthEnd(date));
		assertEquals(true, DateUtil.isMonthEnd(date2));
		assertEquals(false, DateUtil.isMonthEnd(date3));
	}
	
	@Test
	public void testGetMonthEnd() throws ParseException{
		String dateString = "20151231";
		String dateString2 = "20150228";
		String dateString3 = "24000228";
		Date date = DateUtil.stringToDate(dateString, format);
		Date date2 = DateUtil.stringToDate(dateString2, format);
		Date date3 = DateUtil.stringToDate(dateString3, format);
		
		assertEquals("20151231", DateUtil.dateToString(DateUtil.getMonthEnd(date),format));
		assertEquals("20150228", DateUtil.dateToString(DateUtil.getMonthEnd(date2),format));
		assertEquals("24000229", DateUtil.dateToString(DateUtil.getMonthEnd(date3),format));
	}
	
	@Test
	public void testGetQuarterEnd() throws ParseException{
		String dateString = "20151231";
		String dateString2 = "20150228";
		String dateString3 = "24000228";
		Date date = DateUtil.stringToDate(dateString, format);
		Date date2 = DateUtil.stringToDate(dateString2, format);
		Date date3 = DateUtil.stringToDate(dateString3, format);
		
		assertEquals("20151231", DateUtil.dateToString(DateUtil.getQuarterEnd(date),format));
		assertEquals("20150331", DateUtil.dateToString(DateUtil.getQuarterEnd(date2),format));
		assertEquals("24000331", DateUtil.dateToString(DateUtil.getQuarterEnd(date3),format));
	}

	@Test
	public void testIsLeapYear() throws ParseException {
		String dateString = "20151231";
		String dateString2 = "2100228";
		String dateString3 = "24000228";
		Date date = DateUtil.stringToDate(dateString, format);
		Date date2 = DateUtil.stringToDate(dateString2, format);
		Date date3 = DateUtil.stringToDate(dateString3, format);
		
		assertEquals(false, DateUtil.isLeapYear(date));
		assertEquals(false, DateUtil.isLeapYear(date2));
		assertEquals(true, DateUtil.isLeapYear(date3));
	}

	@Test
	public void testIsQuarterEnd() throws ParseException {
		String dateString = "20151231";
		String dateString2 = "20150228";
		String dateString3 = "24000228";
		Date date = DateUtil.stringToDate(dateString, format);
		Date date2 = DateUtil.stringToDate(dateString2, format);
		Date date3 = DateUtil.stringToDate(dateString3, format);
		
		assertEquals(true, DateUtil.isQuarterEnd(date));
		assertEquals(false, DateUtil.isQuarterEnd(date2));
		assertEquals(false, DateUtil.isQuarterEnd(date3));
	}

	@Test
	public void testGetBeforeDate() throws ParseException {
		String dateString = "20151201";
		String dateString2 = "20150101";
		String dateString3 = "24000228";
		Date date = DateUtil.stringToDate(dateString, format);
		Date date2 = DateUtil.stringToDate(dateString2, format);
		Date date3 = DateUtil.stringToDate(dateString3, format);
		
		date = DateUtil.getBeforeDate(date);
		date2 = DateUtil.getBeforeDate(date2);
		date3 = DateUtil.getBeforeDate(date3);
		
		assertEquals("20151130", DateUtil.dateToString(date, format));
		assertEquals("20141231", DateUtil.dateToString(date2, format));
		assertEquals("24000227", DateUtil.dateToString(date3, format));
		
		
	}

}
