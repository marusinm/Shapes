package mt.edu.um;

import mt.edu.um.shape.*;
import mt.edu.um.shape.Rectangle;
import mt.edu.um.shape.Shape;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Canvas representation, all shapes are drawn here.
 */
public class DrawingCanvas extends JPanel implements MouseListener, MouseMotionListener{

    ShapeSingleton shapeSingleton = ShapeSingleton.getInstance();
    boolean wasDoubleClick;
    Timer timer;
    
    public DrawingCanvas(){
        addMouseListener(this);
    }

    public void paint(Graphics g){
        super.paint(g);
        for(int i = 0;i < shapeSingleton.getAllShapes().size();i++){
            shapeSingleton.getAllShapes().get(i).paint(g);
        }
    }


    /**
     * TODO okomentovat
     * @param x
     * @param y
     * @return
     */
    public Shape clickedShape(int x, int y){
        for (int i = shapeSingleton.getAllShapes().size()-1; i >= 0; i--) {

            Shape myShape = shapeSingleton.getAllShapes().get(i);

            int xPos = myShape.getxPos();
            int yPos = myShape.getyPos();
            int width = myShape.getShapeWidth();
            int heith = myShape.getShapeHeight();

            java.awt.Shape awtShape = null;
            if (myShape instanceof Square) {
                awtShape = new java.awt.Rectangle(xPos, yPos, width, heith);
            } else if (myShape instanceof Rectangle) {
                awtShape = new java.awt.Rectangle(xPos, yPos, width, heith);
            } else if (myShape instanceof Circle) {
                awtShape = new java.awt.geom.Ellipse2D.Double(xPos, yPos, width, heith);
            } else if (myShape instanceof Triangle) {
                awtShape = new java.awt.Polygon(new int[]{xPos, xPos + width, xPos - width},
                        new int[]{yPos, yPos + heith, yPos + heith},
                        3);
            }

            if (awtShape.contains(new Point(x, y))) {//check if mouse is clicked within shape
//                if (myShape instanceof Square) {
//                    System.out.println("Clicked a Square");
//                } else if (myShape instanceof Rectangle) {
//                    System.out.println("Clicked a Rectangle");
//                } else if (myShape instanceof Circle) {
//                    System.out.println("Clicked a Circle");
//                } else if (myShape instanceof Triangle) {
//                    System.out.println("Clicked a Triangle");
//                }
                return myShape;
            }
        }

        return null;
    }

    /**
     * double click function show information dialog with resizable option
     * @param e click event
     */
    public void doubleClick(MouseEvent e){
        Shape myShape = clickedShape(e.getX(), e.getY());
        if (myShape != null){

//            JTextField widthField = new JTextField();
//            JTextField heightField = new JTextField();
//            final JComponent[] inputs = new JComponent[] {
//                    new JLabel("Width"),
//                    widthField,
//                    new JLabel("Height"),
//                    heightField
//            };
//            int result = JOptionPane.showConfirmDialog(null, inputs, "Shape info!", JOptionPane.PLAIN_MESSAGE);
//            if (result == JOptionPane.OK_OPTION) {
//                System.out.println("resize object to" +
//                        widthField.getText() + " x " +
//                        heightField.getText());
//
//                try{
//                    int width = Integer.valueOf(widthField.getText());
//                    int height = Integer.valueOf(heightField.getText());
//
//                    myShape.setShapeWidth(width);
//                    myShape.setShapeHeight(height);
//                    repaint();
//                }catch (Exception ex){
//                    JFrame dialog = new JFrame();
//                    JOptionPane.showMessageDialog(dialog, "Shape width and height must be integer numbers!");
//                }
//
//            } else {
//                System.out.println("User canceled / closed the dialog, result = " + result);
//            }

            if (myShape instanceof Square){
                ((Square) myShape).showCustomDialog(myShape);
            }
            repaint(); //in case that user changed shape attributes in custom dialog
        }
    }

    /**
     * single click function draws shape on canvas
     * @param e click event
     */
    public void singleClick(MouseEvent e){
        if (shapeSingleton.getCurrentShape() != null){
            if (shapeSingleton.getCurrentShape() == ShapeSingleton.StrShapeRepresentation.SQUARE) {
                shapeSingleton.addShape(new Square(e.getX(), e.getY()));
            }else if (shapeSingleton.getCurrentShape() == ShapeSingleton.StrShapeRepresentation.RECTANGLE) {
                shapeSingleton.addShape(new Rectangle(e.getX(), e.getY()));
            }else if (shapeSingleton.getCurrentShape() == ShapeSingleton.StrShapeRepresentation.CIRCLE) {
                shapeSingleton.addShape(new Circle(e.getX(), e.getY()));
            }else if (shapeSingleton.getCurrentShape() == ShapeSingleton.StrShapeRepresentation.TRIANGLE) {
                shapeSingleton.addShape(new Triangle(e.getX(), e.getY()));
            }

        }else{
            JFrame dialog = new JFrame();
            JOptionPane.showMessageDialog(dialog, "Select shape!");
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println( "Click at (" + e.getX() + ":" + e.getY() + ")" );
        if (e.getClickCount() == 2) {
            //double click
            doubleClick(e);
            wasDoubleClick = true;
        }else {
            timer = new Timer(200, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if (wasDoubleClick) {
                        wasDoubleClick = false; // reset flag
                    } else {
                        //single click
                        singleClick(e);
                    }
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
