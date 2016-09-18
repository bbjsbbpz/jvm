package bbjs.practice.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//-XX:+PrintGCDetails
public class CyclicBarrierTest {
	public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        for(int i=0;i<N;i++)
            new Writer(barrier).start();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CyclicBarrier����");
        
        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
 
        @Override
        public void run() {
            System.out.println("�߳�"+Thread.currentThread().getName()+"����д������...");
            try {
                Thread.sleep(5000);      //��˯����ģ��д�����ݲ���
                System.out.println("�߳�"+Thread.currentThread().getName()+"д��������ϣ��ȴ������߳�д�����");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("�����߳�д����ϣ�����������������...");
        }
    }
}
//��ִ�н�����Կ������ڳ��ε�4���߳�Խ��barrier״̬���ֿ�������������һ�ֵ�ʹ�á���CountDownLatch�޷������ظ�ʹ�á�
