package ru.r5am.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.r5am.Main;
import ru.r5am.controllers.MessageController;

import java.io.IOException;
import java.io.InputStream;

/*
 * Created by Aleksandr Jashhuk (R5AM) on 14.05.2015.
 */

public class MessageWindow {

    public void showMessageWindow(ActionEvent actionEvent,
                                  String title, String message) {

        MessageController.messageText = message;
        String fxmlMessageForm = "/fxml/message.fxml";

        try {

            Parent root;

            InputStream messageFxmlStream = getClass().getResourceAsStream(fxmlMessageForm);

            if (messageFxmlStream != null) {
                System.out.println("configFxml Stream: " + messageFxmlStream);
                FXMLLoader loader = new FXMLLoader();
                root = loader.load(messageFxmlStream);
            } else {
                System.err.println("Couldn't find file: " + fxmlMessageForm);
                return;
            }
            Stage stage = new Stage();
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlMessageForm));
            stage.setTitle(title + ".");

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
}
