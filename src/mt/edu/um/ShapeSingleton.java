package mt.edu.um;

import mt.edu.um.shape.Shape;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Singleton storing current context of application
 */
public class ShapeSingleton {

    private static ShapeSingleton instance;
    private ArrayList<Shape> allDrawnShapes = new ArrayList<>(); //all drawn geometrical objects
    private StrShapeRepresentation currentShape = null; //represent selected shape

    //String shape representation via Enum
    public enum StrShapeRepresentation {
        SQUARE, RECTANGLE, CIRCLE, TRIANGLE
    }


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
     * reinitialization/clear list of all drawn shapes
     */
    public void removeAllShapes(){
        this.allDrawnShapes = new ArrayList<>();
    }

    /**
     * Serialize shape objects into a file
     * @param jFrame parent frame for file system dialog
     * @return true, if operation succeed
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
     * Deserialize shape objects from a file
     * @param jFrame parent frame for file system dialog
     * @return true, if operation succeed
     */
    public boolean deserializeAllShapes(JFrame jFrame){

        final JFileChooser fc = new JFileChooser("");
        int returnVal = fc.showOpenDialog(jFrame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            this.allDrawnShapes = new ArrayList<>();
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                try {
                    while (true) {
                        allDrawnShapes.add((Shape) in.readObject());
                    }
                }catch(EOFException e){
                    //EOF of file
                }

                in.close();
                fileIn.close();

                System.out.println("Loaded from path: " + file.getAbsoluteFile().toString());
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }

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