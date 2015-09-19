
public class Dog extends Animal
{
	public Dog()
	{
		super.setEat(20);
		super.setSleep(2000);
		makeNoise();
	}
	
	public void makeNoise()
	{
		System.out.println("A dog says woof! sleeps for " + super.getSleep() + "ms and eats "+ super.getEat() + "kj of food");
	}
	
	public void eat()
	{
		super.setEat(20);
		System.out.println("A dog eats " + super.getEat() + "kj of food");
	}
	
	public void sleep()
	{
		super.setSleep(2000);
		System.out.println("A dog sleeps for " + super.getSleep() + "ms");
		try{Thread.sleep(super.getSleep());}catch(Exception e){}
	}
}
