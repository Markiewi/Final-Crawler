
package CrawlerProgram.Filters;

import CrawlerProgram.Crawler.WebPage;

public class SameStringFilterOnSameWebsiteOnly implements IFilter {
    private String wanted;
    private String sameURL;

    public SameStringFilterOnSameWebsiteOnly(String wanted, String sameURL) {
        this.wanted = wanted;
        this.sameURL = sameURL;
    }

    @Override
    public boolean include(WebPage webPage) {
        return (new SameStringFilter(wanted).include(webPage) && new SameWebsiteOnly(sameURL).include(webPage));
    }


}

