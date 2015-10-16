
/**
 * The Interface PaymentSystem.
 */
public interface PaymentSystem
{
	
	/**
	 * Calculate bill.
	 *
	 * @param anAccount the an account
	 * @param serviceUsage the service usage
	 * @return the bill
	 */
	public Bill calculateBill(Account anAccount, ServiceUsage serviceUsage);
}