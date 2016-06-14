package HomeWork.week2.Library.base;

/**
 * Created by dfsdfsddfsdf on 10.06.16.
 */
public class Prints {

    private String title;
    private Author author;
    private int year;
    private int numOfPage;
    private int amount = 0;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {

        if(amount == 1 || amount == -1) {
            this.amount += amount;
        }
    }

    @Override
    public String toString() {
        return String.format("Title - %s, Published year - %d, Number of page - %d, ", title, year, numOfPage);
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;

        if(obj.getClass() == this.getClass()) {

            Prints tmp = (Prints) obj;

            return this.title.equals(tmp.title) &&
                    this.year == tmp.year &&
                    this.numOfPage == tmp.numOfPage &&
                    this.author.equals(tmp.author);
        }

        return false;
    }
}
