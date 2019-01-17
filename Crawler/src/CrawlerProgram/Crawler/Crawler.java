
package CrawlerProgram.Crawler;

import CrawlerProgram.Filters.IFilter;
import javafx.concurrent.Task;

import java.io.IOException;

public class Crawler extends Task<Void> {
    private WebPageStorage storage;
    public WebPagesRepository repository;
    private IFilter filter;
    private Integer limit, deep;
    private String startURL;
    public String path;
    public Crawler(IFilter filter, Integer deep, Integer limit, String startURL, String path) {
        storage = new WebPageStorage();
        repository = new WebPagesRepository();
        this.filter = filter;
        this.limit = limit;
        this.deep = deep;
        this.startURL = startURL;
        this.path= path;
    }

    public Void call() {
        storage.linksQueue.addFirst(new Link(startURL, 0));
        int i = 0;
        while (!this.isCancelled() && !storage.linksQueue.isEmpty() && i < limit) {

            Link link = storage.linksQueue.remove();
            if (!storage.links.contains(link.URL)) {
                try {
                    WebPage page = new WebPage(link.URL, org.jsoup.Jsoup.connect(link.URL).get(), link.deep);
                    System.out.println(link.URL);
                    if (filter.include(page)) {
                        repository.History.add(page);
                    }

                    page.getLinks(storage.linksQueue, deep);
                    storage.links.add(link.URL);
                    i++;
                } catch (IOException ioe) {
                    System.out.println("Cant connect to website");
                }

            }
        }
        repository.Writer(path);
        return null;
    }


}