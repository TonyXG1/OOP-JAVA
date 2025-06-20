package positionProject;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Display;



public class Point extends Position {
	private org.eclipse.swt.graphics.Color c;
	
	public Point() {
		super();
		c = new org.eclipse.swt.graphics.Color(0,0,0);
	}
	
	public Point(int x, int y) {
		super(x, y);
		c = new org.eclipse.swt.graphics.Color(0,0,0);
	}
	
	public Point(int x, int y, org.eclipse.swt.graphics.Color c) {
		super(x, y);
		this.c = c;
	}
	
	public String getColor() {
		return String.format(" [r = %d, g = %d, b = %d]", c.getRed(), c.getGreen(), c.getBlue());
	}
	
	public org.eclipse.swt.graphics.Color getColorSWT(){
		return c;
	}
	
	public void setColor(int r, int g, int b) {
		c = new org.eclipse.swt.graphics.Color(r, g, b);
	}
	
	public void show(org.eclipse.swt.widgets.Canvas canvas) {
		if(isHidden()) {
			GC g = new GC(canvas);
			g.setBackground(new org.eclipse.swt.graphics.Color(Display.getCurrent(), c.getRed(), c.getGreen(), c.getBlue()));
			g.fillOval(getX(), getY(), 8, 8);
			g.dispose();
			setHidden(false);
		}
		
	}
	
	public void hide(org.eclipse.swt.widgets.Canvas canvas) {
		if(!isHidden()) {
			GC g = new GC(canvas);
			g.setBackground(canvas.getBackground());
			g.fillOval(getX(), getY(), 8, 8);
			g.dispose();
			setHidden(true);
		}
	}
	
	
	@Override
	public String toString(){
		return super.toString() + getColor();
	}
}
