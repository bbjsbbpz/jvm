package bbjs.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

	public static void main(String[] args) {
		int N = 8; // ������
		Semaphore semaphore = new Semaphore(5); // ������Ŀ
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
				System.out.println("����" + this.num + "ռ��һ���������������ֿ��û���Ϊ"
						+ semaphore.availablePermits());
				Thread.sleep(2000);
				semaphore.release();
				System.out.println("����" + this.num + "�ͷų��������ֿ��û���Ϊ"
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
 * 1��CountDownLatch��CyclicBarrier���ܹ�ʵ���߳�֮��ĵȴ���ֻ�������ǲ��ص㲻ͬ��
 * 
 * ��������CountDownLatchһ������ĳ���߳�A�ȴ����ɸ������߳�ִ��������֮������ִ�У�
 * 
 * ����������CyclicBarrierһ������һ���̻߳���ȴ���ĳ��״̬��Ȼ����һ���߳���ͬʱִ�У�
 * 
 * �����������⣬CountDownLatch�ǲ��ܹ����õģ���CyclicBarrier�ǿ������õġ�
 * 
 * ����2��Semaphore��ʵ�����е����ƣ���һ�����ڿ��ƶ�ĳ����Դ�ķ���Ȩ�ޡ�
 * 
 * ********/
