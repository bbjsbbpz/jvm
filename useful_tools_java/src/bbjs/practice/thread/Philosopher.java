package bbjs.practice.thread;

import java.awt.print.Printable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {
	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;
	private Random rand = new Random(47);

	public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
		super();
		this.left = left;
		this.right = right;
		this.id = id;
		this.ponderFactor = ponderFactor;
	}

	private void pause() throws InterruptedException {
		if (ponderFactor == 0)
			return;
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Philosopher "+id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.interrupted()) {
			System.out.println(this + " " + "is thinking");
			try {
				pause();
				System.out.println(this + " " + "grabbing right");
				right.take();
				System.out.println(this + " " + "grabbing left");
				left.take();
				System.out.println(this + " eating");
				pause();
				right.drop();
				left.drop();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
