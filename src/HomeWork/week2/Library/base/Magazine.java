package HomeWork.week2.Library.base;

/**
 * Created by dfsdfsddfsdf on 13.06.16.
 */
public class Magazine extends Prints {

    private int numMagazine;

    public Magazine(String title, Author author, int year, int numOfPage, int numMagazine) {
        super(title, author, year, numOfPage);

        if(numMagazine > 0){this.numMagazine = numMagazine;}
        else {this.numMagazine = 1;}
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Number - %d, Redactor - %s", numMagazine, getAuthor().toString());
    }

    @Override
    public boolean equals(Object obj) {

        if(super.equals(obj)){

           Magazine tmp = (Magazine) obj;

           return this.numMagazine == tmp.numMagazine;
       }

        return false;
    }
}
