package bbjs.practice.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CountDownLatch countDownLatch = new CountDownLatch(2);
		
		new Thread(){
			public void run() {
				System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
				countDownLatch.countDown();
			};
		}.start();
		
		new Thread(){
			public void run() {
				System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                countDownLatch.countDown();
			};
		}.start();
		
		try {
			
			System.out.println("等待2个子线程执行完毕...");
			countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
