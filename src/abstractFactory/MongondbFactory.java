package abstractFactory;

public class MongondbFactory implements Factory {

	@Override
	public IUser CreateUserIntance() {
		IUser user=new MongondbUser();
		return user;
	}

	@Override
	public IOrder CreateOrderIntance() {
		IOrder order=new MongondbOrder();
		return order;
	}

}
