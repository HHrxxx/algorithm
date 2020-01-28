package abstractFactory;

public class SqLiteFactory implements Factory {

	@Override
	public IUser CreateUserIntance() {
		IUser user=new SqLiteUser();
		return user;
	}

	@Override
	public IOrder CreateOrderIntance() {
		IOrder order=new SqLiteOrder();
		return order;
	}

}
