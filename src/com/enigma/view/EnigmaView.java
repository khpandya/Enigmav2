package com.enigma.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnigmaView extends JFrame {
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private JTextArea inputText;
    private JTextArea outputText;
    // TODO: can make slider adding and returning dynamic
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;

    private void addElementsToMainPanel(JPanel mainPanel) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        mainPanel.add(encrypt);
        mainPanel.add(decrypt);
        mainPanel.add(inputText);
        mainPanel.add(outputText);
        mainPanel.add(slider1);
        mainPanel.add(slider2);
        mainPanel.add(slider3);
    }

    public EnigmaView() {
        JPanel mainPanel = new JPanel();
        addElementsToMainPanel(mainPanel);
        this.add(mainPanel);
    }

    public String getInput() {
        return inputText.getText();
    }

    public ArrayList<Integer> getRotorValues() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(slider1.getValue());
        values.add(slider2.getValue());
        values.add(slider3.getValue());
        return values;
    }

    void addEncrpytListener(ActionListener listener) {
        encrypt.addActionListener(listener);
        decrypt.addActionListener(listener);
    }

    void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
