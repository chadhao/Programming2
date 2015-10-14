
public abstract class ServiceUsage implements Comparable<ServiceUsage>
{
	private String serviceName;
	
	@Override
	public int compareTo(ServiceUsage o)
	{
		return this.serviceName.compareTo(o.serviceName);
	}
}
