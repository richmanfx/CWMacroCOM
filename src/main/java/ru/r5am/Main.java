package ru.r5am;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    // Глобальные переменные
    final public static String nameIniFile = ".cwmacrocom/cwmacrocom.ini";            // файл конфигурации
    final public static String nameCWSignalFile = ".cwmacrocom/cwmacrocom.dat";       // файл CW сигналов
    final public static String nameMacrosFile = ".cwmacrocom/cwmacrocom.mks";         // файл с макросами
    final public static String pathUserHome = System.getProperty("user.home");        // папка пользователя

    final public static String programIcon = "images/cwmacrocom.png";                 // Иконка приложения


    @Override
    public void start(Stage primaryStage) throws Exception{

        String fxmlMainForm = "fxml/main.fxml";
        String programTitle = "CWMacroCOM";

            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlMainForm));

            primaryStage.setTitle(programTitle);

            // Минимальные и максимальные размеры главного окна
            primaryStage.setMinWidth(290);
            primaryStage.setMinHeight(130);
            primaryStage.setMaxWidth(800);
            primaryStage.setMaxHeight(630);

            // Установка иконки приложения
            primaryStage.getIcons().add(new Image(programIcon));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
