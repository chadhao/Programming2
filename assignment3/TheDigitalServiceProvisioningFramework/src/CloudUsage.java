import java.util.ArrayList;

public class CloudUsage extends ServiceUsage
{
	public CloudUsage()
	{
		super("Cloud Service");
		ArrayList<Product> initList = new ArrayList<>();
		initList.add(new Product("Virtual Machines", 0.14));
		initList.add(new Product("Disk Storage Devices", 0.51));
		setProducts(initList);
	}
}
