package main;

public class Dog {
	private int color, eyeColor;
	private	double height, length, weigth;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(int eyeColor) {
		this.eyeColor = eyeColor;
	}
	public double getHeight() {
		return height;
	}
	public boolean setHeight(double height) {
		if(height<=0) return false; 
		this.height = height;
		return true;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWeigth() {
		return weigth;
	}
	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}
	
	public void sit() {
		System.out.println("Sitting");
	}
	public void layDown() {
		System.out.println("Laying down");
	}
	public void Shake() {
		System.out.println(name + " is Shaking");
	}
	
	
	public Dog(String name, int color, int eyeColor, double height, double length, double weigth) {
		this.name = name;
		this.color = color;
		this.eyeColor = eyeColor;
		this.height = height;
		this.length = length;
		this.weigth = weigth;
		
	}
	
	@Override
	public String toString() {
		return "Dog [color=" + color + ", eyeColor=" + eyeColor + ", height=" + height + ", length=" + length
				+ ", weigth=" + weigth + ", name=" + name + "]";
	}
}
