package mt.edu.um.shape;

import mt.edu.um.ShapeSingleton;

import java.awt.Graphics;

/**
 * Circle representation
 */
public class Circle extends Shape{

    /**
     * call super constructor and create default shape size
     * @param xPos user canvas x coordinate selection
     * @param yPos user canvas y coordinate selection
     */
    public Circle(int xPos, int yPos) {
        super(xPos, yPos, 0, 0, ShapeSingleton.StrShapeRepresentation.CIRCLE);

        int width = (int )(Math.random() * 90 + 30); //get random length between 30 and 90
        int height = width;

        setShapeWidth(width);
        setShapeHeight(height);
    }

    /**
     * draw circle
     * @param g
     */
    public void paint(Graphics g){
        super.paint(g);
//        g.setColor(getShapeColor()); //outline of shape has the same colour now as whole object
        g.drawArc(xPos, yPos,getShapeWidth(), getShapeHeight(),0,360);
        g.setColor(getShapeColor());
        g.fillArc(xPos, yPos,getShapeWidth(), getShapeHeight(),0,360);
    }
}
