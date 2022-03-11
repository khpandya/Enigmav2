package com.enigma.implementor;

import com.enigma.controller.EnigmaController;
import com.enigma.model.EnigmaMachine;
import com.enigma.model.IModel;
import com.enigma.view.EnigmaView;

public class Implementor {
    IModel model = new EnigmaMachine();
    EnigmaView view = new EnigmaView();
    EnigmaController controller = new EnigmaController(model, view);
    // TODO controller.view.turnVisible(true)
}
