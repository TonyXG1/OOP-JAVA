package studentsProject;

public class Main {

	public static void main(String[] args) {
		EGN e = new EGN(5608057723L);
		
		System.out.println(e.isCorrect());
		System.out.println(e.getSex());
		System.out.println(e.birthDate());
	
		Student stud1 = new Student("Anton", "Hristov", "Stoyanov", e);
		System.out.println(stud1);
	}
	

}
