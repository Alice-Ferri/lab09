package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI {
    /**
     * Simple GUI whit a file chooser.
     */
    @SuppressWarnings("Convert2Lambda")
    public SimpleGUIWithFileChooser() {
        final JPanel mySecondPanel = new JPanel();
        mySecondPanel.setLayout(new BorderLayout());
        final JButton bottonBrowser = new JButton("Browse...");
        final JTextField myField = new JTextField(getMyController().getPath());
        myField.setEditable(false);
        mySecondPanel.add(myField, BorderLayout.CENTER);
        mySecondPanel.add(bottonBrowser, BorderLayout.LINE_END);
        getMyPanel().add(mySecondPanel, BorderLayout.NORTH);

        bottonBrowser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(myField) == JFileChooser.APPROVE_OPTION) {
                    getMyController().setFile(fileChooser.getSelectedFile());
                    myField.setText(getMyController().getPath());
                    JOptionPane.showMessageDialog(fileChooser, "New file selected");
                } else if (fileChooser.showSaveDialog(myField) == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(fileChooser, "Please select a file");
                }
            }
        });
    }
}
