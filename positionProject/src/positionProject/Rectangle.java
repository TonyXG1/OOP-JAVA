package positionProject;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

public class Rectangle extends Square{
	private int side;
	public Rectangle(int x, int y, org.eclipse.swt.graphics.Color c, int side1, int side2) {
		super(x,y,c,side1);
		side = side2;
	}
	
	public int getSide1() {
		return getSide();
	}
	
	public void setSide1(int side1) {
		setSide(side1);
	}

	public int getSide2() {
		return side;
	}

	public void setSide2(int side) {
		this.side = side;
	}
	
	@Override
	public String toString() {
		return String.format("[(%d, %d): %s; %b; %d, %d]", getX(), getY(), getColor(), getSide1(), getSide2());
	}
	
	@Override
	public void show(org.eclipse.swt.widgets.Canvas canvas) {
		if(isHidden()) {
			GC g = new GC(canvas);
			
			g.setBackground(new org.eclipse.swt.graphics.Color(Display.getCurrent(), getColorSWT().getRed(), 
					getColorSWT().getBlue(), getColorSWT().getGreen()));
			g.fillRectangle(getX(), getY(), getSide1(), getSide2());
			g.dispose();
			setHidden(false);
		}
	}
	
	@Override
	public void hide(org.eclipse.swt.widgets.Canvas canvas) {
		if(!isHidden()) {
			GC g = new GC(canvas);
			g.setBackground(canvas.getBackground());
			g.fillRectangle(getX(), getY(), getSide1(), getSide2());
			g.dispose();
			setHidden(true);
		}
	}
}
