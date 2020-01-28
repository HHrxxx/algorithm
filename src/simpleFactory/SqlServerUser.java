package simpleFactory;

public class SqlServerUser implements IUser {

	@Override
	public void add() {
		System.out.println("SqlServerUser add");

	}

	@Override
	public void remove() {
		System.out.println("SqlServerUser remove");

	}

}
