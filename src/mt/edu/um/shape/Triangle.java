package mt.edu.um.shape;

import java.awt.Graphics;

public class Triangle extends Shape{

    public Triangle(int xPos, int yPos) {
        super(xPos, yPos, 3, 3);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawPolygon(new int[]{xPos, xPos + 50, xPos - 50},new int[]{yPos, yPos + 50, yPos + 50}, 3);
    }
}
