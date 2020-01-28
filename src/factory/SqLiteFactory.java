package factory;

public class SqLiteFactory implements Factory {

	@Override
	public IUser CreateIntance() {
		IUser user=new SqLiteUser();
		return user;
	}

}
