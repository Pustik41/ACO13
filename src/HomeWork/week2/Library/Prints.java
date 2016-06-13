package HomeWork.week2.Library;

import ClassWork.utils.MyDate;

/**
 * Created by dfsdfsddfsdf on 10.06.16.
 */
public class Prints {

    private String title;
    private Author author;
    private int year;
    private int numOfPage;

    public Prints(String title, Author author, int year, int numOfPage) {
        this.title = title;
        this.year = year;
        this.numOfPage = numOfPage;

        if(author == null) author = new Author("Author", "unknown");
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    @Override
    public String toString() {
        return String.format("Title - %s, Published year - %d, Number of page - %d, ", title, year, numOfPage);
    }
// todo 'equals()' should check the class of its parameter
    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        Prints tmp = (Prints) obj;

        return this.title.equals(tmp.title) && this.year == tmp.year && this.numOfPage == tmp.numOfPage && this.author.equals(tmp.author);
    }
}
