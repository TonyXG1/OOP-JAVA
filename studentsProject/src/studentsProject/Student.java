package studentsProject;

public class Student {
	private String name1;
	private String name2;
	private String name3;
	private EGN egn;
		
	public String getName1() {
		return name1;
	}
	public String getName2() {
		return name2;
	}
	public String getName3() {
		return name3;
	}
	public String getEGN() {
		return egn.toString();
	}
	
	public Student(String name1, String name2, String name3, EGN egn) {
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.egn = egn;
	}
	
	public Student(String name1, String name2, String name3, String egn) {
		EGN e = new EGN(egn);
		this.name1 = name1;
		this.name2 = name2;
		this.name3 = name3;
		this.egn = e;
		
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s, %s", name1, name2, name3, egn.toString());
	}
	

}
