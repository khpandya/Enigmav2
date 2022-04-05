package com.enigma.view;

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
}
