import java.util.ArrayList;

public class SecurityUsage extends ServiceUsage
{
	private static final ArrayList<Product> INIT_LIST = new ArrayList<>();
	
	static
	{
		INIT_LIST.add(new Product("SSL Certificates", 0.49));
		INIT_LIST.add(new Product("DDoS Firewalls", 0.31));
	}
	
	public SecurityUsage()
	{
		super("Security Service", INIT_LIST);
	}
}
