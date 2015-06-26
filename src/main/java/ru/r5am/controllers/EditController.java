package ru.r5am.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.r5am.filework.macrosfilework.ReadMacrosFile;
import ru.r5am.filework.macrosfilework.WriteMacrosFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Aleksandr Jashhuk (R5AM) on 03.05.2015.
 */


public class EditController {

    // Привязка переменных к компонентам в editing.fxml

    @FXML
    private Button buttonSave;

    @FXML
    private Button buttonCancel;

    @FXML
    private TextField textFieldF1;

    @FXML
    private TextField textFieldF2;

    @FXML
    private TextField textFieldF3;

    @FXML
    private TextField textFieldF4;

    @FXML
    private TextField textFieldF5;

    @FXML
    private TextField textFieldF6;

    @FXML
    private void initialize() {

        // Заполняем текстовые поля из лейблов Main формы
        textFieldF1.setText(ReadMacrosFile.F1.toUpperCase());
        textFieldF2.setText(ReadMacrosFile.F2.toUpperCase());
        textFieldF3.setText(ReadMacrosFile.F3.toUpperCase());
        textFieldF4.setText(ReadMacrosFile.F4.toUpperCase());
        textFieldF5.setText(ReadMacrosFile.F5.toUpperCase());
        textFieldF6.setText(ReadMacrosFile.F6.toUpperCase());
    }


    private void actionSaveMacros() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {
        // Сохраняем макросы из полей формы в MKS-файл
        WriteMacrosFile.F1 = textFieldF1.getText().toUpperCase();
        WriteMacrosFile.F2 = textFieldF2.getText().toUpperCase();
        WriteMacrosFile.F3 = textFieldF3.getText().toUpperCase();
        WriteMacrosFile.F4 = textFieldF4.getText().toUpperCase();
        WriteMacrosFile.F5 = textFieldF5.getText().toUpperCase();
        WriteMacrosFile.F6 = textFieldF6.getText().toUpperCase();
        new WriteMacrosFile();
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
                // Сохраняем маросы в файл
                actionSaveMacros();
                // Закрываем форму редактирования
                MainController.actionClose(actionEvent);
            break;

            case "buttonCancel":
                // Выход без сохранения макросов
                MainController.actionClose(actionEvent);
            break;
        }
    }
}
