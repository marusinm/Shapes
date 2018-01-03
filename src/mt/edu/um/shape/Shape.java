package mt.edu.um.shape;

import mt.edu.um.ShapeSingleton;

import javax.swing.JPanel;
import java.awt.*;
import java.io.Serializable;
import java.util.Random;

/**
 * Parent class for all geometric objects
 */
public class Shape extends JPanel implements Serializable{
    
    protected int xPos;
    protected int yPos;
    protected int numOfSides;
    protected int numOfDifferentLengthSides;
    protected int shapeHeight;
    protected int shapeWidth;
    Color randomColor;
    ShapeSingleton.StrShapeRepresentation shape;

    public Shape(int xPos, int yPos, int numOfSides, int numOfDifferentLengthSides, ShapeSingleton.StrShapeRepresentation shape) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.numOfSides = numOfSides;
        this.numOfDifferentLengthSides = numOfDifferentLengthSides;
        this.shape = shape;

        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        randomColor = new Color(r, g, b);

    }

    /**
     * implemented in subclasses
     * @param myShape
     */
    public void showInformationDialog(Shape myShape){
    }


    //standard getters and setters

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setNumOfSides(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public int getNumOfDifferentLengthSides() {
        return numOfDifferentLengthSides;
    }

    public void setNumOfDifferentLengthSides(int numOfDifferentLengthSides) {
        this.numOfDifferentLengthSides = numOfDifferentLengthSides;
    }

    public int getShapeHeight() {
        return shapeHeight;
    }
    public void setShapeHeight(int shapeHeight) {
        this.shapeHeight = shapeHeight;
    }

    public int getShapeWidth() {
        return shapeWidth;
    }

    public void setShapeWidth(int shapeWidth) {
        this.shapeWidth = shapeWidth;
    }

    public Color getShapeColor() {
        return randomColor;
    }


    public ShapeSingleton.StrShapeRepresentation getShape() {
        return shape;
    }


//    //TODO: finish according specification
//    public String findArea(){
//        return null;
//    }
//
//    public String findPerimeter(){
//        return null;
//    }
}