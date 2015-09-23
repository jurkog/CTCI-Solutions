import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Study extends JFrame {
	private Point coords[][] = new Point[100][2];
	private int count = 0;
	
	Study() {
		setSize(400, 400);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				coords[count][0] = new Point(e.getX(), e.getY());
			}
			
			public void mouseReleased(MouseEvent e) {
				coords[count][1] = new Point(e.getX(), e.getY());
				count++;
				repaint();
			}
		});
		
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		for (int i = 0; i < count; i++) {
			g.drawLine((int)coords[i][0].getX(), (int)coords[i][0].getY(), (int)coords[i][1].getX(), (int)coords[i][1].getY());
		}
	}
	
	public static void main(String args[]) {
		Study study = new Study();
	}
}