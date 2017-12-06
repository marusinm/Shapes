package mt.edu.um;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseListener{
    
    private ArrayList<Shape> myShapes = new ArrayList<>();
    
    public DrawingPanel(){
        addMouseListener(this);
    }
    
    public void addShape(Shape s){
        myShapes.add(s);
        repaint();
    }
    
    public void paint(Graphics g){
        super.paint(g);
        for(int i = 0;i < myShapes.size();i++){
            myShapes.get(i).paint(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == 1){
            // Draw a circle
            myShapes.add(new Circle(e.getX(),e.getY()));
        }else{
            // Draw a rectangle
            myShapes.add(new Rectangle(e.getX(),e.getY()));
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
}
