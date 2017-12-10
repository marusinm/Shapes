package mt.edu.um;

import mt.edu.um.shape.Shape;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Singleton storing current context of application
 */
public class ShapeSingleton {

    private static ShapeSingleton instance;
    private ArrayList<Shape> allDrawnShapes = new ArrayList<>(); //all drawn geometrical objects

    //String shape representation via Enum
    public enum StrShapeRepresentation {
        SQUARE, RECTANGLE, CIRCLE, TRIANGLE
    }
    private StrShapeRepresentation currentShape = null; //represent selected shape


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

    /**
     * add new drawn shape
     */
    public void addShape(Shape shape){
        allDrawnShapes.add(shape);
    }

    public ArrayList<Shape> getAllShapes(){
        return allDrawnShapes;
    }

    /**
     * TODO
     * @param jFrame
     * @return
     */
    public boolean serializeAllShapes(JFrame jFrame){
        final JFileChooser fc = new JFileChooser("");
        int returnVal = fc.showSaveDialog(jFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                for (Shape shape : getAllShapes()) {
                    out.writeObject(shape);
                }
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }

            System.out.println("Saved on path: " + file.getAbsoluteFile().toString());
            JOptionPane.showMessageDialog(jFrame, "Game saved!");
        } else {
            System.out.println("Open command cancelled by user.");
        }

        return true;
    }

    /**
     * TODO:
     * @param jFrame
     * @return
     */
    public boolean deserializeAllShapes(JFrame jFrame){

        final JFileChooser fc = new JFileChooser("");
        int returnVal = fc.showOpenDialog(jFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //TODO:
        } else {
            System.out.println("Open command cancelled by user.");
        }

        return true;
    }

    public void setCurrentShape(StrShapeRepresentation currentShape){
        this.currentShape = currentShape;
    }

    public StrShapeRepresentation getCurrentShape(){
        return this.currentShape;
    }



}