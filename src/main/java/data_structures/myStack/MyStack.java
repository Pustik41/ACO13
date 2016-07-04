package data_structures.myStack;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public interface MyStack<E> {


    public void push(E item);

    public E pop();

    public E peek();

    public boolean empty();

    public int search(Object o);


}
