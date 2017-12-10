package mt.edu.um;

import mt.edu.um.shape.Shape;

import java.util.ArrayList;

/**
 * Singleton storing current context of application
 */
public class ShapeSingleton {

    private static ShapeSingleton instance;

    private ShapeSingleton(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new ShapeSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static ShapeSingleton getInstance(){
        return instance;
    }

    /*
     * all drawn geometrical objects
     */
    private ArrayList<Shape> allDrawnShapes = new ArrayList<>();

    /**
     * add new drawn shape
     */
    public void addShape(Shape shape){
        allDrawnShapes.add(shape);
    }

    public ArrayList<Shape> getAllShapes(){
        return allDrawnShapes;
    }

    /*
     * String shape representation via Enum
     */

    public enum StrShapeRepresentation {
        SQUARE, RECTANGLE, CIRCLE, TRIANGLE
    }

    //represent selected shape
    private StrShapeRepresentation currentShape = null;

    public void setCurrentShape(StrShapeRepresentation currentShape){
        this.currentShape = currentShape;
    }

    public StrShapeRepresentation getCurrentShape(){
        return this.currentShape;
    }



}