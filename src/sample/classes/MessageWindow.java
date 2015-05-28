package sample.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controllers.MessageController;

import java.io.IOException;

/**
 * Created by Asus on 14.05.2015.
 */
public class MessageWindow {

    public void showMessageWindow(ActionEvent actionEvent, String title, String message) {

        MessageController.messageText = message;

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/message.fxml"));
            stage.setTitle(title + ".");
            stage.setMinHeight(250);
            stage.setMaxWidth(400);

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
}
