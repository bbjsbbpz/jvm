package bbjs.practice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
	public static void main(String[] args) {
//		LiftOff launch = new LiftOff();
//		launch.run();
//		Thread t = new Thread(new LiftOff());
//		t.start();
//		System.out.println("Waiting for LiftOff");
//		for(int i=0;i<5;i++){
//			//System.out.println();
//			new Thread(new LiftOff()).start();
//			
//		}
//		System.out.println("Waiting for LiftOff");
		ExecutorService exec = Executors.newCachedThreadPool();
		exec = Executors.newFixedThreadPool(5);
		exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
//-XX:+PrintGCDetails
//（PS是指Parallel Scavenge）
//http://blog.csdn.net/yxc135/article/details/12137663GC日志分析