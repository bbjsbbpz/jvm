package bbjs.practice.object;

import net.sf.json.JSONString;

public class Person implements JSONString{
	
	private String name;
	private String sex;
	private String address;

	@Override
	public String toJSONString() {
		// TODO Auto-generated method stub
		return "{\"name\":\""+name+"\",\"sex\":\""+sex+"\"}";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
