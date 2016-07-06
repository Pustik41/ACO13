package data_structures.my_queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayQueue<E> implements Queue<E> {
// Object[] -> E[]
    private E[] array;
    private int last;
    private int head;
    private int size;

    public MyArrayQueue(int size) {
        array = (E[])new Object[size];
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
        // NOP
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public E[] toArray() {
        // NOP
        return (E[])new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // NOP
        return null;
    }

    @Override
    public boolean remove(Object o) {
        // NOP
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

        for (int i = 0; i < last ; i++) {
            array[i] = null;
        }

        last = 0;
    }

    @Override
    public boolean add(E e) {

        if(offer(e)) {
            return true;
        }

        throw new IllegalStateException();
    }

    @Override
    public boolean offer(E e) {

        if(size != array.length - 1){

            if(size == 0){
                array[head] = e;
                last++;
            } else {
                if(last == array.length - 1){
                    array[last] = e;
                    last = 0;
                } else {
                    array[last] = e;
                    last++;
                }
            }

            size++;
            return true;
        }

        return false;
    }

    @Override
    public E remove() {

        E delElement = poll();

        if(delElement != null) return delElement;

        throw new NoSuchElementException();
    }

    @Override
    public E poll() {

        if(!isEmpty()) {
            E delElement = array[head];
            array[head] = null;

            if(head == array.length -1){
                head = 0;
            } else {
                head++;
            }

            size--;
            return delElement;
        }

        return null;
    }

    @Override
    public E element() {

        if(!isEmpty()) {
            return array[0];
        }

        throw new NoSuchElementException();
    }

    @Override
    public E peek() {

        if(!isEmpty()) {
            return array[0];
        }

        return null;
    }
}