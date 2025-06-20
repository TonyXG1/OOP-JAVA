package animalsProject;

public class Reptile extends Animal{
	public Reptile(String name) {
		super(name);
	}
	
	public void Move() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is crawling.");
	}
	public void Eat()
	{
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is eating insects.");
	}
	public void Breathe()
	{
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is breathing air and water.");
	}
	public void Reproduce()
	{
		System.out.println(this.getClass().getSimpleName() + " " + this.getName() + " is reproducing.");
	}
	
	
}
