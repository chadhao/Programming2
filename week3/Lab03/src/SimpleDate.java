
public class SimpleDate {
	private int day;
	private int month;
	private int year;
	
	public SimpleDate(int day, int month, int year)
	{
		setDate(day, month, year);
	}
	
	public SimpleDate()
	{
		setDate(1, 1, 2000);
	}
	
	public String toString()
	{
		String year = Integer.toString(this.year);
		String month = (this.month < 10)?("0"+this.month):Integer.toString(this.month);
		String day = (this.day < 10)?("0"+this.day):Integer.toString(this.day);
		return day+"/"+month+"/"+year;
		
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public void setDay(int day)
	{
		if (day > 0 && day < 32)
		{
			this.day = day;
		}
		else
		{
			this.day = 1;
		}
	}
	
	public void setMonth(int month)
	{
		if (month > 0 && month < 13)
		{
			this.month = month;
		}
		else
		{
			this.month = 1;
		}
	}
	
	public void setYear(int year)
	{
		if (year > 1999 && year < 2016)
		{
			this.year = year;
		}
		else
		{
			this.year = 2000;
		}
	}
	
	public void setDate(int aDay, int aMonth, int aYear)
	{
		setDay(aDay);
		setMonth(aMonth);
		setYear(aYear);
	}
	
	public boolean isSameDate(SimpleDate aDate)
	{
		return this.year==aDate.getYear()&&this.month==aDate.getMonth()&&this.day==aDate.getDay();
	}
	
	public boolean isBefore(SimpleDate aDate)
	{
		boolean isBefore = false;
		if (this.year < aDate.getYear())
		{
			isBefore = true;
		}
		if (this.year == aDate.getYear() && this.month < aDate.getMonth())
		{
			isBefore = true;
		}
		if (this.year == aDate.getYear() && this.month == aDate.getYear() && this.day < aDate.getDay())
		{
			isBefore = true;
		}
		return isBefore;
	}
	
	public boolean isAfter(SimpleDate aDate)
	{
		boolean isAfter = false;
		if (this.year > aDate.getYear())
		{
			isAfter = true;
		}
		if (this.year == aDate.getYear() && this.month > aDate.getMonth())
		{
			isAfter = true;
		}
		if (this.year == aDate.getYear() && this.month == aDate.getMonth() && this.day > aDate.getDay())
		{
			isAfter = true;
		}
		return isAfter;
	}
}
