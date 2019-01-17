
package CrawlerProgram.Crawler;

import CrawlerProgram.Crawler.WebPage;
import CrawlerProgram.GUI.AlertBox;

import java.io.*;
import java.util.HashSet;
import java.util.Random;


public class WebPagesRepository {
    public HashSet<WebPage> History;

    public WebPagesRepository() {
        History = new HashSet<>();
    }

    public void Writer(String localization) {
        try {
            for (WebPage webPage : History) {
                File file = new File(localization + File.separator + webPage.url.replaceAll("[^a-zA-Z0-9]+", " ") + ".html");
                PrintWriter writer = new PrintWriter(file, "UTF-8");
                writer.write(webPage.doc.html());
                writer.flush();
                writer.close();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Pliku nie znaleziono");
        } catch (UnsupportedEncodingException e) {
            System.out.println("zly sposob kodowania");
        }
    }


}
