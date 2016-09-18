package bbjs.practice.thread;

public class ConsumerT extends Thread {
	private int runCount;
	private Store store;

	public ConsumerT(Store store) {
		super();
		this.store = store;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			if(runCount>7){
				return;						
			}
			store.remove();
			runCount++;
			try {
				sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
