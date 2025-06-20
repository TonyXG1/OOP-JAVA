package positionProject;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;

public class Circle extends Square{
	public Circle(int x, int y, org.eclipse.swt.graphics.Color c, int side) {
		super(x, y, c, side);
	}
	
	public int getRadius() {
		return getSide()/2;
	}
	
	public void setRadius(int r) {
		setSide(r*2);
	}
	
	@Override
	public void show(org.eclipse.swt.widgets.Canvas canvas) {
		if(isHidden()) {
			GC g = new GC(canvas);
			g.setBackground(new org.eclipse.swt.graphics.Color(Display.getCurrent(), getColorSWT().getRed(),
					getColorSWT().getGreen(), getColorSWT().getBlue()));
			
			g.fillOval(getX(), getY(), getSide(), getSide());
			g.dispose();
			setHidden(false);
		}
	}
	
	@Override
	public void hide(org.eclipse.swt.widgets.Canvas canvas) {
		if(!isHidden()) {
			GC g = new GC(canvas);
			g.setBackground(canvas.getBackground());
			
			g.fillOval(getX(), getY(), getSide(), getSide());
			g.dispose();
			setHidden(true);
		}
	}
	
	@Override
	public double area() {
		return Math.PI*(getRadius()*getRadius());
	}
}
