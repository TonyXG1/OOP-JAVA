package asciiproject;

public class Character extends ASCII{
	public Character() {
		super();
	}
	
	public Character(char c) {
		super(c);
		checkCorrect();
		setClassName("Character");
	}
	
	@Override
	public void checkCorrect() {
		setCorrect(getVal() > 31 && getVal() <= 127);
	}
	
	public void output() {
		if(getCorrect()) {
			System.out.print(getVal());
		}
	}
}