package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    private final Controller myController = new Controller();
    private final JPanel myPanel = new JPanel();
    private final JButton bottonSave = new JButton("Save");
    private final JTextArea myArea = new JTextArea();

    /**
     * Set the GUI of the programm.
     */
    @SuppressWarnings("Convert2Lambda")
    public SimpleGUI() {
        myPanel.setLayout(new BorderLayout());
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel.add(myArea, BorderLayout.CENTER);
        myPanel.add(bottonSave, BorderLayout.SOUTH);

        bottonSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    myController.newContent(myArea.getText());
                } catch (final IOException e1) {
                    JOptionPane.showMessageDialog(frame, "Errore nella scrittura:" + e1.getMessage());
                }
            }
        });
    }

    /**
     * Set the display of the GUI.
     */
    public final void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.pack();
    }

    /**
     * @return frame's controller setted
     */
    protected Controller getMyController() {
        return myController;
    }

    /**
     * @return frame's panel
     */
    protected JPanel getMyPanel() {
        return myPanel;
    }
    
    /**
     * @param args of the main
     */
    public static void main(final String[] args) {
        final SimpleGUIWithFileChooser myGui = new SimpleGUIWithFileChooser();
        myGui.display();
    }
}
