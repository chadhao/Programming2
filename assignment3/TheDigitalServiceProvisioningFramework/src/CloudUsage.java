import java.util.ArrayList;

public class CloudUsage extends ServiceUsage
{
	private static final ArrayList<Product> INIT_LIST = new ArrayList<>();
	
	static
	{
		INIT_LIST.add(new Product("Virtual Machines", 0.14));
		INIT_LIST.add(new Product("Disk Storage Devices", 0.51));
	}
	
	public CloudUsage()
	{
		super("Cloud Service", INIT_LIST);
	}
	
	
}
