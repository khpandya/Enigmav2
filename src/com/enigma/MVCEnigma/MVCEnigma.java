package com.enigma.MVCEnigma;

import com.enigma.controller.EnigmaController;
import com.enigma.model.EnigmaMachine;
import com.enigma.model.IModel;
import com.enigma.view.EnigmaView;

public class MVCEnigma {
    public static void main(String[] args){
        EnigmaView enigmaView = new EnigmaView();
        IModel enigmaModel = new EnigmaMachine();
        EnigmaController enigmaController = new EnigmaController(enigmaModel, enigmaView);
        enigmaView.setSize(600, 1200);
        enigmaView.setVisible(true);
    }
}
