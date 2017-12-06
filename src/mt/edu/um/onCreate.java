package mt.edu.um;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class onCreate extends JFrame {

    private DrawingPanel drawingPanel = new DrawingPanel();
    private JButton circleButton = new JButton("CIRCLE");
    private JButton rectangleButton = new JButton("RECTANGLE");

    public static void main(String[] args) {
        onCreate m = new onCreate();
        m.setVisible(true);
    }

    public onCreate() {
        setTitle("Shapes");
        setSize(500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMainMenuBar());
        setLayout(new BorderLayout());
        add(drawingPanel,BorderLayout.CENTER);
        add(getPalettePanel(),BorderLayout.WEST);
        
//        drawingPanel.addShape(new Rectangle(5, 5));
//        drawingPanel.addShape(new Rectangle(50, 200));
//        drawingPanel.addShape(new Circle(200, 200));
    }
    
    private JPanel getPalettePanel(){
        JPanel p = new JPanel();
        p.setBackground(Color.darkGray);
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        p.add(circleButton);
        p.add(rectangleButton);
        return p;
    }


    protected JMenuBar createMainMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JButton buttonNewGame= new JButton("New Game");
        buttonNewGame.setOpaque(true);
        buttonNewGame.setContentAreaFilled(false);
        buttonNewGame.setBorderPainted(false);
        buttonNewGame.setFocusable(false);
        buttonNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //TODO: write code here
            }
        });

        JButton buttonLoad= new JButton("Load Game");
        buttonLoad.setOpaque(true);
        buttonLoad.setContentAreaFilled(false);
        buttonLoad.setBorderPainted(false);
        buttonLoad.setFocusable(false);
        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                //TODO: write code here
            }
        });


        menuBar.add(buttonNewGame);
        menuBar.add(buttonLoad);
        return menuBar;
    }

}
