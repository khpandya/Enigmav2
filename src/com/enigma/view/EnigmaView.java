package com.enigma.view;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnigmaView extends JFrame implements IView {
    JPanel mainPanel = new JPanel();
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private JButton reset = new JButton("reset");
    private JTextArea inputText = new JTextArea(20,20);
    private JTextArea outputText = new JTextArea(20,20);
    private ArrayList<JSlider> sliders = new ArrayList<>();


    private void initializeSliders() {
        for(int i = 0; i < 3; i++) {
            JSlider slider = new JSlider(JSlider.VERTICAL,1, 26, 1);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.setLabelTable(slider.createStandardLabels(1));
            slider.setMajorTickSpacing(5);
            sliders.add(slider);
            mainPanel.add(slider);
        }
    }

    public EnigmaView() {
        outputText.setEditable(false);
        JScrollPane inputPane = new JScrollPane(inputText);
        JScrollPane outputPane = new JScrollPane(outputText);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1200);
        mainPanel.add(encrypt);
        mainPanel.add(decrypt);
        mainPanel.add(reset);
        mainPanel.add(inputPane);
        mainPanel.add(outputPane);
        initializeSliders();
        this.add(mainPanel);
    }

    public String getInput() {
        return inputText.getText();
    }

    public ArrayList<Integer> getRotorValues() {
        ArrayList<Integer> values = new ArrayList<>();
        for(int i = 0; i < sliders.size(); i++){
            values.add(sliders.get(i).getValue());
        }
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
        for (int i = 0; i < values.size(); i++) {
            sliders.get(i).setValue(values.get(i));
        }
    }

    @Override
    public void setOutput(String output) {
        outputText.setText(output);
    }

    public void resetRotors() {
        for (int i = 0; i < sliders.size(); i++) {
            sliders.get(i).setValue(1);
        }
    }
}
