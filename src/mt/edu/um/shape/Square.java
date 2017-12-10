package mt.edu.um.shape;

import mt.edu.um.ShapeSingleton;

import java.awt.*;
import java.util.Random;

/**
 * Square representation
 */
public class Square extends Shape{

    /**
     * call super constructor and create default shape size
     * @param xPos user canvas x coordinate selection
     * @param yPos user canvas y coordinate selection
     */
    public Square(int xPos, int yPos) {
        super(xPos, yPos, 4,1, ShapeSingleton.StrShapeRepresentation.SQUARE);

        Random rand = new Random();
        int width = rand.nextInt(90) + 30; //get random length between 30 and 90
        int height = width;

        setShapeWidth(width);
        setShapeHeight(height);
    }

    /**
     * draw square
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
