package bbjs.practice.thread;

public class Chopstick {
	private boolean taken = false;
	public synchronized void take(){
		while(taken){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		taken = true; // if not taken, then take it
		//System.out.println("take one chopstick");
	}
	
	public synchronized void drop(){
		taken = false;
		notifyAll();
	}
}
