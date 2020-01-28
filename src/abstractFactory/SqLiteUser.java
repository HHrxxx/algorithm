package abstractFactory;

public class SqLiteUser implements IUser {

	@Override
	public void add() {
		System.out.println("SqLiteUser add");

	}

	@Override
	public void remove() {
		System.out.println("SqLiteUser remove");

	}

}
