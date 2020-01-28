package simpleFactory;

public class testSimpleFactory {

	public static void main(String[] args) {
		
		SimpleFactory factory=new SimpleFactory();
		IUser user=factory.CreateUserIntance("SqLiteUser");
		user.add();
	
	}

}
