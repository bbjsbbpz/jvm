package bbjs.practice.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CountDownLatch countDownLatch = new CountDownLatch(2);
		
		new Thread(){
			public void run() {
				System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��");
                try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����");
				countDownLatch.countDown();
			};
		}.start();
		
		new Thread(){
			public void run() {
				System.out.println("���߳�"+Thread.currentThread().getName()+"����ִ��");
                try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("���߳�"+Thread.currentThread().getName()+"ִ�����");
                countDownLatch.countDown();
			};
		}.start();
		
		try {
			
			System.out.println("�ȴ�2�����߳�ִ�����...");
			countDownLatch.await();
            System.out.println("2�����߳��Ѿ�ִ�����");
            System.out.println("����ִ�����߳�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
