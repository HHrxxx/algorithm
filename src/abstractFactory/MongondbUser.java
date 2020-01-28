package abstractFactory;

public class MongondbUser implements IUser {

	@Override
	public void add() {
		System.out.println("MongondbUser add");

	}

	@Override
	public void remove() {
		System.out.println("MongondbUser remove");

	}
}
