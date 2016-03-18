package org.clicker.ui.controller.tab;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.clicker.domain.Group;
import org.clicker.service.GroupService;
import org.clicker.ui.dialog.DialogWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 07.10.2015.
 */
@Component
public class GroupsController {

    @Autowired
    GroupService service;
    @FXML
    TableView<Group> groupsTable;


    @FXML
    public void initialize() {
        initElement();
        initData();
    }
    /*
    public void onImport() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть файл");
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            try {
                List<String> elements  = csvParser.parse(file.getAbsolutePath());
                List<Donors> donorsList = new ArrayList<>();
                for(String element : elements) {
                    Donors donors = new Donors();
                    donors.setLink(element);
                    donors.setAddDate(new Date());
                    donorsList.add(donors);
                    donorsTable.getItems().add(donors);
                    //service.add(donors);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } */


    public void onAdd() {

        TextField nameGroupTextField = new TextField();
        DialogWindow window = createAddDialog("", "Добавить", nameGroupTextField);

        window.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Group group = new Group();
                group.setName(nameGroupTextField.getText());
                groupsTable.getItems().add(group);
                service.add(group);
                window.close();
            }
        });
        window.show();
    }
    /*
    public void onEdit() {
        Donors donors =  donorsTable.getSelectionModel().getSelectedItem();

        if (donors != null) {
            TextField linkTextField = new TextField();
            DialogWindow window = createAddDialog("", "Редактировать", linkTextField);

            linkTextField.setText(donors.getLink());

            window.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    donors.setLink(linkTextField.getText());
                    donors.setAddDate(new Date());
                    donorsTable.getItems().set(donorsTable.getSelectionModel().getSelectedIndex(), donors);
                    //service.add(donors);
                    window.close();
                }
            });
            window.show();
        }
    }

    public void onDelete() {
        Donors donors =  donorsTable.getSelectionModel().getSelectedItem();
        if(donors != null) {
            DialogWindow dialogWindow = new DialogWindow();
            dialogWindow.setTitle("Удаление");
            dialogWindow.getPanel().getChildren().addAll(new Label("Удалить ?"), dialogWindow.getButtons());
            dialogWindow.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    donorsTable.getItems().remove(donors);
                    //service.delete(donors);
                    dialogWindow.close();
                }
            });

            dialogWindow.show();
        }
    } */

    private DialogWindow createAddDialog(String value, String titleWindow, TextField textField) {
        DialogWindow dialogWindow = new DialogWindow();
        dialogWindow.setTitle(titleWindow);
        textField.setText(value);
        textField.setPromptText("Ссылка");
        dialogWindow.getPanel().getChildren().addAll(textField, dialogWindow.getButtons());
        return dialogWindow;
    }



    private void initData() {
        groupsTable.setItems(FXCollections.observableArrayList(service.getAll()));
    }

    private void initElement() {
        TableColumn nameGroup = new TableColumn("Группа");
        nameGroup.setPrefWidth(181.0);
        nameGroup.setCellValueFactory(
                new PropertyValueFactory<Group, String>("name"));

        groupsTable.getColumns().add(nameGroup);
    }
    /*
    private void initMenu() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem add = new MenuItem("Добавить");
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAdd();
            }
        });
        contextMenu.getItems().add(add);

        MenuItem edit = new MenuItem("Редактировать");
        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onEdit();
            }
        });
        contextMenu.getItems().add(edit);

        MenuItem delete = new MenuItem("Удалить");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onDelete();
            }
        });
        contextMenu.getItems().add(delete);
        donorsTable.setContextMenu(contextMenu);
    } */
}
