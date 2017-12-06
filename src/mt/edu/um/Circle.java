package mt.edu.um;

import java.awt.Graphics;

public class Circle extends Shape{

    public Circle(int xPos, int yPos) {
        super(xPos, yPos);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.drawArc(xPos, yPos,50,50,0,360);
    }
}
