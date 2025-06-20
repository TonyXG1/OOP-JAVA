package positionProject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class VisualTest {

	protected Shell shell;
	private org.eclipse.swt.widgets.Canvas canvas;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			VisualTest window = new VisualTest();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		test();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Drawboard");
		canvas = new org.eclipse.swt.widgets.Canvas (shell, SWT.NONE);
		canvas.setBounds(0, 15, 422, 233);
	}
	private void test() {
		Point p = new Point(canvas.getBounds().width/2, canvas.getBounds().height/2, new Color(150,160,200));
		p.show(canvas);
		p.moveTo(2, 1, canvas); //Move-to trqbva da se opravi
		
		Square s = new Square(100, 200, new Color(200, 2, 12), 20);
		s.show(canvas);
		System.out.println(s.area());
		
		Circle c = new Circle(100, 200, new Color(2, 200, 12), 20);
		c.show(canvas);
		c.hide(canvas); //Zakriva figurata pod sebe si i q ocvetqva cvqt na canvasa
		System.out.println(c.area());
		
		Rectangle r = new Rectangle(60, 21, new Color(2, 231, 233), 100, 23);
		r.show(canvas);
		
	}
}
