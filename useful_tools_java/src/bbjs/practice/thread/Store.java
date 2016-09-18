package bbjs.practice.thread;

public class Store {
	
	private int max = 5;
	private int count = 0;
	
	public synchronized void add(){
		
		if(count>=5){
			System.out.println("the store is full.");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count++;
		System.out.println(Thread.currentThread()+" add 1 to store, and the count is "+count);
		this.notifyAll();
		
	}
	
	public synchronized void remove(){
		
		if(count<=0){
			System.out.println("the store is empty.");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		count--;
		System.out.println(Thread.currentThread()+" remove 1 from store, and the count is "+count);
		this.notifyAll();
		
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Thread t1 = new ProducerT(store);
		Thread t2 = new ConsumerT(store);
		Thread t3 = new ConsumerT(store);
		Thread t4 = new ProducerT(store);
		Thread t5 = new ProducerT(store);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
