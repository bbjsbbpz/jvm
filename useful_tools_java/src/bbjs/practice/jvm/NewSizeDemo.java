package bbjs.practice.jvm;

public class NewSizeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] b = null;
		for(int i=0;i<100;i++){
			b = new byte[1*1024*1024];
		}
	}

}

//-Xmx20m -Xms20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
//-Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
//-Xmx20m -Xms20m -Xmn15m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
//-Xmx20M -Xms20M -XX:NewRatio=2 -XX:+PrintGCDetails
//ֻҪJVM�޷�Ϊ�´����Ķ������ռ䣬�Ϳ϶��ᴥ��������GC���ȷ�˵Eden�����ˡ���˶��󴴽���ԽƵ����������GC�϶�Ҳ��Ƶ����