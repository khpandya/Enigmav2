package com.enigma.view;

import com.google.common.collect.BiMap;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnigmaView extends JFrame implements IView {
    JPanel mainPanel = new JPanel();
    private JComboBox reflectors = new JComboBox(new String[]{"Reflector A", "Reflector B", "Reflector C"});
    private JComboBox rotor1 = new JComboBox(new String[]{"Rotor A", "Rotor B", "Rotor C"});
    private JComboBox rotor2 = new JComboBox(new String[]{"Rotor A", "Rotor B", "Rotor C"});
    private JComboBox rotor3 = new JComboBox(new String[]{"Rotor A", "Rotor B", "Rotor C"});
    private JButton encrypt = new JButton("encrypt");
    private JButton decrypt = new JButton("decrypt");
    private JButton connect = new JButton("connect");
    private JButton delete = new JButton("delete");
    private JTextField letterOne = new JTextField(1);
    private JTextField letterTwo = new JTextField(1);
    private JTextField letterToDelete = new JTextField(1);
    private JButton reset = new JButton("reset");
    private JTextArea inputText = new JTextArea(20,20);
    private JTextArea outputText = new JTextArea(20,20);
    private ArrayList<JSlider> sliders = new ArrayList<>();
    private JTable plugboard = new JTable(26, 2);

    public void resetRotorsAndReflector() {
        reflectors.setSelectedItem("Reflector A");
        rotor1.setSelectedItem("Rotor A");
        rotor2.setSelectedItem("Rotor B");
        rotor3.setSelectedItem("Rotor C");
    }

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
        plugboard.setDefaultEditor(Object.class, null);
    }

    public EnigmaView() {
        outputText.setEditable(false);
        JScrollPane inputPane = new JScrollPane(inputText);
        JScrollPane outputPane = new JScrollPane(outputText);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 1200);
        resetRotorsAndReflector();
        mainPanel.add(reflectors);
        mainPanel.add(rotor1);
        mainPanel.add(rotor2);
        mainPanel.add(rotor3);
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
        mainPanel.add(delete);
        mainPanel.add(letterToDelete);
        this.add(mainPanel);
    }

    public String getInput() {
        return inputText.getText();
    }

    public String getReflector() {
        return (String) reflectors.getSelectedItem();
    }

    public String getRotor1() {
        return (String) rotor1.getSelectedItem();
    }

    public String getRotor2() {
        return (String) rotor2.getSelectedItem();
    }
    public String getRotor3() {
        return (String) rotor3.getSelectedItem();
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

    public void addConnectListener(ActionListener listener) {
        connect.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        delete.addActionListener(listener);
    }

    public String getLetterToDelete() {
        return letterToDelete.getText();
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

    public void resetRotorPositions() {
        for (int i = 0; i < sliders.size(); i++) {
            sliders.get(i).setValue(1);
        }
    }
}
