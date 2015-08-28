package ru.r5am.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.r5am.classes.COMPort;
import ru.r5am.classes.MessageWindow;
import ru.r5am.filework.inifilework.ReadIniFile;
import ru.r5am.filework.inifilework.WriteIniFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by Aleksandr Jashhuk (R5AM) on 12.05.2015.
 */

public class ConfigController {

    @FXML private TextField textFieldCWSpeed;
    @FXML private TextField textFieldCaliberCWSpeed;
    @FXML private TextField textFieldNamePort;
    @FXML private TextField textFieldBits;
    @FXML private TextField textFieldBaudRate;
    @FXML private CheckBox checkBoxParity;
    @FXML private TextField textFieldStopBits;
    @FXML private RadioButton radioButtonDTR;
    @FXML private ToggleGroup radioGroup;
    @FXML private RadioButton radioButtonRTS;
    @FXML private CheckBox checkBoxUsePTT;
    @FXML private TextField textFieldDelayPTTtoCW;
    @FXML private TextField textFieldDelayCWtoPTT;
    @FXML private TextField textFieldDelayBetweenSymbols;

    @FXML private void initialize() {

        // Заполняем поля и чекбоксы из INI-файла
        textFieldCWSpeed.setText(Integer.toString(ReadIniFile.speedCW));
        textFieldCaliberCWSpeed.setText(Integer.toString(ReadIniFile.caliberSpeedCW));

        textFieldNamePort.setText(ReadIniFile.nameCOMport.toUpperCase());
        textFieldBaudRate.setText(Integer.toString(ReadIniFile.baudRate));
        checkBoxParity.setSelected(ReadIniFile.parity);
        textFieldBits.setText(Integer.toString(ReadIniFile.dataBits));
        textFieldStopBits.setText(Integer.toString(ReadIniFile.stopBits));

        switch (ReadIniFile.cwManipulationSignal.toUpperCase()) {

            case "DTR":
            radioGroup.selectToggle(radioButtonDTR);
            break;

            // TODO: Добавить жёсткую проверку на "RTS"
            case "RTS":
            radioGroup.selectToggle(radioButtonRTS);
            break;

            default:
                MessageWindow myMessageWindows = new MessageWindow();
                ActionEvent actionEvent = null;
                // TODO: Сделать сообщения через Dialog
                System.out.println("Неверные данные в INI-файле: ни DTR, ни RTS.");
            break;

        }

        checkBoxUsePTT.setSelected(ReadIniFile.usePTT);
        textFieldDelayPTTtoCW.setText(Integer.toString(ReadIniFile.pttToCwDelay));
        textFieldDelayCWtoPTT.setText(Integer.toString(ReadIniFile.cwToPttDelay));
        textFieldDelayBetweenSymbols.setText(Integer.toString(ReadIniFile.betweenSymbolsDelay));
    }

    public void buttonProcessing(ActionEvent actionEvent) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {

        // Определить источник события (нажатия)
        Object source = actionEvent.getSource();

        // Если источник события не кнопка, то ничего не делать и выйти
        if (!(source instanceof Button)) {
            return;
        }

        // Нисходящее приведение (Object приводим к Button)
        Button clickedButton = (Button) source;

        // По ID определяем конкретную кнопку
        switch (clickedButton.getId()) {
            case "buttonSave":
                // Проверка правильности введённых значений
                if(Objects.equals(actionValidateTextField(), "GoodValue")) {     // Если данные валидные, то сохраняем
                    // Сохраняем параметры в INI-файл
                    actionSaveIni();
                    // Закрываем форму редактирования
                    MainController.actionClose(actionEvent);
                    // Перечитываем параметры из INI-файла
                    // new ReadIniFile();  не работает !!!
                } else {
//                    System.out.println("Не валидные данные в форме.");
                    // Вывод окна сообщения
                    MessageWindow myMessageWindows = new MessageWindow();
                    myMessageWindows.showMessageWindow(actionEvent,
                                                      "Сообщение",
                                                      "Введены неверные данные:\n" +
                            actionValidateTextField());     // Поле с невалидными данными
                    // TODO: Здесь будет beep
                    // beep();
                }
                break;

            case "buttonCancel":
                // Выход без сохранения параметров
                MainController.actionClose(actionEvent);
                break;

            case "buttonListCOMs":
                // Показать доступные COM-порты
                COMPort MyPort = new COMPort();
                String COMPortNames[] = MyPort.listCOMPorts();

                String listCOMPorts = "";
                for (String portName : COMPortNames)
                {
                    //System.out.println(portName);
                    listCOMPorts = listCOMPorts + portName + "\n";
                }

                // Вывод окна сообщения
                MessageWindow myMessageWindows = new MessageWindow();
                myMessageWindows.showMessageWindow(actionEvent,
                        "Сообщение",
                        "Доступные COM-порты:\n" +
                        listCOMPorts);

        }
    }

