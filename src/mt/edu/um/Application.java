package mt.edu.um;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Create GUI, initialize data, declare buttons functions
 */
public class Application extends JFrame {

    ShapeSingleton shapeSingleton = ShapeSingleton.getInstance();
    DrawingCanvas drawingPanel = new DrawingCanvas();

    public static void main(String[] args) {
        Application m = new Application();
        m.setVisible(true);
    }

    /**
     * Initialize UI in main constructor
     */
    public Application() {
        setTitle("Shapes");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(getMenu());
        setLayout(new BorderLayout());

        add(drawingPanel,BorderLayout.CENTER);
        add(getPalettePanel(),BorderLayout.WEST);
    }

    /**
     * Create left side menu
     * @return JPanel
     */
    private JPanel getPalettePanel(){
        JPanel p = new JPanel();
        p.setBackground(Color.darkGray);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
//        p.setLayout(new GridLayout(4,0));

        Dimension dimension = new Dimension(150,30);

        JButton squareButton = new JButton("SQUARE");
        squareButton.setPreferredSize(dimension);
        squareButton.setMinimumSize(dimension);
        squareButton.setMaximumSize(dimension);
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeSingleton.setCurrentShape(ShapeSingleton.StrShapeRepresentation.SQUARE);
            }
        });

        JButton rectangleButton = new JButton("RECTANGLE");
        rectangleButton.setPreferredSize(dimension);
        rectangleButton.setMinimumSize(dimension);
        rectangleButton.setMaximumSize(dimension);
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeSingleton.setCurrentShape(ShapeSingleton.StrShapeRepresentation.RECTANGLE);
            }
        });

        JButton circleButton = new JButton("CIRCLE");
        circleButton.setPreferredSize(dimension);
        circleButton.setMinimumSize(dimension);
        circleButton.setMaximumSize(dimension);
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeSingleton.setCurrentShape(ShapeSingleton.StrShapeRepresentation.CIRCLE);
            }
        });

        JButton triangleButton = new JButton("TRIANGLE");
        triangleButton.setPreferredSize(dimension);
        triangleButton.setMinimumSize(dimension);
        triangleButton.setMaximumSize(dimension);
        triangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeSingleton.setCurrentShape(ShapeSingleton.StrShapeRepresentation.TRIANGLE);
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(dimension);
        clearButton.setMinimumSize(dimension);
        clearButton.setMaximumSize(dimension);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog (Application.this, "Would you like to really perform this action?","Warning", JOptionPane.OK_CANCEL_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    shapeSingleton.removeAllShapes();
                    drawingPanel.repaint();
                }
            }
        });

        p.add(squareButton);
        p.add(rectangleButton);
        p.add(circleButton);
        p.add(triangleButton);

        p.add(clearButton);

        return p;
    }


    /**
     * Create buttons and their functionalities for JMenuBar
     * @return JMenuBar
     */
    private JMenuBar getMenu() {
        JMenuBar menuBar = new JMenuBar();

        JButton buttonNew = new JButton("New");
        buttonNew.setOpaque(true);
        buttonNew.setContentAreaFilled(false);
        buttonNew.setBorderPainted(false);
        buttonNew.setFocusable(false);
        buttonNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int dialogResult = JOptionPane.showConfirmDialog (Application.this, "New canvas will delete current one?","Warning", JOptionPane.OK_CANCEL_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    shapeSingleton.removeAllShapes();
                    drawingPanel.repaint();
                }
            }
        });

        JButton buttonSave = new JButton("Save");
        buttonSave.setOpaque(true);
        buttonSave.setContentAreaFilled(false);
        buttonSave.setBorderPainted(false);
        buttonSave.setFocusable(false);
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                shapeSingleton.serializeAllShapes(Application.this);
            }
        });

        JButton buttonOpen = new JButton("Open");
        buttonOpen.setOpaque(true);
        buttonOpen.setContentAreaFilled(false);
        buttonOpen.setBorderPainted(false);
        buttonOpen.setFocusable(false);
        buttonOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                shapeSingleton.deserializeAllShapes(Application.this);
                drawingPanel.repaint();
                JOptionPane.showMessageDialog(Application.this, "Game will be loaded!");
            }
        });


        menuBar.add(buttonNew);
        menuBar.add(buttonOpen);
        menuBar.add(buttonSave);

        return menuBar;
    }

}
