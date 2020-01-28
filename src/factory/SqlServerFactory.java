package factory;

public class SqlServerFactory implements Factory {

	@Override
	public IUser CreateIntance() {
		IUser user=new SqlServerUser();
		return user;
	}

}
