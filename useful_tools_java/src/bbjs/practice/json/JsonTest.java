package bbjs.practice.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONBuilder;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.PropertyFilter;
import bbjs.practice.object.Person;
import bbjs.practice.object.Student;
import bbjs.practice.object.User;

public class JsonTest {
	public static void main(String[] args) {
		Student[] students = { new Student("zhangsan", 20, 90.0f),
				new Student("lisi", 22, 90.0f),
				new Student("wangwu", 20, 99.0f),
				new Student("sunliu", 22, 98.0f) };
		Student student = new Student("bbjs", 23, 94.0f);
		JSONObject jsonStudent = JSONObject.fromObject(student);
		JSONArray jsonStudents = JSONArray.fromObject(students);
		System.out.println(jsonStudent);
		System.out.println(jsonStudents);

		Map<Object, Object> userMap = new HashMap<Object, Object>();
		userMap.put("username", "Vanessa");
		userMap.put("password", "1234");
		JSONObject jsonMap = JSONObject.fromObject(userMap);
		System.out.println(jsonMap);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "score" });
		jsonStudent = JSONObject.fromObject(student, jsonConfig);
		System.out.println(jsonStudent);

		Person person = new Person();
		person.setName("swiftlet");
		person.setSex("men");
		person.setAddress("china");
		JSONObject jsonPerson = JSONObject.fromObject(person);
		System.out.println(jsonPerson);

		jsonConfig.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object source, String name, Object value) {
				// TODO Auto-generated method stub
				return source instanceof Student && name.endsWith("age");
			}
		});

		jsonStudent = JSONObject.fromObject(student, jsonConfig);
		System.out.println(jsonStudent);

		System.out.println(jsonStudent.optString("name"));

		System.out.println(JsonTest.class.getResource(""));
		System.out.println(JsonTest.class.getResource("/"));

		System.out.println(JsonTest.class.getClassLoader().getResource(""));
		/*
		 * path不能以'/'开头时，path是指类加载器的加载范围，在资源加载的过程中，使用的逐级向上委托的形式加载的，'/'表示Boot
		 * ClassLoader中的加载范围，因为这个类加载器是C++实现的，所以加载范围为null
		 */
		System.out.println(JsonTest.class.getClassLoader().getResource("/"));
		// 从上面就可以看才出来：Class.getResource和ClassLoader.getResource本质上是一样的

		System.out.println("==================");
		User temp = new User();
		temp.setUsername("root");
		temp.setPassword("root");
		// JSONObject转换为bean的两种方法：
		JSONObject json = JSONObject.fromObject(temp);
		User user1 = (User) JSONObject.toBean(json, User.class);
		jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(User.class);
		User user2 = (User) JSONSerializer.toJava(json, jsonConfig);

		System.out.println(user2);

		// JSONArray转换为List<bean>的两种方法：
		JSONArray userArray = JSONArray.fromObject("[" + json.toString() + "]");
		List<User> userList1 = (List<User>) JSONArray.toCollection(userArray,
				User.class);
		List<User> userList2 = (List<User>) JSONSerializer.toJava(userArray,
				jsonConfig);
		System.out.println(userList1);
		System.out.println(userList2);

		System.out.println("==================");
		File f = new File("d:" + File.separator + "test.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(f);
			JSONBuilder builder = new JSONBuilder(fw);
			builder.object();
			builder.key("Json");
			builder.value("Hello, World!");
			//builder.endObject();
			//builder.object();
			builder.key("Who");
			builder.value("JackHuang");
			builder.key("array");
			builder.value(students);
			builder.endObject();
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
