package ru.r5am.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Aleksandr Jashhuk (R5AM) on 07.05.2015.
 */
public class AboutController {

    @FXML
    private Button buttonOkAbout;

    public void buttonProcessing(ActionEvent actionEvent) throws Exception {

        // Определить источник нажатия
        Object source = actionEvent.getSource();

        // Если источник события не кнопка, то ничего не делать и выйти
        if (!(source instanceof Button)) {
            return;
        }

        // Нисходящее приведение
        Button clickedButton = (Button) source;

        switch (clickedButton.getId()) {

            case "buttonOkAbout":
                // Вызываем метод закрытия текущего окна
                MainController.actionClose(actionEvent);
                break;

        }
    }
}
