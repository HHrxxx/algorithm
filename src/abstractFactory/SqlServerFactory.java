package abstractFactory;

public class SqlServerFactory implements Factory {

	@Override
	public IUser CreateUserIntance() {
		IUser user=new SqlServerUser();
		return user;
	}

	@Override
	public IOrder CreateOrderIntance() {
		IOrder order=new SqlServerOrder();
		return order;
	}

}
