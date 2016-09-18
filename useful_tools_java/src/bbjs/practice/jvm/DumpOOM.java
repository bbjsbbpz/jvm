package bbjs.practice.jvm;

import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class DumpOOM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vector = new Vector<>();
		for(int i=0;i<25;i++){
			vector.add(new byte[1*1024*1024]);
		}
	}

}
