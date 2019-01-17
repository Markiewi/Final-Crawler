package CrawlerProgram.Crawler;

public class Link {
    final public String URL;
    final public Integer deep;

    @Override
    public String toString() {
        return "Link{" +
                "URL='" + URL + '\'' +
                ", deep=" + deep +
                '}';
    }

    public Link(String URL, Integer deep) {
        this.URL = URL;
        this.deep = deep;
    }
}
