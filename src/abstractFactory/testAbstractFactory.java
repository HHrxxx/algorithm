package abstractFactory;

public class testAbstractFactory {

	public static void main(String[] args) {
		
		MongondbFactory factory=new MongondbFactory();
		IUser user=factory.CreateUserIntance();
		user.add();
		
		SqlServerFactory serverFactory=new SqlServerFactory();
		IOrder serverUser=serverFactory.CreateOrderIntance();
		serverUser.update();
	}

}
