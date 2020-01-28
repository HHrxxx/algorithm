package factory;

public class MongondbFactory implements Factory {

	@Override
	public IUser CreateIntance() {
		IUser user=new MongondbUser();
		return user;
	}

}
