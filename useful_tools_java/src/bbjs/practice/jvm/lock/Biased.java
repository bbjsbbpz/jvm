package bbjs.practice.jvm.lock;

import java.util.List;
import java.util.Vector;

public class Biased {
	
	public static List<Integer> numberList = new Vector<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		int count = 0;
		int startnum = 0;
		while(count < 10000000){
			numberList.add(startnum);
			startnum+=2;
			count++;
		}
		long end = System.currentTimeMillis();
		System.out.println((end-begin)+"ms");
	}
	//-XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 -client -Xmx512m -Xms512m

}
