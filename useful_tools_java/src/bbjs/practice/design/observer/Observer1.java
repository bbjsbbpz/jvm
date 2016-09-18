package bbjs.practice.design.observer;

public class Observer1 implements Observer {

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass()+" received update.");
	}

}
