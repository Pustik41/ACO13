package HomeWork.week2.Library.base;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Book extends Prints {

    public Book(String title, Author author, int year, int numOfPage) {
        super(title, author, year, numOfPage);
    }

    @Override
    public String toString() {
       return super.toString() + String.format("Author - %s, Amount - %d;\n", getAuthor().toString(), getAmount());
    }
}
