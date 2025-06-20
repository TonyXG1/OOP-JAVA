package integerProject;

public class DigRow {
	private String value;
	private boolean correct;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		if(value == "") return;
		correct = false;
		
			for(int i = 0; i<value.length(); i++) {
				if(value.charAt(i) < '0' 
						|| value.charAt(i) > '9') return;
			}
		
		correct = true;
	}
	
	public boolean isCorrect() {
		return correct;
	}
	
	public boolean isEmpty() {
		return value.length() == 0;
	}
	
	public DigRow() {
		setValue("0");
	}
	
	public DigRow(String value) {
		setValue(value);
	}
	
	public int leadZeroCount() {
		if(correct == false) return -1;
		int count = 0;
		int i = 0;
		while(value.charAt(i) == '0') {
			count++;
			i++;
		}
		return count;
	}
	
	@Override
	public String toString() {
		if (correct == false) return "Incorrect";
		return value;
	}
	
	
}
