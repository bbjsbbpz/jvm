package bbjs.practice.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ServiceThread extends Thread {
	private CountDownLatch countDownLatch;
	private String service;
	private boolean isUp;

	public boolean isUp() {
		return isUp;
	}

	public String getService() {
		return service;
	}

	public ServiceThread(String service, CountDownLatch countDownLatch) {
		// super();
		this.service = service;
		this.countDownLatch = countDownLatch;
		isUp = false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		verifyService();		
		//countDownLatch.countDown();
	}

	public void verifyService() {
		System.out.println("Start to check service " + service);
		try {
			TimeUnit.MILLISECONDS.sleep(100);
			isUp = true;
			System.out.println("Service "+getService()+" is up");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isUp = false;
			System.out.println("Service "+getService()+" is down");
		}finally{
			countDownLatch.countDown();
//			System.out.println("After checking service " + getService()
//					+ " countDownLatch.getCount()=" + countDownLatch.getCount());
		}
		
		
	}
}
