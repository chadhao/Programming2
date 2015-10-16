import java.util.ArrayList;

/**
 * The Class EmailUsage.
 */
public class EmailUsage extends ServiceUsage
{
	
	/**
	 * Instantiates a new email usage.
	 */
	public EmailUsage()
	{
		super("Email Service");
		ArrayList<Product> initList = new ArrayList<>();
		initList.add(new Product("Email Accounts", 0.04));
		setProducts(initList);
	}
}
