package com.enigma.view;

import com.google.common.collect.BiMap;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IView {
    String getInput();
    ArrayList<Integer> getRotorValues();
    void setRotorPositions(ArrayList<Integer> values);
    void resetRotorPositions();
    void addEncryptListener(ActionListener listener);
    void displayError(String errorMessage);
    void setOutput(String output);
    void addResetListener(ActionListener listener);
    void resetPlugboard();
    String getLetterOne();
    String getLetterTwo();
    void addConnectListener(ActionListener listener);
    void addDeleteListener(ActionListener listener);
    String getLetterToDelete();
    String getReflector();
    String getRotor1();
    String getRotor2();
    String getRotor3();
    void updatePlugboard(BiMap<Character, Character> mapping);
    void resetRotorsAndReflector();
}
