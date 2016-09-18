package bbjs.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {

	private int priority;

	public SleepingTask(int priority) {
		super();
		this.priority = priority;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown-- > 0) {
			System.out.println(status()+" priority: "+priority);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("Interrupted");
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask(Thread.MAX_PRIORITY));
			exec.execute(new SleepingTask(Thread.NORM_PRIORITY));
			exec.execute(new SleepingTask(Thread.MIN_PRIORITY));
		}
		exec.shutdown();
	}
}
// -Xmx1024m -Xms512m -XX:+PrintGCDetails
