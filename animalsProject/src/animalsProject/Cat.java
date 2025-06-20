package animalsProject;

public class Cat extends Mammal{

		private String name;
		
		public String getCatName() {
			return name;
		}

		public Cat (String name) {
			super("Cat");
			this.name = name;
		}
		
		@Override
		public void Move() {
			System.out.println(this.getClass().getSimpleName() + " " + this.getCatName() + " is walking.");
		}
		@Override
		public void Eat() {
			System.out.println(this.getClass().getSimpleName() + " " + this.getCatName() + " is munching.");
		}
		@Override
		public void Breathe() {
			System.out.println(this.getClass().getSimpleName() + " " + this.getCatName() + " purrs.");
		}
		@Override
		public void Reproduce() {
			System.out.println(this.getClass().getSimpleName() + " " + this.getCatName() + " is reproducing.");
		}
		
		@Override
		public String toString() {
			return String.format("%s , %s", this.getName(), this.getCatName());
		}

}
