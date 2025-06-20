package asciiproject;

public class Alphabetical extends Character {
	public Alphabetical() {
		super();
	}
	
	public Alphabetical(char c) {
		super(c);
		checkCorrect();
		setClassName("Alphabetical");
	}
	
//	@Override
//	public void checkCorrect() {
//		setCorrect(getVal() >= 65 && getVal() <=90 && getVal() >=97 && getVal() <= 122);
//	}
	
	@Override
	public void checkCorrect() {
		setCorrect((getVal() >= 'A' && getVal() <= 'Z') || (getVal() >= 'a' && getVal() <= 'z'));
	}
	
	public Alphabetical uCase() {
		if(!getCorrect()) return new Alphabetical();
		if(getVal() >= 'A' && getVal() <='Z') return this;
		return new Alphabetical((char)(getVal() - 32));
		
		//return new Alphabetical((char) (getVal() - ('a'-'A')));
	}
	
	public Alphabetical lCase() {
		if(!getCorrect()) return new Alphabetical();
		if(getVal() >= 'a' && getVal() <='z') return this;
		return new Alphabetical((char) (getVal() + ('a' - 'A')));
		
		//return new Alphabetical((char)((getVal() + 32)));
	}

	@Override
	public String toString() {
		return "Alphabetical [Val = " + getVal() + ", correct = " + getCorrect() + ", Class name = " + getClassName()
				+ "]";
	}
	
	
}
