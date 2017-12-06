package mt.edu.um.shape;

import java.awt.Graphics;

public class Square extends Shape{

    public Square(int xPos, int yPos) {
        super(xPos, yPos, 4,1);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(xPos, yPos, 100, 100);
    }
}
