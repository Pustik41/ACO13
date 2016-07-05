package data_structures.my_stack;

import data_structures.node.Node;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyLinkedStack<E> implements MyStack<E> {

    private Node<E> top;

    public MyLinkedStack() {
    }

    @Override
    public void push(E item) {

        if(top == null){
            top = new Node<>(null, item);
        } else {
            top = new Node<>(top, item);
        }
    }

    @Override
    public E pop() {

        if(top == null) return null;

        Node<E> retTop = top;
        top = top.getNext();

        return (E) retTop.getValue();
    }

    @Override
    public E peek() {
        return !empty() ? top.getValue() : null;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public int search(Object o) {

        int count = 0;
        Node<E> tmp = top;

        if(o == null){

            while (tmp != null){

                if(tmp.getValue() == null){
                    return count;
                }

                count++;
                tmp = tmp.getNext();
            }

        } else {

            while (tmp != null) {

                if (tmp.getValue().equals(o)) {
                    return count;
                }

                count++;
                tmp = tmp.getNext();
            }
        }

        return -1;
    }

}