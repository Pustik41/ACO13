package data_structures.my_queue;

import data_structures.node.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyLinkedQueue<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedQueue() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
//      NOP
        return false;
    }

    @Override
    public Iterator<E> iterator() {
//      NOP
        return null;
    }

    @Override
    public Object[] toArray() {
//      NOP
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
//      NOP
        return null;
    }

    @Override
    public boolean remove(Object o) {
        //      NOP
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
//      NOP
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
//      NOP
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
//      NOP
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
//      NOP
        return false;
    }

    //    todo run through all structure and clear each node
    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    @Override
    public boolean add(E e) {

        if(first == null){
            first = last = new Node<E>(e);
            size++;
            return true;
        } else {
            Node<E> newNode = new Node<>(last, e);
            last.setNext(newNode);
            last = newNode;
            size++;
            return true;
        }
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {

        if(!isEmpty()) {
            Node<E> retFirst = first;
            first = first.getNext();
            size--;
            return retFirst.getValue();
        }

        return null;
    }

    @Override
    public E poll() {
        return remove();
    }

    @Override
    public E element() {
        return size != 0 ? first.getValue() : null;
    }

    @Override
    public E peek() {
        return element();
    }
}