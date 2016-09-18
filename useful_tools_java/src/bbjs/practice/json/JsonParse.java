package bbjs.practice.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonParse {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add( "first" );
		list.add( "second" );
		JSONArray jsonArray = JSONArray.fromObject( list );
		System.out.println(jsonArray);
		
		
		
		Map map = new HashMap();
		map.put("name", "json");
		map.put("bool", Boolean.TRUE);
		map.put("int", new Integer(1));
		map.put("arr", new String[] { "a", "b" });
		map.put("func", "function(i){ return this.arr[i]; }");
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json);
		
		boolean[] boolArray = new boolean[] { true, false, true };
		JSONArray jsonArray1 = JSONArray.fromObject(boolArray);
		System.out.println(jsonArray1);
		
		JSONArray jsonArray3 = JSONArray.fromObject("['json','is','easy']" );
		System.out.println(jsonArray3);
	}
}
