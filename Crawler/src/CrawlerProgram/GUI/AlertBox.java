package CrawlerProgram.GUI;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.control.*;

import java.util.Optional;

public class AlertBox {

    public static void showErrorAlert(String title, String headText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void showRunningCrawler(Task<Void> task, Alert alert) {
        ProgressIndicator progressIndicator = new ProgressIndicator();
        ButtonType cancel = new ButtonType("Cancel");
        alert.setGraphic(progressIndicator);
        alert.setTitle("Crawler");
        alert.setHeaderText("Crawler is running");
        alert.setContentText("Please wait...");
        alert.getButtonTypes().clear();
        alert.getButtonTypes().add(cancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == cancel) {
                task.cancel();
            }
        }
    }


}
