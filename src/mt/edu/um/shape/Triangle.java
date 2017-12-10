package mt.edu.um.shape;

import java.awt.Graphics;

/**
 * Triangle representation
 */
public class Triangle extends Shape{

    /**
     * call super constructor and create default shape size
     * @param xPos user canvas x coordinate selection
     * @param yPos user canvas y coordinate selection
     */
    public Triangle(int xPos, int yPos) {
        super(xPos, yPos, 3, 3);

        int width = (int )(Math.random() * 90 + 30); //get random length between 30 and 90
        int height = width;

        setShapeWidth(width);
        setShapeHeight(height);
    }

    /**
     * draw triangle
     * @param g
     */
    public void paint(Graphics g){
        super.paint(g);
        g.drawPolygon(new int[]{xPos, xPos + getShapeWidth(), xPos - getShapeWidth()},
                new int[]{yPos, yPos + getShapeHeight(), yPos + getShapeHeight()},
                3);
    }
}
