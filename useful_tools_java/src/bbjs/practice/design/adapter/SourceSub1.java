package bbjs.practice.design.adapter;

public class SourceSub1 extends Adapter {

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		System.out.println("method3 "+this.getClass());
	}
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("method1 "+this.getClass());
	}

}
