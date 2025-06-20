package integerProject;

public class Natural0 extends Natural {
	public Natural0(){
		super("0");
	}
	
	@Override
	public boolean isCorrect() {
		if(super.isCorrect()) return true;
		return getValue().equals("0");
	}
	
	
	@Override
	public void setValue(String s) {
		super.setValue(s);
		if(super.isCorrect()) return;
		
		
		
	}
}
