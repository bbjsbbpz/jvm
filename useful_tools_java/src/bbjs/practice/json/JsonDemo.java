package bbjs.practice.json;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonDemo {

	// construct json and output it
	public String jsonTest() throws JSONException {
		JSONObject json = new JSONObject();
		JSONArray jsonMembers = new JSONArray();
		JSONObject member1 = new JSONObject();
		member1.put("loginname", "zhangfan");
		member1.put("password", "userpass");
		member1.put("email", "10371443@qq.com");
		member1.put("sign_date", "2007-06-12");
		jsonMembers.put(member1);

		JSONObject member2 = new JSONObject();
		member2.put("loginname", "zf");
		member2.put("password", "userpass");
		member2.put("email", "8223939@qq.com");
		member2.put("sign_date", "2008-07-16");
		jsonMembers.put(member2);

		json.put("users", jsonMembers);

		return json.toString();
	}

	// construct json from String and resolve it.
	public String jsonTest2() throws JSONException {
		String jsonString = "{\"users\":[{\"loginname\":\"zhangfan\",\"password\":\"userpass\",\"email\":\"10371443@qq.com\"},{\"loginname\":\"zf\",\"password\":\"userpass\",\"email\":\"822393@qq.com\"}]}";
		JSONObject json = new JSONObject(jsonString);
		JSONArray jsonArray = json.getJSONArray("users");
		String loginNames = "loginname list:";
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject user = (JSONObject) jsonArray.get(i);
			String userName = (String) user.get("loginname");
			if (i == jsonArray.length() - 1) {
				loginNames += userName;
			} else {
				loginNames += userName + ",";
			}
		}
		return loginNames;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonDemo app = new JsonDemo();
		// System.out.println(app.jsonTest());
		// System.out.println(app.jsonTest2());
		JSONObject jsonUsers = new JSONObject();
		JSONArray jsonMembers = new JSONArray();
		JSONObject member1 = new JSONObject();
		member1.put("username", "bbjsbbpz");
		member1.put("password", "bbjsbbpz");
		member1.put("age", 30);
		jsonMembers.put(member1);

		JSONObject member2 = new JSONObject();
		member2.put("username", "Vanessa");
		member2.put("password", "Vanessa");
		member2.put("age", 27);
		jsonMembers.put(member2);

		jsonUsers.put("users", jsonMembers);
		System.out.println(jsonUsers);

		Scanner scanner = new Scanner(System.in);
		boolean loginStatus = false;
		while (true) {
			System.out.println("please input user name: ");
			String username = scanner.next();
			System.out.println("please input password: ");
			String password = scanner.next();
			JSONArray userArray = jsonUsers.getJSONArray("users");
			for (int i = 0; i < userArray.length(); i++) {
				JSONObject user = userArray.getJSONObject(i);
				String uname = user.getString("username");
				String pwd = user.getString("password");
				if (username.equals(uname) && password.equals(pwd)) {
					System.out.println("welcome " + username);
					loginStatus = true;
					break;
				}
				loginStatus = false;
			}
			if (!loginStatus) {
				System.out
						.println("invalid username or password, please try again.");
			} else {
				System.out.println("continue? y/n: ");
				String ct = scanner.next();
				if (!ct.equals("y") && !ct.equals("Y")) {
					break;
				}
			}
		}
	}

}
