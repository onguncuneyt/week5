public class Book implements Comparable<Book> {

    private String name;
    private int numberOfPages;
    private String author;
    private String releaseDate;

    public Book(String name, int numberOfPages, String author, String releaseDate) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.releaseDate = releaseDate;
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + name + '\'' +
                ", pageCount=" + numberOfPages +
                ", author='" + author + '\'' +
                ", publishDate='" + releaseDate + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
