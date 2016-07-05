package data_structures.my_stack;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayStack<E> implements MyStack<E> {

    private Object[] array;
    private int top;

    public MyArrayStack(int size) {
        array = new Object[size];
    }

    @Override
    public void push(E item) {

        if(top == array.length) {
            System.out.println("Stack is full");
            return;
        }

        array[top++] = item;
    }

    @Override
    public E pop() {

        E delElement = null;

        if(!empty()){
            top--;
            delElement = (E) array[top];
            array[top] = null;
        }

        return delElement;
    }

    @Override
    public E peek() {
        return !empty() ? (E) array[top - 1] : null;
    }

    @Override
    public boolean empty() {
        return top == 0;
    }

    @Override
    public int search(Object o) {

        if(o == null){

            for (int i = top - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }

        } else {

            for (int i = top - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

}