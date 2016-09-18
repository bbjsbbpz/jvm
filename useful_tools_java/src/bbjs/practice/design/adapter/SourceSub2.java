package bbjs.practice.design.adapter;

public class SourceSub2 extends Adapter {

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		System.out.println("method3 "+this.getClass());
	}
	
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("method2 "+this.getClass());
	}

}
