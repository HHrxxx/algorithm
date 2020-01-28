import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 按顺序循环打印十次ABC
 *
 */
public class Multi_thread_print_inOrder2 {
	public static void main(String[] args) {
		
		AtomicInteger synObj = new AtomicInteger(0);

		TestPrint a = new TestPrint(synObj, "A1", 0);
		TestPrint b = new TestPrint(synObj, "B1", 1);

		a.start();
		b.start();
		
	}
}

class TestPrint extends Thread {
	
	private AtomicInteger synObj;
	private String name;
	private int flag;
	
	private int count = 0;
	
	public TestPrint(AtomicInteger synObj, String name, int flag) {
		this.synObj = synObj;
		this.name = name;
		this.flag = flag;
	}
	
	@Override
	public void run() {
		while (true) {
			synchronized (synObj) {
				if (synObj.get() % 2 == flag) {
					synObj.set(synObj.get() + 1);
					System.out.println(name+"  "+Thread.currentThread().getName());
					count++;
					synObj.notifyAll();
					if (count == 3) {
						break;
					}
				} else {
					try {
						synObj.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}

