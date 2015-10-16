import java.util.ArrayList;

/**
 * The Class SecurityUsage.
 */
public class SecurityUsage extends ServiceUsage
{
	
	/**
	 * Instantiates a new security usage.
	 */
	public SecurityUsage()
	{
		super("Security Service");
		ArrayList<Product> initList = new ArrayList<>();
		initList.add(new Product("SSL Certificates", 0.49));
		initList.add(new Product("DDoS Firewalls", 0.31));
		setProducts(initList);
	}
}
