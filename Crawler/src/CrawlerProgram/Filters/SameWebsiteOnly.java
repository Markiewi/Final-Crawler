
package CrawlerProgram.Filters;

import CrawlerProgram.Crawler.WebPage;

public class SameWebsiteOnly implements IFilter {
    public String sameUrl;

    public SameWebsiteOnly(String sameUrl) {
        this.sameUrl = sameUrl;
    }

    @Override
    public boolean include(WebPage webPage) {
        return webPage.url.startsWith(sameUrl);
    }
}
