package bbjs.practice.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	public static void patternMatch(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("Match " + regex + " => " + input + ": "
				+ matcher.matches());
	}

	public static void patternFind(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("Find " + regex + " => " + input + ": "
				+ matcher.find());
	}

	public static void replaceMatch(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.replaceAll("").trim());
	}

	public static void findGroup(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			System.out.println(matcher.start() + " - " + matcher.end());
			System.out.println(matcher.group());
		}
	}

	public static void patternSplit(String regex, String input) {
		Pattern pattern = Pattern.compile(regex);
		String[] strings = pattern.split(input);
		for (String string : strings) {
			System.out.print(string);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		patternMatch("[0-9]{4}[A-Z]{2}", "2016aa");
		patternMatch("[0-9]{4}[A-Z]{2}", "2016XX");
		patternMatch("[^x][a-z]+", "xxxx");
		patternMatch("[^x][a-z]+", "GFod");
		patternMatch("\\d{3}\\-\\d{2}\\-\\d{4}", "123-12-1234");
		patternMatch("[0-9]{3}\\-[0-9]{2}\\-[0-9]{4}", "123-12-1234");
		patternMatch("[0-9]{4}\\-?[0-9]{2}\\-?[0-9]{2}", "2016-12-12");
		patternMatch("[0-9]{4}\\-?[0-9]{2}\\-?[0-9]{2}", "20161212");
		patternMatch("cat", "Catherine");
		patternMatch("cat", "Catherine_cat");
		patternMatch("c.t", "cat");
		patternMatch("c.t", "cakt");
		patternMatch("c[abc]t", "cat");
		patternMatch("c[abc]t", "cabt");
		patternMatch("c[a|b|c]t", "cabt");
		patternMatch("c(a|b|c)t", "cabt");
		patternMatch("[a-z]+", "ABC");
		patternMatch("[a-zA-Z]+", "ABC");
		patternMatch("[a-z]+\\s+[0-9]{1,2},\\s*[0-4]{4}", "Jul 23,2014");
		patternMatch("[a-z]+\\s+[0-9]{1,2},\\s*[0-4]{4}", "jul 23 2014");
		patternMatch("\\d{4}\\-?\\d{2}\\-?\\d{2}", "20121212");

		// IP
		patternMatch("\\d{3}.\\d{1,3}.\\d{1,3}.\\d{1,3}", "192.168.12.12");

		// Email
		patternMatch("\\w+@(\\w+.)+[a-z]{2,3}", "bbjsbbpz@qq.com");
		patternMatch("\\w+@(\\w+.)+[a-z]{2,3}", "bbjsbbpz@qq.COM");

		// Chinese
		patternMatch("^[\u4e00-\u9fa5]+$", "张三 13599998888 000000");
		patternMatch("^[\u4e00-\u9fa5]+$", "张三");
		patternFind("^[\u4e00-\u9fa5]+$", "张三 13599998888 000000");
		patternFind("[\u4e00-\u9fa5]+", "张三 13599998888 000000");

		// ID
		patternMatch("\\d{15}|\\d{18}|\\d{17}X|\\d{17}x", "441501198506020080");
		patternMatch("\\d{15}|\\d{18}|\\d{17}X|\\d{17}x", "44150119850602008x");
		patternMatch("\\d{15}|\\d{18}|\\d{17}X|\\d{17}x", "44150119850602008X");
		patternMatch("\\d{15}|\\d{18}|\\d{17}X|\\d{17}x", "44150119850602008");
		patternMatch("\\d{15}|\\d{18}|\\d{17}X|\\d{17}x", "4415011985060200811");

		// mobile number
		/*
		 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 
		 * 　　联通：130、131、132、152、155、156、185、186
		 * 
		 * 　　电信：133、153、180、189、（1349卫通）
		 */

		patternMatch("^1(3|5|8)[0-9]{9}$", "13631327581");
		patternMatch("^1(3|5|8)[0-9]{9}$", "13831327581");
		patternMatch("^1(3|5|8)[0-9]{9}$", "15913132758");
		patternMatch("^1(3|5|8)[0-9]{9}$", "14913132758");
		patternMatch("^1(3|5|8)[0-9]{9}$", "159131327583");
		patternMatch("^1(3|5|8)[0-9]{9}$", "1591332758");

		replaceMatch("\\d", "张三 13599998888 000000");
		replaceMatch("[^\\d]", "张三 13599998888 000000");
		replaceMatch("[\\D]", "张三www13599998888 00000ww0");

		findGroup("\\d+", "aaa111bbb222ccc333");
		findGroup("[a-z]+", "aaa111bbb222ccc333");

		patternSplit("\\d+", "aaa111bbb222ccc333");
		patternSplit("[a-z]+", "aaa111bbb222ccc333");

		String input = "01. public" + "02. private" + "11. private";
		replaceMatch("\\d{1,3}.", input);
	}

}
