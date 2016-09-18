package bbjs.practice.jvm.lock;

public class LockEliminate {
	
	private static final int CIRCLE = 2000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		for(int i=0; i<CIRCLE;i++){
			createStringBuffer("JVM", "Diagnosis");
		}
		long end = System.currentTimeMillis();
		long bufferCost = end - start;
		System.out.println("createStringBuffer: "+bufferCost+" ms");
	}
	
	public static String createStringBuffer(String s1, String s2){
		StringBuffer sb = new StringBuffer();
		sb.append(s1);
		sb.append(s2);
		return sb.toString();
	}

}
//-server -XX:+DoEscapeAnalysis -XX:-EliminateLocks -Xcomp -XX:-BackgroundCompilation -XX:BiasedLockingStartupDelay=0
//-server -XX:+DoEscapeAnalysis -XX:+EliminateLocks -Xcomp -XX:-BackgroundCompilation -XX:BiasedLockingStartupDelay=0
