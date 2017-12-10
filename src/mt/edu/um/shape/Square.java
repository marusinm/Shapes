package mt.edu.um.shape;

import java.awt.*;
import java.util.Random;

public class Square extends Shape{

    public Square(int xPos, int yPos) {
        super(xPos, yPos, 4,1);

        Random rand = new Random();
        int width = rand.nextInt(90) + 30; //get random length between 30 and 90
        int height = width;

        setShapeWidth(width);
        setShapeHeight(height);
    }

    public void paint(Graphics g){
        super.paint(g);
        g.drawRect(xPos, yPos, getShapeWidth(), getShapeHeight());
    }
}
