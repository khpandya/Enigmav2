package com.enigma.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface IView {
    String getInput();
    ArrayList<Integer> getRotorValues();
    void addEncryptListener(ActionListener listener);
    void displayError(String errorMessage);
    void setRotorPositions(ArrayList<Integer> values);
    void setOutput(String output);
}
