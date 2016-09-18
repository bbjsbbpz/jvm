package bbjs.practice.design.observer;

public interface Subject {
	public void add(Observer observer);
	public void del(Observer observer);
	public void notifyObserver();
	public void operation();
}
