
public class Singleton {

	/**
	 * 懒汉式是以时间换空间的方式
	 */
	private static Singleton instance = null;

	private Singleton() {

	}

	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	

	public static void main(String[] args) {

	}

}
