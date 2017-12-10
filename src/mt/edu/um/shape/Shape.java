package mt.edu.um.shape;

import javax.swing.JPanel;

public class Shape extends JPanel{
    
    protected int xPos;
    protected int yPos;
    protected int numOfSides;
    protected int numOfDifferentLengthSides;
    protected int shapeHeight;
    protected int shapeWidth;

    public Shape(int xPos, int yPos, int numOfSides, int numOfDifferentLengthSides) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.numOfSides = numOfSides;
        this.numOfDifferentLengthSides = numOfDifferentLengthSides;
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

    protected int getShapeHeight() {
        return shapeHeight;
    }
    protected void setShapeHeight(int shapeHeight) {
        this.shapeHeight = shapeHeight;
    }

    public int getShapeWidth() {
        return shapeWidth;
    }

    public void setShapeWidth(int shapeWidth) {
        this.shapeWidth = shapeWidth;
    }

    //TODO: finish according specification
    public String findArea(){
        return null;
    }

    public String findPerimeter(){
        return null;
    }
}