package abstractFactory;

public class SqlServerOrder implements IOrder {

	@Override
	public void update() {
		System.out.println("SqlServer update");
	}

}
