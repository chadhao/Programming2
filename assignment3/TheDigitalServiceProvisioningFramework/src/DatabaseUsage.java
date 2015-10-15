import java.util.ArrayList;

public class DatabaseUsage extends ServiceUsage
{
	private static final ArrayList<Product> INIT_LIST = new ArrayList<>();
	
	static
	{
		INIT_LIST.add(new Product("Relational Databases", 0.29));
		INIT_LIST.add(new Product("In-memory Cache Nodes", 0.02));
		INIT_LIST.add(new Product("Data Warehouse Dense Storage Nodes", 0.33));
	}
	
	public DatabaseUsage()
	{
		super("Database Service", INIT_LIST);
	}
}
