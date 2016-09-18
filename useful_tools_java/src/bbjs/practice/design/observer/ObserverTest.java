package bbjs.practice.design.observer;

public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject subject = new MySubject();
		subject.add(new Observer1());
		subject.add(new Observer2());
		subject.operation();
	}

}
