package bbjs.practice.util;

/*
 * 演示 Calendar 的一般操作
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

public class DateUtil {

	public static String dateToString(Date date, String format) {
		String dateString = (new SimpleDateFormat(format)).format(date);
		return dateString;
	}

	public static Date stringToDate(String dateString, String format)
			throws ParseException {
		DateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(dateString);
	}

	public static boolean isWeekend(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		if (weekday == Calendar.SATURDAY || weekday == Calendar.SUNDAY) {
			return true;
		}
		return false;
	}

	public static boolean isMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if (month == Calendar.JANUARY || month == Calendar.MARCH
				|| month == Calendar.MAY || month == Calendar.JULY
				|| month == Calendar.AUGUST || month == Calendar.OCTOBER
				|| month == Calendar.DECEMBER) {
			if (day == 31) {
				return true;
			}
		} else if (month == Calendar.APRIL || month == Calendar.JUNE
				|| month == Calendar.SEPTEMBER) {
			if (day == 30) {
				return true;
			}
		} else if (month == Calendar.FEBRUARY) {
			// int year = calendar.get(Calendar.YEAR);
			if (isLeapYear(date) && day == 29) {
				return true;
			}

			if (!isLeapYear(date) && day == 28) {
				return true;
			}
		}

		return false;
	}

	public static boolean isLeapYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		if (year % 400 == 0) {
			return true;
		} else if (year % 100 != 0) {
			if (year % 4 == 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isQuarterEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		if (month == Calendar.MARCH || month == Calendar.DECEMBER) {
			if (day == 31) {
				return true;
			}
		} else if (month == Calendar.JUNE || month == Calendar.SEPTEMBER) {
			if (day == 30) {
				return true;
			}
		}

		return false;
	}

	public static Date getMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		if (month == Calendar.JANUARY || month == Calendar.MARCH
				|| month == Calendar.MAY || month == Calendar.JULY
				|| month == Calendar.AUGUST || month == Calendar.OCTOBER
				|| month == Calendar.DECEMBER) {
			day = 31;
		} else if (month == Calendar.APRIL || month == Calendar.JUNE
				|| month == Calendar.SEPTEMBER) {
			day = 30;
		} else if (month == Calendar.FEBRUARY) {
			// int year = calendar.get(Calendar.YEAR);
			if (isLeapYear(date)) {
				day = 29;
			} else {
				day = 28;
			}
		}

		calendar.set(year, month, day);
		return calendar.getTime();
	}

	public static Date getQuarterEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		if (month == Calendar.JANUARY || month == Calendar.FEBRUARY
				|| month == Calendar.MARCH) {
			month = Calendar.MARCH;
			day = 31;
		} else if (month == Calendar.APRIL || month == Calendar.MAY
				|| month == Calendar.JUNE) {
			month = Calendar.JUNE;
			day = 30;
		} else if (month == Calendar.JULY || month == Calendar.AUGUST
				|| month == Calendar.SEPTEMBER) {
			month = Calendar.SEPTEMBER;
			day = 30;
		} else if (month == Calendar.OCTOBER || month == Calendar.NOVEMBER
				|| month == Calendar.DECEMBER) {
			month = Calendar.DECEMBER;
			day = 31;
		}

		calendar.set(year, month, day);

		return calendar.getTime();
	}

	public static Date getBeforeDate(Date date) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DATE, -1);
		return cl.getTime();
	}

	public static void process() {
		String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS"))
				.format(new Date());
		System.out.println(str);

		// 创建 Calendar 对象
		Calendar calendar = Calendar.getInstance();
		// 初始化 Calendar 对象，但并不必要，除非需要重置时间
		calendar.setTime(new Date());

		// setTime 类似上面一行
		// Date date = new Date();
		// calendar.setTime(date);

		// 显示年份
		int year = calendar.get(Calendar.YEAR);
		System.out.println("YEAR is = " + String.valueOf(year));

		// 显示月份 (从0开始, 实际显示要加一)
		int MONTH = calendar.get(Calendar.MONTH);
		System.out.println("MONTH is = " + (MONTH + 1));

		// 今年的第 N 天
		int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);

		// 本月第 N 天
		int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));

		// 3小时以后
		calendar.add(Calendar.HOUR_OF_DAY, 3);
		int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY);

		// 当前分钟数
		int MINUTE = calendar.get(Calendar.MINUTE);
		System.out.println("MINUTE = " + MINUTE);

		// 15 分钟以后
		calendar.add(Calendar.MINUTE, 15);
		MINUTE = calendar.get(Calendar.MINUTE);
		System.out.println("MINUTE + 15 = " + MINUTE);

		// 30分钟前
		calendar.add(Calendar.MINUTE, -30);
		MINUTE = calendar.get(Calendar.MINUTE);
		System.out.println("MINUTE - 30 = " + MINUTE);

		// 格式化显示
		str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar
				.getTime());
		System.out.println(str);

		// 重置 Calendar 显示当前时间
		calendar.setTime(new Date());
		str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar
				.getTime());
		System.out.println(str);

		// 创建一个 Calendar 用于比较时间
		Calendar calendarNew = Calendar.getInstance();

		// 设定为 5 小时以前，后者大，显示 -1
		calendarNew.add(Calendar.HOUR, -5);
		System.out.println("时间比较：" + calendarNew.compareTo(calendar));

		// 设定7小时以后，前者大，显示 1
		calendarNew.add(Calendar.HOUR, +7);
		System.out.println("时间比较：" + calendarNew.compareTo(calendar));

		// 退回 2 小时，时间相同，显示 0
		calendarNew.add(Calendar.HOUR, -2);
		System.out.println("时间比较：" + calendarNew.compareTo(calendar));
	}

	public void generateAllWeekends(int year,String format) throws ParseException {		
		String startDateString = year + "0101";
		String endDateString = year + "1231";
		List<Date> dates = findDates(stringToDate(startDateString, "yyyyMMdd"),
				stringToDate(endDateString, "yyyyMMdd"));
		for(Date date:dates){
			if(isWeekend(date)){
				System.out.println(dateToString(date, format));
			}
		}
	}

	public boolean isLeapYear(int year) {
		if (year % 100 == 0) {
			if (year % 400 == 0) {
				return true;
			}
		} else {
			if (year % 4 == 0) {
				return true;
			}
		}
		return false;
	}

	public List<Date> findDates(Date startDate, Date endDate) {		
		List<Date> dates = new ArrayList<Date>();
		dates.add(startDate);
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);
		while(endDate.after(startCalendar.getTime())){
			startCalendar.add(Calendar.DAY_OF_MONTH, 1);
			dates.add(startCalendar.getTime());
		}
		
		return dates;
	}

	public static void main(String[] args) throws ParseException {
		// 字符串转换日期格式
		// DateFormat fmtDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 得到日期格式对象
		// Date date = fmtDateTime.parse(strDateMake);

		// 完整显示日期时间

		String dateString = "20160101";
		Date date = DateUtil.stringToDate(dateString, "yyyyMMdd");
		Date beforeDate = DateUtil.getBeforeDate(date);
		//System.out.println(DateUtil.dateToString(beforeDate, "yyyyMMdd"));
		new DateUtil().generateAllWeekends(2015,"yyyyMMdd");
		new DateUtil().generateAllWeekends(2016,"yyyy-MM-dd");

	}
}
