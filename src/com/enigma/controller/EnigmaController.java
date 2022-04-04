package com.enigma.controller;

import com.enigma.model.IModel;
import com.enigma.view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnigmaController {
    private IModel enigmaModel;
    private IView enigmaView;

    public EnigmaController(IModel model, IView view) {
        this.enigmaModel = model;
        this.enigmaView = view;
        enigmaView.addEncryptListener(new EncryptionListener());
    }

    class EncryptionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = enigmaView.getInput();
            try {
                String output = enigmaModel.getEncryptedMessage(input);
                enigmaView.setOutput(output);
            }
            catch (Exception ex) {
                System.out.println(ex);
                enigmaView.displayError("encryption error");
            }
        }
    }
}
