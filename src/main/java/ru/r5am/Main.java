package ru.r5am;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    // Глобальные переменные
    final public static String nameIniFile = ".cwmacrocom/cwmacrocom.ini";            // файл конфигурации
    final public static String nameCWSignalFile = ".cwmacrocom/cwmacrocom.dat";       // файл CW сигналов
    final public static String nameMacrosFile = ".cwmacrocom/cwmacrocom.mks";         // файл с макросами
    final public static String pathUserHome = System.getProperty("user.home");        // папка пользователя

    final public static String programIcon = "/images/cwmacrocom.png";                 // Иконка приложения


    @Override
    public void start(Stage primaryStage) throws Exception {

        String fxmlMainForm = "/fxml/main.fxml";
        String programTitle = "CWMacroCOM";

        // Максимальные и минимальные размеры главного окна
        int maximumWindowHeight = 630;       // Pixels
        int maximumWindowWidth = 800;
        int minimumWindowHeight = 130;
        int minimumWindowWidth = 290;

        Parent root;

        InputStream mainFxmlStream = getClass().getResourceAsStream(fxmlMainForm);

        if (mainFxmlStream != null) {
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(mainFxmlStream);
        } else {
            System.err.println("Couldn't find file: " + fxmlMainForm);
            return;
        }

//        // Посмотрим путь, откуда мы стартуем
//        ApplicationStartUpPath startUpPath = new ApplicationStartUpPath();
//        try {
//            System.out.println("startUpPath: " + startUpPath.getApplicationStartUp());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        primaryStage.setTitle(programTitle);

        // Установка размеров главной формы
        primaryStage.setMinWidth(minimumWindowWidth);
        primaryStage.setMinHeight(minimumWindowHeight);
        primaryStage.setMaxWidth(maximumWindowWidth);
        primaryStage.setMaxHeight(maximumWindowHeight);

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
