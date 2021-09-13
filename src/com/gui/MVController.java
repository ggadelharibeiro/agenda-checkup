package com.gui;


import com.entities.utils.Archive;
import com.entities.utils.DateFormat;
import com.gui.utils.Alerts;
/*
import com.utils.Read;
import com.utils.Write;
*/

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MVController {


    Alerts alert = new Alerts();
    DateFormat d = new DateFormat();



    //CONTROLLERS FXML
    @FXML
    private Button saveBtn;

    @FXML
    private Button loadBtn;

    @FXML
    private Button detailBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private Button taskListBtn;

    @FXML
    private DatePicker date_selection;

    @FXML
    private TextField form1_name;

    @FXML
    private TextField form2_name;

    @FXML
    private TextField form3_name;

    @FXML
    private TextField form4_name;

    @FXML
    private TextField form1_patology;

    @FXML
    private TextField  form2_patology;

    @FXML
    private TextField form3_patology;

    @FXML
    private TextField form4_patology;

    @FXML
    private TextField form1_birth;

    @FXML
    private TextField form2_birth;

    @FXML
    private TextField form3_birth;

    @FXML
    private TextField form4_birth;

    @FXML
    private RadioButton form1_radio_discount;

    @FXML
    private RadioButton form2_radio_discount;

    @FXML
    private RadioButton form3_radio_discount;

    @FXML
    private RadioButton form4_radio_discount;

    @FXML
    private RadioButton form1_radio_check;

    @FXML
    private RadioButton form2_radio_check;

    @FXML
    private RadioButton form3_radio_check;

    @FXML
    private RadioButton form4_radio_check;

    @FXML
    private RadioButton form1_radio_cd;

    @FXML
    private RadioButton form2_radio_cd;

    @FXML
    private RadioButton form3_radio_cd;

    @FXML
    private RadioButton form4_radio_cd;



    @FXML
    private Label daily_gains;

    //Button SAVE
    public void onBtSaveClick(){
        String date = date_selection.getValue().toString();
        //Data formatada (dd-mm-yyyy)
        String f_date = d.formatDate(date);

        String d1 = "no", d2 = "no", d3 = "no", d4 = "no";
        String p1 = "no", p2 = "no", p3 = "no", p4 = "no";
        String cd1 = "no", cd2 = "no", cd3 = "no", cd4 = "no";

        //DISCOUNT AND PAYMENT 1
        if(form1_radio_check.isSelected() == false){
            p1 = "no";
        }else{p1 = "yes";}

        if(form1_radio_discount.isSelected() == false){
            d1 = "no";
        }else{d1 = "yes";}



        //DISCOUNT AND PAYMENT 2
        if(form2_radio_check.isSelected() == false){
            p2 = "no";
        }else{p2 = "yes";}

        if(form2_radio_discount.isSelected() == false){
            d2 = "no";
        }else{d2 = "yes";}



        //DISCOUNT AND PAYMENT 3
        if(form3_radio_check.isSelected() == false){
            p3 = "no";
        }else{p3 = "yes";}

        if(form3_radio_discount.isSelected() == false){
            d3 = "no";
        }else{d3 = "yes";}



        //DISCOUNT AND PAYMENT 4
        if(form4_radio_check.isSelected() == false){
            p4 = "no";
        }else{p4 = "yes";}

        if(form4_radio_discount.isSelected() == false){
            d4 = "no";
        }else{d4 = "yes";}




        String path1 = f_date+"--15H00.txt";
        Archive.Write(path1, form1_name.getText(), form1_patology.getText(), form1_birth.getText(), p1, d1, cd1);

        String path2 = f_date+"--16H30.txt";
        Archive.Write(path2, form2_name.getText(), form2_patology.getText(), form2_birth.getText(), p2, d2, cd2);

        String path3 = f_date+"--18H00.txt";
        Archive.Write(path3, form3_name.getText(), form3_patology.getText(), form3_birth.getText(), p3, d3, cd3);

        String path4 = f_date+"--19H30.txt";
        Archive.Write(path4, form4_name.getText(), form4_patology.getText(), form4_birth.getText(), p4, d4, cd4);

        Alerts.showAlert("Agenda Check-UP", null, "Agenda do dia " +f_date.split("-")[0] + "/" + f_date.split("-")[1] +"/" + f_date.split("-")[2] + " atualizada com sucesso!", Alert.AlertType.CONFIRMATION);

        daily_gains.setText("R$0,00");
        int ganhos = 0;

        if(cd1.charAt(0) == 'y' && p1.charAt(0) == 'y') { ganhos+=600; if(d1.charAt(0) == 'y') {ganhos-=150;} }
        if(cd1.charAt(0) == 'n' && p1.charAt(0) == 'y'){ ganhos+=300; if(d1.charAt(0) == 'y'){ ganhos -= 100; } }

        if(cd2.charAt(0) == 'y' && p2.charAt(0) == 'y') { ganhos+=600; if(d2.charAt(0) == 'y') {ganhos-=150;} }
        if(cd2.charAt(0) == 'n' && p2.charAt(0) == 'y'){ ganhos+=300; if(d2.charAt(0) == 'y'){ ganhos -= 100; } }

        if(cd3.charAt(0) == 'y' && p3.charAt(0) == 'y') { ganhos+=600; if(d3.charAt(0) == 'y') {ganhos-=150;} }
        if(cd3.charAt(0) == 'n' && p3.charAt(0) == 'y'){ ganhos+=300; if(d3.charAt(0) == 'y'){ ganhos -= 100; } }

        if(cd4.charAt(0) == 'y' && p4.charAt(0) == 'y') { ganhos+=600; if(d4.charAt(0) == 'y') {ganhos-=150;} }
        if(cd4.charAt(0) == 'n' && p4.charAt(0) == 'y'){ ganhos+=300; if(d4.charAt(0) == 'y'){ ganhos -= 100; } }

        String total = String.valueOf(ganhos);

        daily_gains.setText("R$"+ganhos+",00");

    }

    //Button LOAD
    public void onBtLoadClick(){

        if(date_selection != null) {
            String date = date_selection.getValue().toString();
            //Data formatada (dd-mm-yyyy)
            String f_date = d.formatDate(date);

            //15H00
            String path1 = f_date + "--15H00.txt";
            String content1 = Archive.Read(path1);
            String name1 = content1.split(";")[0];
            String birth1 = content1.split(";")[1];
            String patology1 = content1.split(";")[2];
            String payment1 = content1.split(";")[3];
            String discount1 = content1.split(";")[4];
            String double_c1 = content1.split(";")[5];


            this.form1_name.setText(name1);
            this.form1_patology.setText(patology1);
            this.form1_birth.setText(birth1);

            //16H30
            String path2 = f_date + "--16H30.txt";
            String content2 = Archive.Read(path2);
            String name2 = content2.split(";")[0];
            String birth2 = content2.split(";")[1];
            String patology2 = content2.split(";")[2];
            String payment2 = content2.split(";")[3];
            String discount2 = content2.split(";")[4];
            String double_c2 = content2.split(";")[5];

            this.form2_name.setText(name2);
            this.form2_patology.setText(patology2);
            this.form2_birth.setText(birth2);

            //18H00
            String path3 = f_date + "--18H00.txt";
            String content3 = Archive.Read(path3);
            String name3 = content3.split(";")[0];
            String birth3 = content3.split(";")[1];
            String patology3 = content3.split(";")[2];
            String payment3 = content3.split(";")[3];
            String discount3 = content3.split(";")[4];
            String double_c3 = content3.split(";")[5];

            //19H30
            String path4 = f_date + "--19H30.txt";
            String content4 = Archive.Read(path4);
            String name4 = content4.split(";")[0];
            String birth4 = content4.split(";")[1];
            String patology4 = content4.split(";")[2];
            String payment4 = content4.split(";")[3];
            String discount4 = content4.split(";")[4];
            String double_c4 = content4.split(";")[5];


            this.form3_name.setText(name3);
            this.form3_patology.setText(patology3);
            this.form3_birth.setText(birth3);



            //RADIOBUTTON1
            if(payment1.charAt(0) == 'y'){
                form1_radio_check.setSelected(true);
            } else { form1_radio_check.setSelected(false); }

            if(discount1.charAt(0) == 'y'){
                form1_radio_discount.setSelected(true);
            } else { form1_radio_discount.setSelected(false); }

            if(double_c1.charAt(0) == 'y'){
                form1_radio_discount.setSelected(true);
            } else { form1_radio_discount.setSelected(false); }

            //RADIOBUTTON2
            if(payment2.charAt(0) == 'y'){
                form2_radio_check.setSelected(true);
            } else { form2_radio_check.setSelected(false); }

            if(discount2.charAt(0) == 'y'){
                form2_radio_discount.setSelected(true);
            } else { form2_radio_discount.setSelected(false); }

            if(double_c2.charAt(0) == 'y'){
                form1_radio_discount.setSelected(true);
            } else { form1_radio_discount.setSelected(false); }

            //RADIOBUTTON3
            if(payment3.charAt(0) == 'y'){
                form3_radio_check.setSelected(true);
            } else { form3_radio_check.setSelected(false); }

            if(discount3.charAt(0) == 'y'){
                form3_radio_discount.setSelected(true);
            } else { form3_radio_discount.setSelected(false); }

            if(double_c3.charAt(0) == 'y'){
                form3_radio_discount.setSelected(true);
            } else { form1_radio_discount.setSelected(false); }

            //RADIOBUTTON4
            if(payment4.charAt(0) == 'y'){
                form4_radio_check.setSelected(true);
            } else { form4_radio_check.setSelected(false); }

            if(discount4.charAt(0) == 'y'){
                form4_radio_discount.setSelected(true);
            } else { form4_radio_discount.setSelected(false); }

            if(double_c4.charAt(0) == 'y'){
                form4_radio_discount.setSelected(true);
            } else { form4_radio_discount.setSelected(false); }

            //GANHOS TOTAIS DO DIA
            daily_gains.setText("R$0,00");
            int ganhos = 0;


            if(double_c1.charAt(0) == 'y' && payment1.charAt(0) == 'y') { ganhos+=600; if(discount1.charAt(0) == 'y') {ganhos-=150;} }
            if(double_c1.charAt(0) == 'n' && payment1.charAt(0) == 'y'){ ganhos+=300; if(discount1.charAt(0) == 'y'){ ganhos -= 100; } }

            if(double_c2.charAt(0) == 'y' && payment2.charAt(0) == 'y') { ganhos+=600; if(discount2.charAt(0) == 'y') {ganhos-=150;} }
            if(double_c2.charAt(0) == 'n' && payment2.charAt(0) == 'y'){ ganhos+=300; if(discount2.charAt(0) == 'y'){ ganhos -= 100; } }

            if(double_c3.charAt(0) == 'y' && payment3.charAt(0) == 'y') { ganhos+=600; if(double_c3.charAt(0) == 'y') {ganhos-=150;} }
            if(double_c3.charAt(0) == 'n' && payment3.charAt(0) == 'y'){ ganhos+=300; if(double_c3.charAt(0) == 'y'){ ganhos -= 100; } }

            if(double_c4.charAt(0) == 'y' && payment4.charAt(0) == 'y') { ganhos+=600; if(double_c4.charAt(0) == 'y') {ganhos-=150;} }
            if(double_c4.charAt(0) == 'n' && payment4.charAt(0) == 'y'){ ganhos+=300; if(double_c4.charAt(0) == 'y'){ ganhos -= 100; } }


            String total = String.valueOf(ganhos);

            daily_gains.setText("R$"+total+",00");


        }
        else {
            Alerts.showAlert("", "", "Erro! Data não selecionada!", Alert.AlertType.ERROR);
        }

    }

    //CLEARBUTTON
    public void onBtClearClick(){

        form1_name.setText(null);
        form1_patology.setText(null);
        form1_birth.setText(null);
        form1_radio_check.setSelected(false);
        form1_radio_discount.setSelected(false);
        form1_radio_cd.setSelected(false);

        form2_name.setText(null);
        form2_patology.setText(null);
        form2_birth.setText(null);
        form2_radio_check.setSelected(false);
        form2_radio_discount.setSelected(false);
        form2_radio_cd.setSelected(false);

        form3_name.setText(null);
        form3_patology.setText(null);
        form3_birth.setText(null);
        form3_radio_check.setSelected(false);
        form3_radio_discount.setSelected(false);
        form3_radio_cd.setSelected(false);

        form4_name.setText(null);
        form4_patology.setText(null);
        form4_birth.setText(null);
        form4_radio_check.setSelected(false);
        form4_radio_discount.setSelected(false);
        form4_radio_cd.setSelected(false);

        daily_gains.setText("R$0,00");

    }

    //TASKLISTBUTTON
    public void onBtTaskListClick(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("sceneNotAvailable.fxml"));

            Parent parent = FXMLLoader.load(getClass().getResource("/com/gui/TaskListView.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Lista de tarefas");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }

    //DETAILBUTTON
    public void onBtDetailClick(){

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("sceneNotAvailable.fxml"));



            Parent parent = FXMLLoader.load(getClass().getResource("/com/gui/DetailView.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Detalhes");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }

    }



}
