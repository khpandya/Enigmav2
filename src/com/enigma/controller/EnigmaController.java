package com.enigma.controller;

import com.enigma.model.IModel;
import com.enigma.view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnigmaController {
    private IModel enigmaModel;
    private IView enigmaView;

    public EnigmaController(IModel model, IView view) {
        this.enigmaModel = model;
        this.enigmaView = view;
        enigmaView.addEncryptListener(new EncryptionListener());
        enigmaView.addResetListener(new ResetListener());
    }

    class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            enigmaModel.resetToDefaultSettings();
            enigmaView.setOutput("");
            enigmaView.resetRotors();
        }
    }

    class EncryptionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = enigmaView.getInput();
            ArrayList<Integer> rotorPositions = enigmaView.getRotorValues();
            try {
                for(int i = 0; i < rotorPositions.size(); i++) {
                    enigmaModel.changeRotorPosition(i, rotorPositions.get(i));
                }
                String output = enigmaModel.getEncryptedMessage(input);
                enigmaView.setOutput(output);
                enigmaView.setRotorPositions(enigmaModel.getRotorPositions());
            }
            catch (Exception ex) {
                System.out.println(ex);
                enigmaView.displayError("encryption error");
            }
        }
    }
}
