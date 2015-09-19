
public class NitfluxTest {

	public static void main(String[] args) {
		Nitflux[] user = new Nitflux[3];
		
		user[0] = new Nitflux();
		user[1] = new Nitflux();
		user[2] = new Nitflux();
		
		user[0].email = "aaa@aaa.com";
		user[0].month = 12;
		user[0].money = 4.99;
		user[0].bankInfo.name = "aaa";
		user[0].bankInfo.accountNumber = 11111;
		
		user[1].email = "bbb@bbb.com";
		user[1].month = 24;
		user[1].money = 3.99;
		user[1].bankInfo.name = "bbb";
		user[1].bankInfo.accountNumber = 22222;
		
		user[2].email = "ccc@ccc.com";
		user[2].month = 36;
		user[2].money = 2.99;
		user[2].bankInfo.name = "ccc";
		user[2].bankInfo.accountNumber = 33333;
		
		for (int i = 0; i < 3; i++)
		{
			System.out.println("Amount to pay for user" + (i+1) + " is: " + String.format("%.2f", (user[i].month*user[i].money)));
		}
	}

}
