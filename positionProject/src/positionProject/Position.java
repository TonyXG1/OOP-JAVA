package positionProject;

public abstract class Position {
	private int x, y;
	private boolean hidden = true;
	
	public Position() {
		this(0,0);
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	abstract void show(org.eclipse.swt.widgets.Canvas canvas);
	abstract void hide(org.eclipse.swt.widgets.Canvas canvas);
	
	//TODO
	public void moveTo(int x, int y, org.eclipse.swt.widgets.Canvas canvas) {
		this.setX(x);
		this.setY(y);
		
	}
	
	@Override
	public String toString() {
		return String.format("(%d ; %d)", x, y);
	}
}
