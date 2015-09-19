
public class Cat extends Animal
{
	public Cat()
	{
		super.setEat(50);
		super.setSleep(9000);
		makeNoise();
	}
	
	public void makeNoise()
	{
		System.out.println("A cat says meow! sleeps for " + super.getSleep() + "ms and eats "+ super.getEat() + "kj of food");
	}
	
	public void eat()
	{
		super.setEat(50);
		System.out.println("A cat eats " + super.getEat() + "kj of food");
	}
	
	public void sleep()
	{
		super.setSleep(9000);
		System.out.println("A cat sleeps for " + super.getSleep() + "ms");
		try{Thread.sleep(super.getSleep());}catch(Exception e){}
	}
}
