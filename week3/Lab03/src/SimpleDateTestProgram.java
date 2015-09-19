import javax.tools.Diagnostic;

public class SimpleDateTestProgram
{

	public static void main(String[] args)
	{
		SimpleDate d1 = new SimpleDate();
		SimpleDate d2 = new SimpleDate();
		
		d1.setDate(22, 3, 2015);
		d2.setDate(21, 3, 2015);
		System.out.println("Is " + d1 + " before " + d2 + "? " + d1.isBefore(d2));
		
		d1.setDate(22, 3, 2015);
		d2.setDate(21, 3, 2015);
		System.out.println("Is " + d1 + " after " + d2 + "? " + d1.isAfter(d2));
		
		d1.setDate(13, 6, 2014);
		d2.setDate(13, 6, 2014);
		System.out.println("Is " + d1 + " before " + d2 + "? " + d1.isBefore(d2));
	}

}
