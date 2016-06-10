package HomeWork.week2.Library;

/**
 * Created by dfsdfsddfsdf on 10.06.16.
 */
public class Author {

    private String authorName;
    private String authorSurName;

    public Author(String authorName, String authorSurName) {
        this.authorName = authorName;
        this.authorSurName = authorSurName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurName() {
        return authorSurName;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || obj.getClass() != Author.class) return false;

        Author tmp = (Author) obj;
        return this.authorName.equals(tmp.authorName) && this.authorSurName.equals(tmp.authorSurName);
    }
}
