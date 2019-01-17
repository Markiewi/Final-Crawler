
package CrawlerProgram.Filters;

import CrawlerProgram.Crawler.WebPage;

public class EmptyFilter implements IFilter {
    @Override
    public boolean include(WebPage webPage) {
        return true;
    }
}
