package sample;

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



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        primaryStage.setTitle("CWMacroCOM");

        // Минимальные и максимальные размеры окна
        primaryStage.setMinWidth(290);
        primaryStage.setMinHeight(130);
        primaryStage.setMaxWidth(800);
        primaryStage.setMaxHeight(630);

        // Установка иконки приложения
        primaryStage.getIcons().add(new Image("sample/images/cwmacrocom.png"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        // Работают оба варианта, но пути до папки css чумовые и в out\production\cwmacrocom
        //   в итоге подключил в файлах *.fxml
        // primaryStage.getScene().getStylesheets().add("/css/JMetroDarkTheme.css");
        //primaryStage.getScene().getStylesheets().add(getClass().getResource("/css/JMetroDarkTheme.css").toExternalForm());

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
