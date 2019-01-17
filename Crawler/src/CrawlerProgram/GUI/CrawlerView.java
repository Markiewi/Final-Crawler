package CrawlerProgram.GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;


public class CrawlerView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Crawler");
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        Label heading = new Label("Crawler");
        heading.setFont(Font.font("Verdana", 80));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        TextField startingUrl = new TextField();
        startingUrl.setPrefWidth(300);
        Label filter = new Label("Filter:");
        Label startingUrlText = new Label("Starting URL");
        CheckBox sameStringFilter = new CheckBox("Key words");
        CheckBox sameWebsiteFilter = new CheckBox("Same Website");
        TextField putKeyWords = new TextField();
        putKeyWords.visibleProperty().bind(sameStringFilter.selectedProperty());
        Label settings = new Label("Settings");
        CheckBox deep = new CheckBox("Deep");
        TextField putDeep = new TextField();
        putDeep.setText("0");
        putDeep.visibleProperty().bind(deep.selectedProperty());
        CheckBox limit = new CheckBox("Limit");
        TextField putLimit = new TextField();
        putLimit.setText("0");
        putLimit.visibleProperty().bind(limit.selectedProperty());
        Label sciezka = new Label("Sciezka");
        Label path = new Label();
        Button start = new Button("Start");
        start.setFont(Font.font(20));
        Button buttonToSelectPath = new Button("Select path");
        buttonToSelectPath.setOnAction(e -> {
            DirectoryChooser chooser = new DirectoryChooser();
            File file = chooser.showDialog(primaryStage);
            if (file != null) {
                path.setText(file.getAbsolutePath());
            } else {
                System.out.println("nie wybrano pliku");
            }
        });
        start.setOnAction(event -> {
            try {
                new StartButtonAction(startingUrl.getText(), putKeyWords.getText(), path.getText(), Integer.parseInt(putLimit.getText()), Integer.parseInt(putDeep.getText()), false).startCrawler();
            } catch (NumberFormatException nfe) {
                AlertBox.showErrorAlert("Invalid input", "The text enetered is not a number", "Deep and limit must be a number");
            }
        });
        gridPane.add(heading, 1, 1, 2, 1);
        gridPane.add(startingUrlText, 1, 2);
        gridPane.add(startingUrl, 1, 3, 2, 1);
        gridPane.add(settings, 1, 4);
        gridPane.add(limit, 1, 5);
        gridPane.add(putLimit, 2, 5);
        gridPane.add(deep, 1, 6);
        gridPane.add(putDeep, 2, 6);
        gridPane.add(filter, 1, 7);
        gridPane.add(sameWebsiteFilter, 1, 8);
        gridPane.add(sameStringFilter, 1, 9);
        gridPane.add(putKeyWords, 2, 9, 1, 1);
        gridPane.add(sciezka, 1, 11);
        gridPane.add(buttonToSelectPath, 1, 11);
        gridPane.add(path, 2, 11);
        gridPane.add(start, 2, 12);
        Scene scene = new Scene(gridPane, 400, 470);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
