    package CrawlerProgram.Crawler;

import CrawlerProgram.Crawler.Link;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;

public class WebPage {
    final public String url;
    final public Document doc;
    final public Integer deep;


    public WebPage(String url, Document doc, Integer deep) {
        this.url = url;
        this.doc = doc;
        this.deep = deep;

    }

//    public String[] clear() {
//        return doc.text().split(" ");
//
//    }

    public void getLinks(LinkedList<Link> linksQueue, Integer maxDeep) {
        if (maxDeep > deep) {
            Elements elements = doc.select("a[href]");
            for (Element element : elements) {
                if (element.attr("abs:href") != "") linksQueue.addLast(new Link(element.attr("abs:href"), deep + 1));
            }

        }
    }
}