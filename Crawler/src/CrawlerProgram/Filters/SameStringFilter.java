package CrawlerProgram.Filters;

import CrawlerProgram.Crawler.WebPage;

public class SameStringFilter implements IFilter {
    private String wanted;

    public SameStringFilter(String wanted) {
        this.wanted = wanted;
    }

    @Override
    public boolean include(WebPage webPage) {
        return (webPage.doc.text().contains(wanted) || webPage.doc.text().toLowerCase().contains(wanted));
    }
}
