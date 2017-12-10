package mt.edu.um.shape;

import mt.edu.um.ShapeSingleton;

import java.awt.Graphics;

/**
 * Rectangle representation
 */
public class Rectangle extends Shape{

    /**
     * call super constructor and create default shape size
     * @param xPos user canvas x coordinate selection
     * @param yPos user canvas y coordinate selection
     */
    public Rectangle(int xPos, int yPos) {
        super(xPos, yPos, 4, 2, ShapeSingleton.StrShapeRepresentation.RECTANGLE);

        int width = (int )(Math.random() * 90 + 30); //get random length between 30 and 90
        int height = (int )(Math.random() * 90 + 30); //get random length between 30 and 90

        setShapeWidth(width);
        setShapeHeight(height);
    }

    /**
     * draw rectangle
     * @param g
     */
    public void paint(Graphics g){
        super.paint(g);
//        g.setColor(getShapeColor()); //outline of shape has the same colour now as whole object
        g.drawRect(xPos, yPos, getShapeWidth(), getShapeHeight());
        g.setColor(getShapeColor());
        g.fillRect(xPos, yPos, getShapeWidth(), getShapeHeight());
    }
}
