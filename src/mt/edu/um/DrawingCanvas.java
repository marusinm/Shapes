package mt.edu.um;

import mt.edu.um.shape.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class DrawingCanvas extends JPanel implements MouseListener, MouseMotionListener{

    ShapeSingleton shapeSingleton = ShapeSingleton.getInstance();
    
    public DrawingCanvas(){
        addMouseListener(this);
    }

    public void paint(Graphics g){
        super.paint(g);
        for(int i = 0;i < shapeSingleton.getAllShapes().size();i++){
            shapeSingleton.getAllShapes().get(i).paint(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
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
