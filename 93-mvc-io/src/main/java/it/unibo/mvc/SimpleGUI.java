package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private static final int PROPORTION = 2;
    private final JFrame myFrame = new JFrame();
    private final JPanel myPanel = new JPanel();
    private final JTextField myField = new JTextField();
    private final JTextArea myArea = new JTextArea();
    private final JButton print = new JButton("Print");
    private final JButton showHistory = new JButton("Show History");
    private final Controller myController;
    /**
     * Simple gui controller constructor.
     * @param controller is the controller to set
     */
    public SimpleGUI(final Controller controller) {
        this.myController = controller;
        myPanel.setLayout(new BorderLayout());
        myFrame.setContentPane(myPanel);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel.add(myField, BorderLayout.NORTH);
        myPanel.add(myArea, BorderLayout.CENTER);
        final JPanel bottonPanel = new JPanel();
        bottonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottonPanel.add(print);
        bottonPanel.add(showHistory);
        myPanel.add(bottonPanel, BorderLayout.SOUTH);
        
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myController.setNextString(myField.getText());
                    myController.printCurrentString();
                } catch (NullPointerException | IllegalStateException ex) {
                    myArea.setText("Error: " + ex.getMessage());
                }
            }
        });
        
        showHistory.addActionListener(e -> 
            myArea.setText(String.join(" ", myController.getHistoryString())));
    }

    /**
     * Display of the frame.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        myFrame.setSize(sw / PROPORTION, sh / PROPORTION);
        myFrame.setLocationByPlatform(true);
        myFrame.setVisible(true);
        myFrame.pack();
    }

    /**
     * Generate a new simple GUI.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
