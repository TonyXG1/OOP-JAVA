package animalsProject;

public abstract class Animal {
	private String name;

	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	abstract void Move(); 
	abstract void Eat();
	abstract void Breathe();
	abstract void Reproduce();
	
	public Animal(String name) {
		setName(name);
	}
	
	@Override
	public String toString() {
		return String.format("%s", name);
	}
}
