package mt.edu.um.shape;

import java.awt.Graphics;

public class Rectangle extends Shape{

    public Rectangle(int xPos, int yPos) {
        super(xPos, yPos, 4, 2);

        int width = (int )(Math.random() * 90 + 30); //get random length between 30 and 90
        int height = (int )(Math.random() * 90 + 30); //get random length between 30 and 90

        setShapeWidth(width);
        setShapeHeight(height);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(xPos, yPos, getShapeWidth(), getShapeHeight());
    }
}
