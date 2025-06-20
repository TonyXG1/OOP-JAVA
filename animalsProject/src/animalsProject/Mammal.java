package animalsProject;

public class Mammal extends Animal{

	public Mammal(String name) {
		super(name);
	}
	
	public void Move() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is moving.");
	}
	public void Eat()
	{
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is eating.");
	}
	public void Breathe()
	{
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is breathing air.");
	}
	public void Reproduce()
	{
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is reproducing.");
	}
	
	
}
