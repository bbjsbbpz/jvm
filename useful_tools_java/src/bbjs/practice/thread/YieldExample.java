package bbjs.practice.thread;

public class YieldExample {
	public static void main(String[] args) {
		Thread producer = new Producer();
		Thread consumer = new Consumer();
		String threadName = Thread.currentThread().getName();  
		producer.setPriority(Thread.MIN_PRIORITY); // Min Priority
		consumer.setPriority(Thread.MAX_PRIORITY); // Max Priority
		System.out.println(threadName + " start.");  
		producer.start();
		try {
			producer.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consumer.start();
		System.out.println(threadName + " end.");  
	}
}

class Producer extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("I am Producer : Produced Item " + i);
			//Thread.yield();
		}
	}
}

class Consumer extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("I am Consumer : Consumed Item " + i);
			//Thread.yield();
		}
	}
}
/*********
 * 上述程序在没有调用yield()方法情况下的输出：
I am Consumer : Consumed Item 0
 I am Consumer : Consumed Item 1
 I am Consumer : Consumed Item 2
 I am Consumer : Consumed Item 3
 I am Consumer : Consumed Item 4
 I am Producer : Produced Item 0
 I am Producer : Produced Item 1
 I am Producer : Produced Item 2
 I am Producer : Produced Item 3
 I am Producer : Produced Item 4
上述程序在调用yield()方法情况下的输出：
I am Producer : Produced Item 0
 I am Consumer : Consumed Item 0
 I am Producer : Produced Item 1
 I am Consumer : Consumed Item 1
 I am Producer : Produced Item 2
 I am Consumer : Consumed Item 2
 I am Producer : Produced Item 3
 I am Consumer : Consumed Item 3
 I am Producer : Produced Item 4
 I am Consumer : Consumed Item 4
 * 
 * */
