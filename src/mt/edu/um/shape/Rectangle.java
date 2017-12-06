package mt.edu.um.shape;

import java.awt.Graphics;

public class Rectangle extends Shape{

    public Rectangle(int xPos, int yPos) {
        super(xPos, yPos, 4, 2);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(xPos, yPos, 150, 100);
    }
}
