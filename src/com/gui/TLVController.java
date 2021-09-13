package com.gui;


import com.entities.utils.Archive;
import com.gui.utils.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class TLVController {

    @FXML
    Button updateBtn;

    @FXML
    Button loadBtn;

    @FXML
    TextArea taskList;


    public void onBtnUpdateClick(){
        Archive.Write2("task-list.txt", taskList.getText());
        Alerts.showAlert(null, null, "Lista atualizada com sucesso!", Alert.AlertType.CONFIRMATION);
    }

    public void onBtnLoadClick(){
        String text = Archive.Read("task-list.txt");

        this.taskList.setText(text);
    }



}
