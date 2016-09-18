package bbjs.practice.design.proxy;

public class Proxy implements Sourceable {

	private Source source;

	public Proxy() {
		source = new Source();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		before();
		source.method();
		after();
	}

	public void before() {
		System.out.println("before operation.");
	}

	public void after() {
		System.out.println("after operation.");
	}

}
