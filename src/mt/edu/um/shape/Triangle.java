package mt.edu.um.shape;

import mt.edu.um.ShapeSingleton;

import javax.swing.*;
import java.awt.*;

/**
 * Triangle representation
 */
public class Triangle extends Shape{

    /**
     * call super constructor and create default shape size
     * @param xPos user canvas x coordinate selection
     * @param yPos user canvas y coordinate selection
     */
    public Triangle(int xPos, int yPos) {
        super(xPos, yPos, 3, 3, ShapeSingleton.StrShapeRepresentation.TRIANGLE);

        int width = (int )(Math.random() * 90 + 30); //get random length between 30 and 90
        int height = width;

        setShapeWidth(width);
        setShapeHeight(height);
    }

    /**
     * draw triangle
     * @param g
     */
    public void paint(Graphics g){
        super.paint(g);
//        g.setColor(getShapeColor()); //outline of shape has the same colour now as whole object
        g.drawPolygon(new int[]{xPos, xPos + getShapeWidth(), xPos - getShapeWidth()},
                new int[]{yPos, yPos + getShapeHeight(), yPos + getShapeHeight()},
                3);
        g.setColor(getShapeColor());
        g.fillPolygon(new int[]{xPos, xPos + getShapeWidth(), xPos - getShapeWidth()},
                new int[]{yPos, yPos + getShapeHeight(), yPos + getShapeHeight()},
                3);
    }

    /**
     * Show custom dialog with shape information
     * number of sides, dimensions, how to calculate the area and perimeter, and more.
     */
    public void showInformationDialog(Shape myShape){

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Equilateral triangle");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setBounds(0, 32, 200, 32);
        panel.add(label1);

        JLabel label2 = new JLabel("Number of slides:");
        label2.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label2);

        JLabel label3 = new JLabel(myShape.getNumOfSides()+"");
        label3.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label3);

        JLabel label4 = new JLabel("Dimensions:");
        label4.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label4);

        JLabel label5 = new JLabel(myShape.getShapeWidth()*2 + "x" + myShape.getShapeHeight()*2);
        label5.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label5);

        JLabel label6 = new JLabel("How to calculate area:");
        label6.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label6);

        JLabel label7 = new JLabel("(sqrt(3)/4)*side² = " + (Math.sqrt(3)/4) * (myShape.getShapeHeight() * 2 * myShape.getShapeHeight() * 2));
        label7.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label7);

        JLabel label8 = new JLabel("How to calculate perimeter:");
        label8.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(label8);

        JLabel label9 = new JLabel("3 x side = " + 3 * myShape.getShapeHeight() * 2);
        label9.setFont(new Font("Arial", Font.PLAIN, 12));
        panel.add(label9);

        JLabel label10 = new JLabel("Do you want to change shape size?");
        label10.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(label10);

//        JLabel weightLabel = new JLabel("Shape weight");
//        weightLabel.setFont(new Font("Arial", Font.PLAIN, 15));
//        panel.add(weightLabel);
//        JTextField widthField = new JTextField(String.valueOf(myShape.getShapeWidth()));
//        panel.add(widthField);

        JLabel heightLabel = new JLabel("Shape height");
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(heightLabel);
        JTextField heightField = new JTextField(String.valueOf(myShape.getShapeHeight()));
        panel.add(heightField);

        UIManager.put("OptionPane.minimumSize", new Dimension(300, 120));
        int result = JOptionPane.showConfirmDialog(null, panel, "Shape information!",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null);

        if (result == JOptionPane.OK_OPTION) {

            try{
                int height = Integer.valueOf(heightField.getText());
                int width = height;

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
