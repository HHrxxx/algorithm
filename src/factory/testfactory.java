package factory;

public class testfactory {

	public static void main(String[] args) {
		
		MongondbFactory factory=new MongondbFactory();
		IUser user=factory.CreateIntance();
		user.add();	
	}
}
