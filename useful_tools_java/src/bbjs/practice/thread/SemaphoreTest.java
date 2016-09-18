package bbjs.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	public static void main(String[] args) {
		int N = 8; // 工人数
		Semaphore semaphore = new Semaphore(5); // 机器数目
		for (int i = 0; i < N; i++)
			new Worker(i, semaphore).start();
		
		Semaphore semaphore2 = new Semaphore(6);
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<N;i++){
			exec.execute(new Engineer(i, semaphore2));
		}
	}

	static class Worker extends Thread {
		private int num;
		private Semaphore semaphore;

		public Worker(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("工人" + this.num + "占用一个机器在生产，现可用机器为"
						+ semaphore.availablePermits());
				Thread.sleep(2000);
				semaphore.release();
				System.out.println("工人" + this.num + "释放出机器，现可用机器为"
						+ semaphore.availablePermits());

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Engineer implements Runnable {

		private int id;
		private Semaphore semaphore;

		public Engineer(int id, Semaphore semaphore) {
			//super();
			this.id = id;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				semaphore.acquire();
				System.out.println("Engineer"+id+" is using 1 machine, and the available machine count is "+semaphore.availablePermits());
				TimeUnit.MILLISECONDS.sleep(2500);
				semaphore.release();
				System.out.println("Engineer"+id+" released 1 machine, and the available machine count is "+semaphore.availablePermits());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
/*******
 * 1）CountDownLatch和CyclicBarrier都能够实现线程之间的等待，只不过它们侧重点不同：
 * 
 * 　　　　CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * 
 * 　　　　而CyclicBarrier一般用于一组线程互相等待至某个状态，然后这一组线程再同时执行；
 * 
 * 　　　　另外，CountDownLatch是不能够重用的，而CyclicBarrier是可以重用的。
 * 
 * 　　2）Semaphore其实和锁有点类似，它一般用于控制对某组资源的访问权限。
 * 
 * ********/
