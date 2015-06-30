package ru.r5am.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import oracle.help.library.helpset.HelpSetParseException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * Created by Aleksandr Jashhuk (R5AM) on 14.05.2015.
 */
public class MessageController {

    @FXML private Label labelMessage;

    public static String messageText;

    @FXML
    private Button buttonOKMessage;

    @FXML private void initialize() {
        // Вывод сообщения
        labelMessage.setText(messageText);
    }


    public void buttonProcessing(ActionEvent actionEvent) throws HelpSetParseException, InvocationTargetException, NoSuchMethodException, InstantiationException, IOException, IllegalAccessException {

        // Определить источник нажатия
        Object source = actionEvent.getSource();

        // Если источник события не кнопка, то ничего не делать и выйти
        if (!(source instanceof Button)) {
            return;
        }

        // Нисходящее приведение
        Button clickedButton = (Button) source;

        if (Objects.equals(clickedButton.getId(), "buttonOKMessage")) {
                // Вызываем метод закрытия текущего окна
                MainController.actionClose(actionEvent);
        }
    }
}
