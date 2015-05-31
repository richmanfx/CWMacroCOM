package sample.controllers;

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
import oracle.help.Help;
import oracle.help.library.helpset.HelpSet;
import oracle.help.library.helpset.HelpSetParseException;
import sample.Main;
import sample.classes.PlayMacro;
import sample.filework.datafilework.ReadDataFile;
import sample.filework.inifilework.ReadIniFile;
import sample.filework.macrosfilework.ReadMacrosFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static sample.classes.COMport.testPORT;


public class MainController {

    @FXML private Label labelF1;
    @FXML private Label labelF2;
    @FXML private Label labelF3;
    @FXML private Label labelF4;
    @FXML private Label labelF5;
    @FXML private Label labelF6;

    @FXML
    private void initialize() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {

        // Считываем параметры из INI-файла
        readConfig();
        // Выводим параметры в полях Config-формы

        // Считываем макросы из MKS-файла
        readMacros();
        // Выводим (обновляем) надписи labels на главной форме
        updateLabelsMainForm();

        // Считать CW сигналы из DAT-файла
        new ReadDataFile();


        // Отслеживание изменения текстового поля формы
//        labelF1.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable,
//                                String oldValue, String newValue) {
//
//                System.out.println("Изменилось поле F1!");
//                updateLabels();
//
//            }
//        });

    }


    private void readConfig() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {

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
                ReadIniFile.parity = false;           // Есть ли проверка чётности

                // Скорость CW
                ReadIniFile.speedCW = 100;

                // Чем манипулировать - DTR или RTS?
                ReadIniFile.cwManipulationSignal = "DTR";


                // Использовать ли PTT?
                ReadIniFile.usePTT = false;

                // Задержки в миллисекундах
                ReadIniFile.pttToCwDelay = 0;     //   после PTT до CW
                ReadIniFile.cwToPttDelay = 0;     //   отпускание PTT после CW
            }
    }

    private void readMacros() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {
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

    //    // Привязка переменных к компонентам в main.fxml
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

    // Обработка кнопок клавиатуры (нажатия мышкой обрабатываются отдельно!!!)
    @FXML
    private void HBoxOnKeyPressed(KeyEvent keyEvent) throws Exception {
        System.out.println("Нажата key: " + keyEvent.getCode());
        switch (keyEvent.getCode()) {

            case F1:
                PlayMacro.playMacro(labelF1.getText());
                buttonF1.requestFocus();
                break;

            case F2:
                PlayMacro.playMacro(labelF2.getText());
                buttonF2.requestFocus();
                break;

            case F3:
                PlayMacro.playMacro(labelF3.getText());
                buttonF3.requestFocus();
                break;

            case F4:
                PlayMacro.playMacro(labelF4.getText());
                buttonF4.requestFocus();
                break;

            case F5:
//                PlayMacro.playMacro(labelF5.getText());
                buttonF5.requestFocus();
                // PlayMacro.TestWaveFile();
                PlayMacro.TestSample();
                break;

            case F6:
                // PlayMacro.playMacro(labelF6.getText());
                // Список доступных СОМ-портов
//                listCOMpotrs();
                // Тестики :-)
                testPORT();

                buttonF6.requestFocus();
                break;
        }
    }

    // Обработка нажатий мышкой на Buttons (клавиатура отдельно обрабатывается!)
    public void buttonProcessing(ActionEvent actionEvent) throws HelpSetParseException,
                                                                 InvocationTargetException,
                                                                 NoSuchMethodException,
                                                                 InstantiationException,
                                                                 IOException,
                                                                 IllegalAccessException {

        Object source = actionEvent.getSource();
    //  System.out.println(actionEvent.getSource().toString());

        // Если источник события не кнопка, то ничего не делать и выйти
        if (!(source instanceof Button)) {
            return;
        }

        // Нисходящее приведение
        Button clickedButton = (Button) source;

        switch (clickedButton.getId()) {
            case "buttonEdit":
                // System.out.println("Нажата кнопка: " + clickedButton.getId());
                // Редактирование макросов
                actionEdit(actionEvent);
                // Обновление Main формы
                initialize();
                break;

            case "buttonOptions":
                // System.out.println("Нажата кнопка: " + clickedButton.getId());
                // Редактирование параметров
                actionConfig(actionEvent);
                // Перечитать обновлённые параметры
                initialize();
                break;

            case "buttonHelp":
                // Запускаем OHJ
                try {
                    showHelp();
                } catch (HelpSetParseException e) {
                    e.printStackTrace();
                }
                break;

            case "buttonAbout":
                // Показать модальное окно "О программе"
                showAboutWindow(actionEvent);
                break;

            case "buttonExit":
                // Вызываем метод закрытия текущего окна
                actionClose(actionEvent);
                break;

            case "buttonF1":
                // System.out.println("Нажата кнопка: " + clickedButton.getId());
                // System.out.println(ReadMacrosFile.F1.toUpperCase());
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
                testPORT();
                break;

            case "buttonOkAbout":
                // Вызываем метод закрытия текущего окна
                actionClose(actionEvent);
                break;
        }

    }

    // Запускаем форму редактирования параметров
    private void actionConfig(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/config.fxml"));
            stage.setTitle("CWMacroCOM.  Редактирование параметров.");
            stage.setMinHeight(600);
            stage.setMaxWidth(600);

            // Установка иконки приложения
            stage.getIcons().add(new Image("sample/images/cwmacrocom.png"));

            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            // Определим родительское окно по событию
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            //            stage.show();
            stage.showAndWait();    // Ождать закрытия формы ( для initialize() )
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // Выводим на экран HELP
    private void showHelp() throws HelpSetParseException {

        Help myHelp = new Help();

        try {
            HelpSet myHelpSet = new HelpSet(getClass().getResource("../help/cwmacrocom.hs"));
            myHelp.addBook(myHelpSet);
            myHelp.showNavigatorWindow();
            myHelp.showTopic(myHelpSet, "topic1");
        } catch (Exception ex) {
            System.out.println("Эксцепшен HelpSet.");
        }
    }

    // Запускаем форму редактирования макросов
    private void actionEdit(ActionEvent actionEvent) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/editing.fxml"));
            stage.setTitle("CWMacroCOM.  Редактирование макросов.");
            stage.setMinHeight(400);
            stage.setMaxWidth(600);

            // Установка иконки приложения
            stage.getIcons().add(new Image("sample/images/cwmacrocom.png"));

            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            // Определим родительское окно по событию
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
            stage.showAndWait();    // Ождать закрытия формы ( для initialize() )
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void showAboutWindow(ActionEvent actionEvent) {
        try {
            // TODO: не создавать каждый раз объекты эти при нажатии, а только показывать и скрывать
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/about.fxml"));
            stage.setTitle("CWMacroCOM.  О программе.");
            stage.setMinHeight(300);
            stage.setMaxWidth(685);

            // Установка иконки окна
            stage.getIcons().add(new Image("sample/images/cwmacrocom.png"));

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


    public static void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


    private void updateLabelsMainForm() {
        // Выводим макросы на лейблы Main формы
        labelF1.setText(ReadMacrosFile.F1.toUpperCase());
        labelF2.setText(ReadMacrosFile.F2.toUpperCase());
        labelF3.setText(ReadMacrosFile.F3.toUpperCase());
        labelF4.setText(ReadMacrosFile.F4.toUpperCase());
        labelF5.setText(ReadMacrosFile.F5.toUpperCase());
        labelF6.setText(ReadMacrosFile.F6.toUpperCase());
    }

}
