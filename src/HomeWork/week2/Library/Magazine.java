package HomeWork.week2.Library;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Magazine extends Prints {

    public Magazine(String title, Author author, int year, int numOfPage) {
        super(title, author, year, numOfPage);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Redactor - %s;", getAuthor().toString());
    }
}
