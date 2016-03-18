package org.clicker.ui.controller.tab;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.clicker.domain.Group;
import org.clicker.domain.Student;
import org.clicker.service.GroupService;
import org.clicker.service.StudentService;
import org.clicker.ui.dialog.DialogWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Admin on 29.01.2016.
 */
@Component
public class StudentsController {

    @Autowired
    StudentService studentService;

    @Autowired
    GroupService groupService;

    @FXML
    TableView<Student> studentsTable;

    @FXML
    public void initialize() {
        initElement();
        initData();
        initMenu();
    }

    private void initData() {
        studentsTable.setItems(FXCollections.observableArrayList(studentService.getAll()));
    }

    private DialogWindow createDialog(String title,TextField nameField, TextField surnameField,
                                      DatePicker yearRevenuePicker, DatePicker yearBirthPicker, ComboBox<Group> groupComboBox) {


        DialogWindow dialogWindow = new DialogWindow();
        dialogWindow.setTitle(title);
        dialogWindow.setHeight(400);

        nameField.setPromptText("Имя Студента");
        surnameField.setPromptText("Фамилия Студента");

        yearRevenuePicker.setValue(LocalDate.now());
        yearBirthPicker.setValue(LocalDate.now());
        groupComboBox.setItems(FXCollections.observableArrayList(groupService.getAll()));
        groupComboBox.getSelectionModel().selectFirst();

        groupComboBox.setCellFactory(new Callback<ListView<Group>, ListCell<Group>>() {
            @Override
            public ListCell<Group> call(ListView<Group> param) {

                return new ListCell<Group>(){
                    @Override
                    public void updateItem(Group item, boolean empty){
                        super.updateItem(item, empty);
                        if(!empty) {
                            setText(item.getName());
                            setGraphic(null);
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });

        dialogWindow.getPanel().getChildren().addAll(new Label("Имя Студента"), nameField);
        dialogWindow.getPanel().getChildren().addAll(new Label("Фамилия Студента"), surnameField);
        dialogWindow.getPanel().getChildren().addAll(new Label("Дата поступления"), yearRevenuePicker);
        dialogWindow.getPanel().getChildren().addAll(new Label("Дата Рождения"), yearBirthPicker);
        dialogWindow.getPanel().getChildren().addAll(new Label("Группа"), groupComboBox);

        dialogWindow.getPanel().getChildren().add(dialogWindow.getButtons());


        return dialogWindow;
    }

    private void initElement() {
        TableColumn nameColumn = new TableColumn("Имя");
        nameColumn.setPrefWidth(181.0);
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Group, String>("name"));
        studentsTable.getColumns().add(nameColumn);

        TableColumn surnameColumn = new TableColumn("Фамилия");
        surnameColumn.setPrefWidth(181.0);
        surnameColumn.setCellValueFactory(
                new PropertyValueFactory<Group, String>("surname"));
        studentsTable.getColumns().add(surnameColumn);

        TableColumn yearRevenueColumn = new TableColumn("Дата поступления");
        yearRevenueColumn.setPrefWidth(181.0);
        yearRevenueColumn.setCellValueFactory(
                new PropertyValueFactory<Group, String>("yearRevenue"));
        studentsTable.getColumns().add(yearRevenueColumn);

        TableColumn yearBirthColumn = new TableColumn("Дата рождения");
        yearBirthColumn.setPrefWidth(181.0);
        yearBirthColumn.setCellValueFactory(
                new PropertyValueFactory<Group, String>("yearBirth"));
        studentsTable.getColumns().add(yearBirthColumn);

        TableColumn<Student, String> nameGroupColumn = new TableColumn<>("Группа");
        nameGroupColumn.setPrefWidth(100);
        nameGroupColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Student, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Student, String> param) {
                return new SimpleStringProperty(param.getValue().getGroup().getName());
            }
        });
        studentsTable.getColumns().add(nameGroupColumn);

    }

    @FXML
    public void onAdd() {
        TextField nameField = new TextField();
        TextField surnameField = new TextField();
        DatePicker yearRevenuePicker = new DatePicker();
        DatePicker yearBirthPicker = new DatePicker();
        ComboBox<Group> groupComboBox = new ComboBox<>();

        DialogWindow window = createDialog("Добавить", nameField,surnameField,yearRevenuePicker,yearBirthPicker, groupComboBox);


        window.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Student student = new Student();
                student.setName(nameField.getText());
                student.setSurname(surnameField.getText());
                student.setYearRevenue(Date.from(yearRevenuePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                student.setYearBirth(Date.from(yearBirthPicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                student.setGroup(groupComboBox.getValue());
                studentService.add(student);
                studentsTable.getItems().add(student);
                window.close();
            }
        });

        window.show();

    }


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
              //  onEdit();
            }
        });
        contextMenu.getItems().add(edit);

        MenuItem delete = new MenuItem("Удалить");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              //  onDelete();
            }
        });
        contextMenu.getItems().add(delete);


        Menu reports = new Menu("Отчеты");
        MenuItem reportEcruitmentOffice = new MenuItem("Справка военкомату");
        reports.getItems().add(reportEcruitmentOffice);

        contextMenu.getItems().add(reports);

        studentsTable.setContextMenu(contextMenu);
    }
}
