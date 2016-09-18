package bbjs.practice.callback;

public class MethodB {
	public double getTime(CallBackInterface callBack) {
		long start = System.currentTimeMillis();
		System.out.println("Method B start.");
		callBack.exectueMethod();
		long end = System.currentTimeMillis();
		System.out.println("Method B cost time=" + (end - start));
		return end - start;
	}
}
