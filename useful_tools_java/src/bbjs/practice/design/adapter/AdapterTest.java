package bbjs.practice.design.adapter;

public class AdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sourceable sourceable = new SourceSub1();
		sourceable.method1();
		
		sourceable = new SourceSub2();
		sourceable.method2();
	}

}
