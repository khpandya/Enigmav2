package com.enigma.controller;

import com.enigma.model.IModel;
import com.enigma.view.EnigmaView;

public class EnigmaController {
    private IModel enigmaModel;
    private EnigmaView enigmaView;

    public EnigmaController(IModel model, EnigmaView view) {
        this.enigmaModel = model;
        this.enigmaView = view;
    }
}
