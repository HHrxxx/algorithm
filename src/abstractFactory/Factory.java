package abstractFactory;

public interface Factory {
	public IUser CreateUserIntance();

	public IOrder CreateOrderIntance();
}
