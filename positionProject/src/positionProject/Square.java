package positionProject;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;


public class Square extends Point{
	private int side;
	
	public Square(int x, int y, org.eclipse.swt.graphics.Color c, int side) {
		super(x,y,c);
		this.side = side;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	@Override
	public String toString() {
		return String.format("[(%d, %d): %s; %b; %d]", getX(), getY(), getColor(), side);
	}
	
	@Override
	public void show(org.eclipse.swt.widgets.Canvas canvas) {
		if(isHidden()) {
			GC g = new GC(canvas);
			
			g.setBackground(new org.eclipse.swt.graphics.Color(Display.getCurrent(), getColorSWT().getRed(), 
					getColorSWT().getBlue(), getColorSWT().getGreen()));
			g.fillRectangle(getX(), getY(), side, side);
			g.dispose();
			setHidden(false);
		}
	}
	
	@Override
	public void hide(org.eclipse.swt.widgets.Canvas canvas) {
		if(!isHidden()) {
			GC g = new GC(canvas);
			g.setBackground(canvas.getBackground());
			g.fillRectangle(getX(), getY(), side, side);
			g.dispose();
			setHidden(true);
		}
	}
	
	public double area() { //*Problem with Circle.area() overriding/overloading
		return side*side;
	}
}
