package bbjs.practice.util;

public class StringHelper {
	public static String insertChar(String content, char c,int pos){
		return content.substring(0,pos)+c+content.substring(pos);
	}
	
	public static String insertString(String content, String string ,int pos){
		return content.substring(0,pos)+string+content.substring(pos);
	}
}
