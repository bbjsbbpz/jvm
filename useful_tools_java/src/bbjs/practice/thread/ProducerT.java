package bbjs.practice.thread;

public class ProducerT extends Thread {
	private int runCount = 0;
	private Store store;	
	
	public ProducerT(Store store) {
		super();
		this.store = store;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			if(runCount>8){
				return;
			}
			store.add();
			runCount++;
			try {
				sleep(2502);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
