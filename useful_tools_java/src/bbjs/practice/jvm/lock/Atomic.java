package bbjs.practice.jvm.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Atomic {
	private static final int MAX_THREADS = 3;
	private static final int TASK_COUNT = 3;
	private static final int TRAGER_COUNT = 10000000;

	private AtomicLong acount = new AtomicLong();
	private long count = 0;

	static CountDownLatch cdlsync = new CountDownLatch(TASK_COUNT);
	static CountDownLatch cdlatomic = new CountDownLatch(TASK_COUNT);

	protected synchronized long inc() {
		return ++count;
	}

	protected synchronized long getCount() {
		return count;
	}
	
	public void clearCount(){
		count = 0;
	}
	
	public class SyncThread implements Runnable{
		
		protected String name;
		protected long  starttime;
		

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

	public static void main(String[] args) {

	}
	
	//LongAdder
	//AtomicLong
	//CAS
}
