package com.amalfi.rdaevo.view;

import com.amalfi.rdaevo.model.Utenze;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class UtenzaPopup  extends VerticalLayout {

        public UtenzaPopup(List<Utenze> utenze) {
            ComboBox<Utenze> combo = new ComboBox<>("Tipologia Utenza Login");
            combo.setItems(utenze);
            combo.setAllowCustomValue(true);
            add(combo);

        }
}
