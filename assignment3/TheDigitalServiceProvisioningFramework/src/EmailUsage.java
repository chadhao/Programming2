import java.util.ArrayList;

public class EmailUsage extends ServiceUsage
{
	private static final ArrayList<Product> INIT_LIST = new ArrayList<>();
	
	static
	{
		INIT_LIST.add(new Product("Email Accounts", 0.04));
	}
	
	public EmailUsage()
	{
		super("Email Service", INIT_LIST);
	}
}
