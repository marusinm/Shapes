package mt.edu.um.shape;

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
        super(xPos, yPos, 4,1);

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
        g.drawRect(xPos, yPos, getShapeWidth(), getShapeHeight());
    }
}
