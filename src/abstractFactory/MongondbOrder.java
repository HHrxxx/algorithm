package abstractFactory;

public class MongondbOrder implements IOrder {

	@Override
	public void update() {
		System.out.println("MongondbUser update");
	}

}
