import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sierpinski extends JFrame {
	public static int WIDTH = 500;
	public static int HEIGHT = 500;
	public static int BUFFER = 50;
	
	public static Graphics g;
	
	//first triangle vertices
	static Point p1 = new Point (BUFFER, HEIGHT);
	static Point p2 = new Point (WIDTH, HEIGHT);
	static Point p3 = new Point (BUFFER + WIDTH/2, (int)(HEIGHT - (WIDTH/2 * Math.sqrt(3))));
	
	public Sierpinski(){
        initGUI();
        
        setTitle("Sierpinski Triangle");
        setResizable(false);
        //pack();
        setSize(WIDTH + 100, HEIGHT + 100);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
    }
	
	
	private void initGUI(){

        JPanel triangles = new JPanel();
        add(triangles, BorderLayout.PAGE_END);
        
        triangles.paint(g);
        
    }
	
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		
		drawSierpinski(8, p1, p2, p3, g);
	}
	
	public void drawSierpinski(int i, Point p1, Point p2, Point p3, Graphics g) {
		//base case - stop when done iterating
		if (i == 0) return;
		
		//general solution - draw the triangle requested
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
		g.drawLine(p2.x, p2.y, p3.x, p3.y);
		g.drawLine(p1.x, p1.y, p3.x, p3.y);
		
		i--;
		
		//reduced problem to draw 3 internal triangles
		drawSierpinski(i, p1, midPoint(p1, p2), midPoint(p1, p3), g);
		drawSierpinski(i, p2, midPoint(p2, p1), midPoint(p2, p3), g);
		drawSierpinski(i, p3, midPoint(p3, p1), midPoint(p3, p2), g);
		
	}
	
	private static Point midPoint(Point p1, Point p2){
		Point midPoint = new Point();
		midPoint.x = (p1.x + p2.x)/2;
		midPoint.y = (p1.y + p2.y)/2;
		return midPoint;
	}

	public static void main(String[] args) {
		Sierpinski sierp = new Sierpinski();
		

	}

}
