package CrawlerProgram.GUI;

import CrawlerProgram.Crawler.Crawler;
import CrawlerProgram.Filters.*;
import CrawlerProgram.GUI.AlertBox;
import javafx.concurrent.Task;
import javafx.scene.control.Alert;

import java.net.URL;

public class StartButtonAction {
    String startUrl, keyWords, path;
    Integer limit, deep;
    Boolean sameWebsiteOnly;

    public StartButtonAction(String startUrl, String keyWords, String path, Integer limit, Integer deep, Boolean sameWebsiteOnly) {
        this.startUrl = startUrl;
        this.keyWords = keyWords;
        this.path = path;
        this.limit = limit;
        this.sameWebsiteOnly = sameWebsiteOnly;
        this.deep = deep;
    }

    public void startCrawler() {
        boolean canRun = true;
        try {
            new URL(startUrl).toURI();
        } catch (Exception e) {
            canRun = false;
            AlertBox.showErrorAlert("Wrong input", "The URL has wrong form", "Please enter valid URL");
        }
        if (canRun) {
            if (path == "") AlertBox.showErrorAlert("Wrong path", "The file was not found", "Please enter valid path");
            else {
                IFilter filter = new EmptyFilter();
                if (deep == 0) deep = 100000000;
                if (limit == 0) limit = 1000000000;
                if (sameWebsiteOnly && keyWords != null) {
                    filter = new SameStringFilterOnSameWebsiteOnly(keyWords, startUrl);
                }
                if (sameWebsiteOnly) {
                    filter = new SameWebsiteOnly(startUrl);
                }
                if (keyWords != null) {
                    filter = new SameStringFilter(keyWords);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                Task<Void> crawler = new Crawler(filter, deep, limit, startUrl, path);
                crawler.setOnSucceeded(event -> {
                    alert.close();
                });
                Thread thread = new Thread(crawler);
//            thread.setDaemon(true);
                thread.start();
                AlertBox.showRunningCrawler(crawler, alert);

            }
        }
    }
}
