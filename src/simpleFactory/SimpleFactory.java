package simpleFactory;

public class SimpleFactory {

	public IUser CreateUserIntance(String type) {

		switch (type) {
			case "SqLiteUser":
				return new SqLiteUser();
			case "SqlServerUser":
				return new SqlServerUser();
			default:
				break;
		}
		return null;
	}
}
