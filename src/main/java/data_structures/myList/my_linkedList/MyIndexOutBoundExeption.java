package data_structures.myList.my_linkedList;

/**
 * Created by zhabenya on 25.06.16.
 */
public class MyIndexOutBoundExeption extends RuntimeException {

    public MyIndexOutBoundExeption() {
    }

    public MyIndexOutBoundExeption(String message) {
        super(message);
    }
}
