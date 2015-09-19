
public class StringTest
{
	public static String getInitials(String string)
	{
		String initials = "";
		for (char aChar: string.toCharArray())
		{
			if (Character.isUpperCase(aChar))
			{
				initials += aChar + ". ";
			}
		}
		return initials;
	}
	
	public static String getCapital(String string)
	{
		return string.toUpperCase();
	}
	
	public static void main(String[] args)
	{
		System.out.println(getInitials("Kenneth Johnson"));
		System.out.println(getInitials("Firstname"));
		System.out.println(getInitials("Kenneth Johnson Esquire"));
	}

}
