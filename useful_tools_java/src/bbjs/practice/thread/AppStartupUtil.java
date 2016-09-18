package bbjs.practice.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppStartupUtil {
	private static List<ServiceThread> services;
	private static CountDownLatch countDownLatch;

	private AppStartupUtil() {
	}

	private final static AppStartupUtil INSTANCE = new AppStartupUtil();

	public static AppStartupUtil getInstance() {
		return INSTANCE;
	}

	public static boolean checkExternalServices() {
		countDownLatch = new CountDownLatch(3);
		services = new ArrayList<ServiceThread>();
		services.add(new ServiceThread("Network", countDownLatch));
		services.add(new ServiceThread("database", countDownLatch));
		services.add(new ServiceThread("Catche", countDownLatch));

		ExecutorService exec = Executors.newCachedThreadPool();
		for (ServiceThread service : services) {
			exec.execute(service);
		}

		try {
			countDownLatch.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (ServiceThread service : services) {
			if (!service.isUp()) {
				System.out.println(service.getService() + " is down.");
				return false;
			}
			
		}

		return true;
	}

	public static void main(String[] args) {
		boolean result = false;
		result = AppStartupUtil.checkExternalServices();
		System.out.println(result);
	}

}
