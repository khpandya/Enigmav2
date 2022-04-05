package com.enigma.view;

import com.google.common.collect.BiMap;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnigmaView extends JFrame implements IView {
    // TODO make table uneditable
    // only one row selectable
    // add delete listener
    JPanel mainPanel = new JPanel();
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private JButton connect = new JButton("connect");
    private JTextField letterOne = new JTextField(1);
    private JTextField letterTwo = new JTextField(1);
    private JButton reset = new JButton("reset");
    private JTextArea inputText = new JTextArea(20,20);
    private JTextArea outputText = new JTextArea(20,20);
    private ArrayList<JSlider> sliders = new ArrayList<>();
    private JTable plugboard = new JTable(26, 2);

    private void initializeSliders() {
        for(int i = 0; i < 3; i++) {
            JSlider slider = new JSlider(JSlider.VERTICAL,1, 26, 1);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.setLabelTable(slider.createStandardLabels(1));
            slider.setMajorTickSpacing(1);
            slider.setSnapToTicks(true);
            sliders.add(slider);
            mainPanel.add(slider);
        }
    }

    public void resetPlugboard() {
        int counter = 0;
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            plugboard.setValueAt(ch, counter, 0);
            plugboard.setValueAt(ch, counter, 1);
            counter += 1;
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
        resetPlugboard();
        mainPanel.add(plugboard);
        mainPanel.add(connect);
        mainPanel.add(letterOne);
        mainPanel.add(letterTwo);
        this.add(mainPanel);
    }

    public String getInput() {
        return inputText.getText();
    }

    public String getLetterOne() {
        return letterOne.getText();
    }

    public String getLetterTwo(){
        return letterTwo.getText();
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

    public void addConnectListener(ActionListener listener){
        connect.addActionListener(listener);
    }

    @Override
    public void updatePlugboard(BiMap<Character, Character> mapping) {
        int counter = 0;
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            plugboard.setValueAt(ch, counter, 0);
            plugboard.setValueAt(mapping.get(ch), counter, 1);
            counter += 1;
        }
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
