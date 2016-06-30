package ClassWork.utils.myQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyArrayQueue<E> implements Queue<E> {

    private Object[] array;
    private int last;

    public MyArrayQueue(int size) {
        array = new Object[size];
    }


    @Override
    public int size() {
        return last;
    }

    @Override
    public boolean isEmpty() {
        return last == 0;
    }

    @Override
    public boolean contains(Object o) {

        if (o == null) {

            for (int i = 0; i < last; i++) {
                if (array[i] == null) {
                    return true;
                }
            }

        } else {

            for (int i = 0; i < last; i++) {
                if (o.equals(array[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        // NOP
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // NOP
        return null;
    }

    @Override
    public boolean remove(Object o) {

        if(o == null){

            for (int i = 0; i < last ; i++) {
                if(array[i] == null){
                    System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                    last--;
                    return  true;
                }
            }

        } else {

            for (int i = 0; i < last; i++) {
                if (o.equals(array[i])) {
                    System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                    last--;
                    return true;
                }
            }
        }

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

        if(last != array.length){
            array[last++] = e;
            return true;
        }

        throw new IllegalStateException();
    }

    @Override
    public boolean offer(E e) {

        if(last != array.length){
            array[last++] = e;
            return true;
        }

        return false;
    }

    @Override
    public E remove() {

        if(!isEmpty()) {
            E element = (E) array[0];
            System.arraycopy(array, 1, array, 0, --last);
            return element;
        }

        throw new NoSuchElementException();
    }

    @Override
    public E poll() {

        if(!isEmpty()) {
            E element = (E) array[0];
            System.arraycopy(array, 1, array, 0, --last);
            return element;
        }

        return null;
    }

    @Override
    public E element() {

        if(!isEmpty()) {
            return (E) array[0];
        }

        throw new NoSuchElementException();
    }

    @Override
    public E peek() {

        if(!isEmpty()) {
            return (E) array[0];
        }

        return null;
    }
}
