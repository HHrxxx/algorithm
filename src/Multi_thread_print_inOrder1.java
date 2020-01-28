/**
 * 	用一个flag来控制顺序
 *
 */

class PrintA implements Runnable {
	private Multi_thread_print_inOrder1 t;

	PrintA(Multi_thread_print_inOrder1 t) {
		this.t = t;
	}

	@Override
	public void run() {
		try {
			t.printa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PrintB implements Runnable {

	private Multi_thread_print_inOrder1 t;

	PrintB(Multi_thread_print_inOrder1 t) {
		this.t = t;
	}

	@Override
	public void run() {
		try {
			t.printb();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class PrintC implements Runnable {
	private Multi_thread_print_inOrder1 t;

	PrintC(Multi_thread_print_inOrder1 t) {
		this.t = t;
	}

	@Override
	public void run() {
		try {
			t.printc();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Multi_thread_print_inOrder1 {
	private int flag = 0;

	public synchronized void printa() throws InterruptedException {
		while (true) {
			if (flag == 0) {
				System.out.print("A");
				flag = 1;
				notifyAll();
			}
			wait();
		}
	}

	public synchronized void printb() throws InterruptedException {
		while (true) {
			if (flag == 1) {
				System.out.print("B");
				flag = 2;
				notifyAll();
			}
			wait();
		}
	}

	public synchronized void printc() throws InterruptedException {
		while (true) {
			if (flag == 2) {
				System.out.print("C");
				Thread.sleep(1000);
				flag = 0;
				notifyAll();
			}
			wait();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Multi_thread_print_inOrder1 t = new Multi_thread_print_inOrder1();
		PrintA printA = new PrintA(t);
		PrintB printB = new PrintB(t);
		PrintC printC = new PrintC(t);
		Thread t1 = new Thread(printA);
		Thread t2 = new Thread(printB);
		Thread t3 = new Thread(printC);
		t1.start();
		t2.start();
		t3.start();

	}

}
