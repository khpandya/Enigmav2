package com.enigma.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnigmaView extends JFrame implements IView {
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private JButton reset = new JButton("reset");
    private JTextArea inputText = new JTextArea(20,20);
    private JTextArea outputText = new JTextArea(20,20);
    // TODO: can make slider adding dynamic
    private JSlider slider1 = new JSlider();
    private JSlider slider2 = new JSlider();
    private JSlider slider3 = new JSlider();

    public EnigmaView() {
        JPanel mainPanel = new JPanel();
        outputText.setEditable(false);
        JScrollPane inputPane = new JScrollPane(inputText);
        JScrollPane outputPane = new JScrollPane(outputText);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        mainPanel.add(encrypt);
        mainPanel.add(decrypt);
        mainPanel.add(reset);
        mainPanel.add(inputPane);
        mainPanel.add(outputPane);
        mainPanel.add(slider1);
        mainPanel.add(slider2);
        mainPanel.add(slider3);
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

    public void addEncryptListener(ActionListener listener) {
        encrypt.addActionListener(listener);
        decrypt.addActionListener(listener);
    }

    public void addResetListener(ActionListener listener) {
        reset.addActionListener(listener);
    }

    public void displayError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    @Override
    public void setRotorPositions(ArrayList<Integer> values) {

    }

    @Override
    public void setOutput(String output) {
        outputText.setText(output);
    }
}
