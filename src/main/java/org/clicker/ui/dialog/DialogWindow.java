package org.clicker.ui.dialog;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Admin on 08.10.2015.
 */
public class DialogWindow extends Stage {
    private VBox box = new VBox();
    private HBox buttons = new HBox();
    private Button addButton = new Button("Ок");
    private Button cancelButton = new Button("Отменить");


    public DialogWindow() {
        init();
    }

    private void init() {
        initModality(Modality.APPLICATION_MODAL);
        initStyle(StageStyle.DECORATED);
        box.setAlignment(Pos.CENTER);

        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().addAll(addButton, cancelButton);

        setWidth(300);
        setHeight(150);

        setScene(new Scene(box));

        addButton.setPrefWidth(100);
        cancelButton.setPrefWidth(100);

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                close();
            }
        });
    }

    public VBox getPanel() {
        return box;
    }

    public HBox getButtons() {
        return buttons;
    }

    public Button getAddButton() {
        return addButton;
    }

}
