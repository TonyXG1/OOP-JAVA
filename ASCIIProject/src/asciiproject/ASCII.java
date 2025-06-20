package asciiproject;

public abstract class ASCII {
	private char val;
	private boolean correct;
	protected String name;
	
	public ASCII() {
		val = 128;
		correct = false;
		name = "";
	}
	
	public ASCII(char val) {
		this.val = val;
		checkCorrect();
		name = "ASCII";
	}

	public char getVal() {
		return val;
	}
	
	public String getClassName(){
		return name;
	}
	
	public boolean getCorrect() {
		return correct;
	}
	
	protected void setClassName(String name) {
		this.name = name;
	}
	
	protected void setCorrect(boolean b) {
		correct = b;
	}
	
	public abstract void output();
	
//	public void output() {
//		if(val>31) System.out.println(val);
//		else System.out.println("Unavailable character");
//	}
//
	public void repeat(int n) {
		if(correct == false) return;
		String s = "";
		for(int i=0; i<n; i++) {
			output();
		}
		System.out.println(s);
	}
	
	public void checkCorrect() {
		correct = val>=0 && val <=127;
	}
	
}
