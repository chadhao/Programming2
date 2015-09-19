
public class Cow extends Animal
{
	public Cow()
	{
		super.setEat(10);
		super.setSleep(6000);
		makeNoise();
	}
	
	public void makeNoise()
	{
		System.out.println("A cow says mooo! sleeps for " + super.getSleep() + "ms and eats "+ super.getEat() + "kj of food");
	}
	
	public void eat()
	{
		super.setEat(10);
		System.out.println("A cow eats " + super.getEat() + "kj of food");
	}
	
	public void sleep()
	{
		super.setSleep(6000);
		System.out.println("A cow sleeps for " + super.getSleep() + "ms");
		try{Thread.sleep(super.getSleep());}catch(Exception e){}
	}
}
