import java.util.ArrayList;

public class EmailUsage extends ServiceUsage
{
	public EmailUsage()
	{
		super("Email Service");
		ArrayList<Product> initList = new ArrayList<>();
		initList.add(new Product("Email Accounts", 0.04));
		setProducts(initList);
	}
}
