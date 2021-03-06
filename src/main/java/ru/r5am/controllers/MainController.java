package ru.r5am.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jssc.SerialPortException;
import oracle.help.library.helpset.HelpSetParseException;
import ru.r5am.Main;
import ru.r5am.classes.OHJHelp;
import ru.r5am.classes.PlayMacro;
import ru.r5am.filework.datafilework.ReadDataFile;
import ru.r5am.filework.inifilework.ReadIniFile;
import ru.r5am.filework.macrosfilework.ReadMacrosFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;


public class MainController {

    // Объект Help-a
    OHJHelp MyHelp = new OHJHelp();

    @FXML private Label labelF1;
    @FXML private Label labelF2;
    @FXML private Label labelF3;
    @FXML private Label labelF4;
    @FXML private Label labelF5;
    @FXML private Label labelF6;

    @FXML
    private void initialize() throws InvocationTargetException, NoSuchMethodException,
                                     InstantiationException, IOException, IllegalAccessException {

        // Считываем параметры из INI-файла
        readConfig();

        // Считываем макросы из MKS-файла
        readMacros();

        // Выводим (обновляем) надписи labels на главной форме
        updateLabelsMainForm();

        // Считать CW сигналы из DAT-файла
        new ReadDataFile();


    }

    /**
     * Считываем параметры из INI-файла
     */
     void readConfig() throws InvocationTargetException, NoSuchMethodException,
                                     InstantiationException, IOException, IllegalAccessException {

            // Существует ли INI-файл с параметрами?
            File fuelIniFile = new File(Main.pathUserHome +
                    System.getProperty("file.separator") +
                    Main.nameIniFile);

            if (fuelIniFile.exists() && fuelIniFile.isFile()) {

                // Считываем параметры из существующего INI-файла
                new ReadIniFile();
            } else {
                // INI-файла нет, используем значения "по умолчанию"

                // Название СОМ порта
                ReadIniFile.nameCOMport = "COM6";
                // настройки СОМ-порта
                ReadIniFile.baudRate = 9600;      // Скорость в порту
                ReadIniFile.dataBits = 8;         // Бит в пакете
                ReadIniFile.stopBits = 1;         // Количество стоп-битов
                ReadIniFile.parity = false;       // Есть ли проверка чётности

                // Скорость CW
                ReadIniFile.speedCW = 100;

                // Чем манипулировать - DTR или RTS?
                ReadIniFile.cwManipulationSignal = "DTR";

                // Использовать ли PTT?
                ReadIniFile.usePTT = false;

                // Задержки в миллисекундах
                ReadIniFile.pttToCwDelay = 0;     //   после PTT до CW
                ReadIniFile.cwToPttDelay = 0;     //   до отпускание PTT после окончания CW
            }
    }

    /**
     * Считываем макросы из MKS-файла
     */
    private void readMacros() throws InvocationTargetException, NoSuchMethodException,
                                     InstantiationException, IOException, IllegalAccessException {
        // Существует ли MKS-файл с макросами?
        File fuelMacrosFile = new File(Main.pathUserHome +
                                       System.getProperty("file.separator") +
                                       Main.nameMacrosFile);

        if (fuelMacrosFile.exists() && fuelMacrosFile.isFile()) {
            // Считываем макросы из существующего MKS-файла
            new ReadMacrosFile();
        } else {
            // MKS-файла нет, используем значения "по умолчанию"
            ReadMacrosFile.F1 = "Default macros N1";
            ReadMacrosFile.F2 = "Default macros N2";
            ReadMacrosFile.F3 = "Default macros N3";
            ReadMacrosFile.F4 = "Default macros N4";
            ReadMacrosFile.F5 = "Default macros N5";
            ReadMacrosFile.F6 = "Default macros N6";
        }
    }

    // Привязка переменных к компонентам в main.fxml
    @FXML private Button buttonEdit;
    @FXML private Button buttonOptions;
    @FXML private Button buttonHelp;
    @FXML private Button buttonAbout;
    @FXML private Button buttonExit;
    @FXML private Button buttonF1;
    @FXML private Button buttonF2;
    @FXML private Button buttonF3;
    @FXML private Button buttonF4;
    @FXML private Button buttonF5;
    @FXML private Button buttonF6;

    /**
     * Обработка кнопок клавиатуры (нажатия мышкой обрабатываются отдельно!!!)
     */
    @FXML
    private void HBoxOnKeyPressed(KeyEvent keyEvent) throws Exception {
//        System.out.println("Pressed key: " + keyEvent.getCode());
        switch (keyEvent.getCode()) {

            case F1:
                buttonF1.requestFocus();
//                System.out.println("labelF1= " + labelF1.getText());
                PlayMacro.playMacro(labelF1.getText());
                break;

            case F2:
                buttonF2.requestFocus();
                PlayMacro.playMacro(labelF2.getText());
                break;

            case F3:
                buttonF3.requestFocus();
                PlayMacro.playMacro(labelF3.getText());
                break;

            case F4:
                buttonF4.requestFocus();
                PlayMacro.playMacro(labelF4.getText());
                break;

            case F5:
                buttonF5.requestFocus();
                PlayMacro.playMacro(labelF5.getText());
                break;

            case F6:
                buttonF6.requestFocus();
                PlayMacro.playMacro(labelF6.getText());

                // Тестики :-)
                    //MyPort.testPORT();
                break;
        }
    }