    // Проверка правильности введённых значений
    private String actionValidateTextField() {

        String returnValue = "GoodValue"; // Возвращаемое значение

        // Диапазон допустимой скорости CW
        int minCWSpeed = 40;
        int maxCWSpeed = 200;
        if (Integer.parseInt(textFieldCWSpeed.getText()) < minCWSpeed ||
                Integer.parseInt(textFieldCWSpeed.getText()) > maxCWSpeed) {
            returnValue = "Скорость CW\n" +     // Невалидное значение параметра
                    "("+minCWSpeed+"..."+maxCWSpeed+")";
        }
//        if(!Objects.equals(returnValue, "GoodValue")) {
//            return returnValue;
//        }

        // Диапазон допустимого значения калибра скорости CW
        int minCaliberCWSpeed = 3000;
        int maxCaliberCWSpeed = 9000;
        if (Integer.parseInt(textFieldCaliberCWSpeed.getText()) < minCaliberCWSpeed ||
                Integer.parseInt(textFieldCaliberCWSpeed.getText()) > maxCaliberCWSpeed) {
            returnValue = "Калибр CW\n" +     // Невалидное значение параметра
                    "("+minCaliberCWSpeed+"..."+maxCaliberCWSpeed+")";
        }

        // Наименование COM-порта
        // TODO: для Unix добавить имена из /dev
        // Начало строки и две цифры только допустимо
        {
            Pattern p = Pattern.compile("^COM[1-9]\\d{0,1}$");      // Проверяем регулярным выражением
            Matcher m = p.matcher(textFieldNamePort.getText());
            if (!m.matches()) {
                returnValue = "COM порт\n" +
                              "(например, COM7 или COM15)";
            }
        }

        // Число бит
        {
            Pattern p = Pattern.compile("^[5-8]$");      // Проверяем регулярным выражением
            Matcher m = p.matcher(textFieldBits.getText());
            if (!m.matches()) {
                returnValue = "Бит в фрейме\n" +
                              "(5, 6, 7 или 8)";
            }
        }

        // Скорость порта
        {
            String[] speedCOMPort = {"1200", "2400", "4800", "9600", "19200", "38400", "57600", "115200" };

            for(int i=0; i<speedCOMPort.length; i++) {
                if (Objects.equals(textFieldBaudRate.getText(), speedCOMPort[i])) {
                    //returnValue = "Скорость порта";
                    break;
                } else {
                    if(i == (speedCOMPort.length - 1)) {        // Последняя из массива скорость
                        returnValue = "Скорость порта\n" +
                                      "(например, 57600)";
                    }
                }
            }
        }

        // Количество стоповых битов (1, 1.5 или 2)
        {
            String[] stopBits = {"1", "2"};     // TODO: add stopBits = 1.5 - double, not int in INI-file

            for(int i=0; i<stopBits.length; i++) {
                if (Objects.equals(textFieldStopBits.getText(), stopBits[i])) {
                    break;
                } else {
                    if(i == (stopBits.length - 1)) {        // Последняя из массива stopBits
                        returnValue = "Стоп битов\n" +
                                      "(1 или 2)";
                    }
                }
            }
        }

        // Задержка после PTT до CW
        {
            Pattern p = Pattern.compile("^\\d{1,3}$");      // Проверяем регулярным выражением
            Matcher m = p.matcher(textFieldDelayPTTtoCW.getText());
            if (!m.matches()) {
                returnValue = "Задержка после PTT до CW\n(0...999 мс)";
            }
        }

        // Задержка отпускания PTT после CW
        {
            Pattern p = Pattern.compile("^\\d{1,3}$");      // Проверяем регулярным выражением
            Matcher m = p.matcher(textFieldDelayCWtoPTT.getText());
            if (!m.matches()) {
                returnValue = "Задержка отпускания PTT\nпосле CW\n(0...999 мс)";
            }
        }

        // Дополнительная задержка между символами
        {
            Pattern p = Pattern.compile("^\\d{1,3}$");      // Проверяем регулярным выражением
            Matcher m = p.matcher(textFieldDelayBetweenSymbols.getText());
            if (!m.matches()) {
                returnValue = "Дополнительная задержка между символами\n(0...999 мс)";
            }
        }

        return returnValue;
    }

    private void actionSaveIni() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {
        // Сохраняем параметры из формы в INI-файл
        WriteIniFile.speedCW = Integer.parseInt(textFieldCWSpeed.getText());
        WriteIniFile.caliberSpeedCW = Integer.parseInt(textFieldCaliberCWSpeed.getText());

        WriteIniFile.nameCOMport = textFieldNamePort.getText().toUpperCase();
        WriteIniFile.baudRate = Integer.parseInt(textFieldBaudRate.getText());
        WriteIniFile.dataBits = Integer.parseInt(textFieldBits.getText());
        WriteIniFile.stopBits = Integer.parseInt(textFieldStopBits.getText());
        WriteIniFile.parity = checkBoxParity.isSelected();

        if(radioGroup.getSelectedToggle().equals(radioButtonDTR)) {  // Если в группе выбрана кнопка DTR
            WriteIniFile.cwManipulationSignal = "DTR";
        }
        if(radioGroup.getSelectedToggle().equals(radioButtonRTS)) {  // Если в группе выбрана кнопка RTS}
            WriteIniFile.cwManipulationSignal = "RTS";
        }


        WriteIniFile.usePTT = checkBoxUsePTT.isSelected();
        WriteIniFile.pttToCwDelay = Integer.parseInt(textFieldDelayPTTtoCW.getText());
        WriteIniFile.cwToPttDelay = Integer.parseInt(textFieldDelayCWtoPTT.getText());
        WriteIniFile.betweenSymbolsDelay = Integer.parseInt(textFieldDelayBetweenSymbols.getText());

        new WriteIniFile();
    }


}
