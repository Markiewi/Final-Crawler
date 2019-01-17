package CrawlerProgram.Crawler;
import CrawlerProgram.Crawler.Link;

import java.util.HashSet;
import java.util.LinkedList;

public class WebPageStorage {
    public HashSet<String> links;
    public LinkedList<Link> linksQueue;

    public WebPageStorage() {
        links = new HashSet<String>();
        linksQueue = new LinkedList<Link>();
    }
}
