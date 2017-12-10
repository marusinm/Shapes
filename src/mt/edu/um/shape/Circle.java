package mt.edu.um.shape;

import java.awt.Graphics;

public class Circle extends Shape{

    public Circle(int xPos, int yPos) {
        super(xPos, yPos, 0, 0);

        int width = (int )(Math.random() * 90 + 30); //get random length between 30 and 90
        int height = width;

        setShapeWidth(width);
        setShapeHeight(height);
    }
    
    public void paint(Graphics g){
        super.paint(g);
        g.drawArc(xPos, yPos,getShapeWidth(), getShapeHeight(),0,360);
    }
}
