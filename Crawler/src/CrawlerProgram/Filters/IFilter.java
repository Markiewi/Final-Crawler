package CrawlerProgram.Filters;
import CrawlerProgram.Crawler.WebPage;

public interface IFilter {
    boolean include(WebPage webPage);
}
