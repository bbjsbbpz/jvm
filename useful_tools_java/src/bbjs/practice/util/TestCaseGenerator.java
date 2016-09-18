package bbjs.practice.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TestCaseGenerator {

	public static void main(String[] args) throws Exception {
		// String path = TestCaseGenerator.class.getClass().getClassLoader()
		// .getResource(".").getPath();
		// System.out.println(path);
		InputStream is = TestCaseGenerator.class.getClassLoader()
				.getResourceAsStream("test_case.csv");
		BufferedReader bf = new BufferedReader(new InputStreamReader(is));
		String line = null;
		Class<DateUtil> clazz = DateUtil.class; 
		DateUtil obj = clazz.newInstance();
		
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m:methods){
			System.out.println(m.getReturnType()+" "+m.getName());
		}
		
		while((line=bf.readLine())!=null){
			if(line.startsWith("ID")){
				continue;
			}
			String[] testcase = line.split(",");
			//System.out.println(line);
			String function = testcase[1];
			String testData = testcase[2];
			String expected = testcase[3];
			String actual = testcase[4];
			
			Method method = clazz.getDeclaredMethod(function,Date.class);
			Type returnType = method.getGenericReturnType();
			System.out.println(returnType);
			if(method!=null){
				System.out.println(method.invoke(obj, new Date()));
			}			
			
			String assertString = "assertEquals("+expected+","+actual+")";
			System.out.println(assertString);
		}

	}
}
