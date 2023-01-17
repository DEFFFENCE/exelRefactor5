package com.example.modulefx;

import com.example.moduleOperation.Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class Controller {
    File file1;
    File file2;
    File file3;
    @FXML
    private Label filepath1;
    @FXML
    private Label filepath2;
    @FXML
    private Label filepath3;
    @FXML
    private Label finaltext;
    @FXML
    public Window primaryStage;
    @FXML
    public void sendMsg(ActionEvent actionEvent) {
        try {
            if (file1 != null|file2 != null|file3!= null) {
                Operations.operation1(file1.getPath(), file2.getPath(), file3.getPath());
                finaltext.setText("Готово");
            } else {
                System.out.println("Файл не выбран");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            //operations.operation1(file.getPath());
       // } else {
         //   System.out.println("Файл не выбран");
       // }
       // try {
         //   Operations.operation1();
           // welcomeText.setText("Welcome to JavaFX Application!");
       // } catch (Exception e) {
         //   e.printStackTrace();

    //метод кнопки для выбора пути
    @FXML
    public void handleButtonAction1() { //Открываем диалоговое окно для выбора файла
        FileChooser fileChooser1 = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Файлы xlsx (*.xlsx)", "*.xlsx");
        fileChooser1.setTitle("Открыть файл для загрузки");
        fileChooser1.getExtensionFilters().add(extFilter);
        file1 = fileChooser1.showOpenDialog(primaryStage);
        filepath1.setText(file1.getPath());
    }
    @FXML
    public void handleButtonAction2() { //Открываем диалоговое окно для выбора файла
        FileChooser fileChooser2 = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Файлы xlsx (*.xlsx)", "*.xlsx");
        fileChooser2.setTitle("Открыть файл для загрузки");
        fileChooser2.getExtensionFilters().add(extFilter);
        file2 = fileChooser2.showOpenDialog(primaryStage);
        filepath2.setText(file2.getPath());
    }
    @FXML
    public void handleButtonAction3() { //Открываем диалоговое окно для выбора файла
        FileChooser fileChooser3 = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Файлы xlsx (*.xls)", "*.xls");
        fileChooser3.setTitle("Открыть файл для загрузки");
        fileChooser3.getExtensionFilters().add(extFilter);
        file3 = fileChooser3.showOpenDialog(primaryStage);
        filepath3.setText(file3.getPath());
    }
}

//    public void sendMsg(ActionEvent actionEvent) {
  //      try {


  //      } catch (IOException e) {
    //        e.printStackTrace();

