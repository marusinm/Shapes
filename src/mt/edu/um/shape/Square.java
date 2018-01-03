package mt.edu.um.shape;

import mt.edu.um.ShapeSingleton;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Square representation
 */
public class Square extends Shape{

    /**
     * call super constructor and create default shape size
     * @param xPos user canvas x coordinate selection
     * @param yPos user canvas y coordinate selection
     */
    public Square(int xPos, int yPos) {
        super(xPos, yPos, 4,1, ShapeSingleton.StrShapeRepresentation.SQUARE);

        Random rand = new Random();
        int width = rand.nextInt(90) + 30; //get random length between 30 and 90
        int height = width;

        setShapeWidth(width);
        setShapeHeight(height);
    }

    /**
     * draw square
     * @param g
     */
    public void paint(Graphics g){
        super.paint(g);
//        g.setColor(getShapeColor()); //outline of shape has the same colour now as whole object
        g.drawRect(xPos, yPos, getShapeWidth(), getShapeHeight());
        g.setColor(getShapeColor());
        g.fillRect(xPos, yPos, getShapeWidth(), getShapeHeight());

//        Graphics2D g2 = (Graphics2D) g;
//        java.awt.Rectangle rectangle = new java.awt.Rectangle(xPos,yPos,getShapeWidth(),getShapeHeight());
//        g2.setColor(getShapeColor());
//        g2.fill (rectangle);
    }

    /**
     * Show custom dialog with shape information
     */
    public void showCustomDialog(Shape myShape){

        JPanel panel = new JPanel();
//        panel.setBackground(new Color(102, 205, 170));
//        panel.setSize(new Dimension(200, 64));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Title 1.");
//        label1.setVerticalAlignment(SwingConstants.BOTTOM);
//        label1.setBounds(0, 0, 200, 32);
//        label1.setFont(new Font("Arial", Font.BOLD, 10));
//        label1.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(label1);
        JLabel label2 = new JLabel("text 1");
//        label2.setVerticalAlignment(SwingConstants.TOP);
//        label2.setHorizontalAlignment(SwingConstants.LEFT);
//        label2.setFont(new Font("Arial", Font.PLAIN, 10));
//        label2.setBounds(0, 32, 200, 32);
        panel.add(label2);

        JLabel label3 = new JLabel("title 2");
//        label3.setVerticalAlignment(SwingConstants.TOP);
//        label3.setHorizontalAlignment(SwingConstants.LEFT);
//        label3.setFont(new Font("Arial", Font.BOLD, 10));
//        label3.setBounds(0, 32, 200, 32);
        panel.add(label3);
        JLabel label4 = new JLabel("text 2");
//        label4.setVerticalAlignment(SwingConstants.TOP);
//        label4.setHorizontalAlignment(SwingConstants.LEFT);
//        label4.setFont(new Font("Arial", Font.PLAIN, 10));
//        label4.setBounds(0, 32, 200, 32);
        panel.add(label4);

        JTextField widthField = new JTextField();
        JTextField heightField = new JTextField();
        panel.add(widthField);
        panel.add(heightField);

        UIManager.put("OptionPane.minimumSize", new Dimension(300, 120));
        int result = JOptionPane.showConfirmDialog(null, panel, "Admin Rights Confirmation",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.OK_OPTION) {
            System.out.println("resize object to" +
                    widthField.getText() + " x " +
                    heightField.getText());

            try{
                int width = Integer.valueOf(widthField.getText());
                int height = Integer.valueOf(heightField.getText());

                myShape.setShapeWidth(width);
                myShape.setShapeHeight(height);
            }catch (Exception ex){
                JFrame dialog = new JFrame();
                JOptionPane.showMessageDialog(dialog, "Shape width and height must be integer numbers!");
            }

        } else {
            System.out.println("User canceled / closed the dialog, result = " + result);
        }
    }
}
