package animalsProject;

public class Lizard extends Reptile{
	private String name;
	
	public Lizard(String name) {
		super("Lizard");
		this.name = name;
	}
	
	public String getLizardName() {
		return name;
	}
	
	@Override
	public void Move() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getLizardName() + " is crawling.");
	}
	@Override
	public void Eat() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getLizardName() + " is eating insects.");
	}
	@Override
	public void Breathe() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getLizardName() + " is breathing air and water.");
	}
	@Override
	public void Reproduce() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getLizardName() + " is laying eggs.");
	}

	@Override
	public String toString() {
		return String.format("%s , %s", this.getName(), this.getLizardName());
	}
	
	
}
