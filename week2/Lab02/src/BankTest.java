
public class BankTest {

	public static void main(String[] args) {
		int n = 5;
		Bank[] bankCustomer = new Bank[n];
		
		for (int i = 0; i < n; i++)
		{
			bankCustomer[i] = new Bank();
			bankCustomer[i].name = String.valueOf(11111 * (i+1));
			bankCustomer[i].accountNumber = 11111 * (i+1);
		}
		
	}

}
