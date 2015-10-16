import java.util.ArrayList;

/**
 * The Class DatabaseUsage.
 */
public class DatabaseUsage extends ServiceUsage
{
	
	/**
	 * Instantiates a new database usage.
	 */
	public DatabaseUsage()
	{
		super("Database Service");
		ArrayList<Product> initList = new ArrayList<>();
		initList.add(new Product("Relational Databases", 0.29));
		initList.add(new Product("In-memory Cache Nodes", 0.02));
		initList.add(new Product("Data Warehouse Dense Storage Nodes", 0.33));
		setProducts(initList);
	}
}
