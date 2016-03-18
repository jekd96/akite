package org.clicker.ui.element;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by Admin on 02.10.2015.
 */
public class AutoFillTextBox extends np.com.ngopal.control.AutoFillTextBox {

    private ObservableList data;

    public AutoFillTextBox(ObservableList data) {
        super(data);
        init();
    }

    public AutoFillTextBox() {
        super();
        init();
    }

    private void init() {
        setListLimit(10);
        setFilterMode(false);
        data = getData();
        getTextbox().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                getListview().setItems(data);
            }
        });

        setMaxWidth(1.7976931348623157E308);
        setMinWidth(10);

        setPrefWidth(130);
        setPrefHeight(25);
    }

    public void setPromptText(String value) {
        getTextbox().setPromptText(value);
    }

}