    /**
     *  Обработка нажатий мышкой на Buttons (клавиатура отдельно обрабатывается!)
     */
    public void buttonProcessing(ActionEvent actionEvent) throws InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IOException,
            IllegalAccessException, HelpSetParseException, SerialPortException {

        Object source = actionEvent.getSource();

        // Если источник события не кнопка, то ничего не делать и выйти
        if (!(source instanceof Button)) {
            return;
        }

        // Нисходящее приведение
        Button clickedButton = (Button) source;

        switch (clickedButton.getId()) {
            case "buttonEdit":
                // Редактирование макросов
                actionEdit(actionEvent);
                // Обновление Main формы
                initialize();
                break;

            case "buttonOptions":
                // Редактирование параметров
                actionConfig(actionEvent);
                // Перечитать обновлённые параметры
                initialize();
                break;

            case "buttonHelp":
                // Запускаем OHJ

                try {
                    MyHelp.showHelp();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "buttonAbout":
                // Показать модальное окно "О программе"
                showAboutWindow(actionEvent);
                break;

            case "buttonExit":
                MyHelp.disposeHelp();
                // Вызываем метод закрытия текущего окна
                actionClose(actionEvent);
                break;

            case "buttonF1":
                PlayMacro.playMacro(labelF1.getText());
                break;

            case "buttonF2":
                PlayMacro.playMacro(labelF2.getText());
                break;

            case "buttonF3":
                PlayMacro.playMacro(labelF3.getText());
                break;

            case "buttonF4":
                PlayMacro.playMacro(labelF4.getText());
                break;

            case "buttonF5":
                PlayMacro.playMacro(labelF5.getText());
                break;

            case "buttonF6":
                PlayMacro.playMacro(labelF6.getText());
//                new COMPort().testPORT();
                break;

            case "buttonOkAbout":

                // Вызываем метод закрытия текущего окна
                actionClose(actionEvent);
                break;
        }
    }

    /**
     * Запускаем форму редактирования параметров
     */
    private void actionConfig(ActionEvent actionEvent) {

        String fxmlConfigForm = "/fxml/config.fxml";
        int maximumWindowWidth = 600;           // Pixels
        int minimumWindowHeight = 600;

        try {
            Parent root;
            InputStream configFxmlStream = getClass().getResourceAsStream(fxmlConfigForm);

            if (configFxmlStream != null) {
//                System.out.println("configFxml Stream: " + configFxmlStream);
                FXMLLoader loader = new FXMLLoader();
                root = loader.load(configFxmlStream);
            } else {
                System.err.println("Couldn't find file: " + fxmlConfigForm);
                return;
            }

            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlConfigForm));
            stage.setTitle("CWMacroCOM.  Редактирование параметров.");
            stage.setMaxWidth(maximumWindowWidth);
            stage.setMinHeight(minimumWindowHeight);

            // Установка иконки окна
            stage.getIcons().add(new Image(Main.programIcon));

            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            // Определим родительское окно по событию
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.showAndWait();    // Ожидать закрытия формы ( для initialize() )
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *  Запускаем форму редактирования макросов
     */
    private void actionEdit(ActionEvent actionEvent) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {

        String fxmlEditForm ="/fxml/editing.fxml";
        int maximumWindowWidth = 600;           // Pixels
        int minimumWindowHeight = 400;

        try {
            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlEditForm));
            Parent root;

            InputStream editFxmlStream = getClass().getResourceAsStream(fxmlEditForm);

            if (editFxmlStream != null) {
//                 System.out.println("editFxml Stream: " + editFxmlStream);
                FXMLLoader loader = new FXMLLoader();
                root = loader.load(editFxmlStream);
            } else {
                System.err.println("Couldn't find file: " + fxmlEditForm);
                return;
            }

            stage.setTitle("CWMacroCOM.  Редактирование макросов.");
            stage.setMaxWidth(maximumWindowWidth);
            stage.setMinHeight(minimumWindowHeight);

            // Установка иконки окна
            stage.getIcons().add(new Image(Main.programIcon));

            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            // Определим родительское окно по событию
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.showAndWait();    // Ожидать закрытия формы ( для initialize() )
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Запускаем модальное окно "О программе"
     */
    private void showAboutWindow(ActionEvent actionEvent) {

        String fxmlAboutForm = "/fxml/about.fxml";
        int maximumWindowWidth = 685;           // Pixels
        int minimumWindowHeight = 300;

        try {
            Parent root;

            InputStream aboutFxmlStream = getClass().getResourceAsStream(fxmlAboutForm);

            if (aboutFxmlStream != null) {
//                System.out.println("aboutFxml Stream: " + aboutFxmlStream);
                FXMLLoader loader = new FXMLLoader();
                root = loader.load(aboutFxmlStream);
            } else {
                System.err.println("Couldn't find file: " + fxmlAboutForm);
                return;
            }


            // TODO: не создавать каждый раз объекты эти при нажатии, а только показывать и скрывать
            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlAboutForm));
            stage.setTitle("CWMacroCOM.  О программе.");
            stage.setMaxWidth(maximumWindowWidth);
            stage.setMinHeight(minimumWindowHeight);

            // Установка иконки окна
            stage.getIcons().add(new Image(Main.programIcon));
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            // Определим родительское окно по событию
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод закрытия окна
     */
    public static void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    /**
    * Выводим макросы на лейблы Main формы
    */
    private void updateLabelsMainForm() {
        labelF1.setText(ReadMacrosFile.F1.toUpperCase());
        labelF2.setText(ReadMacrosFile.F2.toUpperCase());
        labelF3.setText(ReadMacrosFile.F3.toUpperCase());
        labelF4.setText(ReadMacrosFile.F4.toUpperCase());
        labelF5.setText(ReadMacrosFile.F5.toUpperCase());
        labelF6.setText(ReadMacrosFile.F6.toUpperCase());
    }
}
