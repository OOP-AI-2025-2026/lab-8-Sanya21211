package ua.opnu;

import java.util.Objects;

public class BookData implements Comparable<BookData> {

    private String title;
    private String author;
    private int reviews;
    private double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = Math.max(0, reviews);
        this.total  = total;
    }

    public double getRating() {
        return reviews == 0 ? 0.0 : total / reviews;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public int getReviews()   { return reviews; }
    public double getTotal()  { return total; }

    @Override
    public int compareTo(BookData other) {
        // 1) за рейтингом: більший рейтинг -> менше (тобто навпаки звичному)
        int byRatingDesc = Double.compare(other.getRating(), this.getRating());
        if (byRatingDesc != 0) return byRatingDesc;

        // 2) якщо рейтинги рівні — за назвою у звичайному порядку
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                ", total=" + total +
                ", rating=" + String.format("%.2f", getRating()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookData)) return false;
        BookData bookData = (BookData) o;
        return Objects.equals(title, bookData.title) &&
                Objects.equals(author, bookData.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}