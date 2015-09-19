
public class Sheep extends Animal
{
	public Sheep()
	{
		super.setEat(30);
		super.setSleep(4000);
		makeNoise();
	}
	
	public void makeNoise()
	{
		System.out.println("A sheep says baaa! sleeps for " + super.getSleep() + "ms and eats "+ super.getEat() + "kj of food");
	}
	
	public void eat()
	{
		super.setEat(30);
		System.out.println("A sheep eats " + super.getEat() + "kj of food");
	}
	
	public void sleep()
	{
		super.setSleep(4000);
		System.out.println("A sheep sleeps for " + super.getSleep() + "ms");
		try{Thread.sleep(super.getSleep());}catch(Exception e){}
	}
}
