package com.enigma.view;

import com.google.common.collect.BiMap;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IView {
    String getInput();
    ArrayList<Integer> getRotorValues();
    void setRotorPositions(ArrayList<Integer> values);
    void resetRotors();
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
    void updatePlugboard(BiMap<Character, Character> mapping);
}
