package data_structures.myList.my_linkedList;

import java.util.*;

/**
 * Created by zhabenya on 18.06.16.
 */
public class MyLinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

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

        Node<T> iter = head;

        if (o == null) {
            while (iter != null) {
                if (iter.value == null) {
                    return true;
                }
                iter = iter.next;
            }
        } else {
            while (iter != null) {
                if (o.equals(iter.value)) {
                    return true;
                }
                iter = iter.next;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    @Override
    public T[] toArray() {

        T[] array = (T[]) new Object[size];
        Node<T> iter = head;

        for (int i = 0; i < size; i++) {
            array[i] = iter.value;
            iter = iter.next;
        }

        return array;
    }

    @Override
    public boolean add(Object o) {

        if(head == null){
            head = tail = new Node(o);
            size++;
            return true;
        }

        Node<T> newNode = new Node<>(tail, (T) o);
        tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        Node<T> remNode = new Node<>((T) o);
        Node<T> iter = head;

        if (o == null) {
            while (iter != null) {
                if (iter.value == null) {
                    delNode(iter);
                    return true;
                }
                iter = iter.next;
            }
        } else {
            while (iter != null) {
                if (remNode.value.equals(iter.value)) {
                    delNode(iter);
                    return true;
                }
                iter = iter.next;
            }
        }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {

        for (Object o : c) {
            add(o);
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {

        for (Object o : c) {
            add(index, (T) o);
            index++;
        }

        return true;
    }

    @Override
    public void clear() {

        if(!isEmpty()){

            while (tail != head){
                tail = tail.previous;
                tail.next = null;
            }

            head = tail = null;
            size = 0;
        }
    }

    @Override
    public T get(int index) {

        Node<T> iter = findNode(index);

        return iter.value;
    }

    private Node<T> findNode(int index) {

        if(index >= size || index < 0) {
            throw new MyIndexOutBoundExeption(String.valueOf(index));
        }

        Node<T> iter = head;

        for (int i = 0; i < index; i++) {
            iter = iter.next;
        }

        return iter;
    }

    @Override
    public T set(int index, T element) {

        Node<T> iter = findNode(index);
        T toReturn = iter.value;

        iter.value = element;

        return toReturn;
    }

    @Override
    public void add(int index, T element) {

        if(index == size) {
            add(element);
            size();
            return;
        }

        Node<T> newAdd = new Node<>(element);

        if(index == 0 && size != 0){
            newAdd.next = head;
            head = newAdd;
            head.next.previous = head;
            size++;
            return;
        }

        Node<T> start = findNode(index - 1);
        Node<T> finish = start.next;

        finish.previous = newAdd;
        newAdd.next = finish;
        start.next = newAdd;
        newAdd.previous = start;
        size++;

    }

    @Override
    public T remove(int index) {

        Node<T> iter = findNode(index);

        return delNode(iter);
    }

    private T delNode(Node<T> iter){

        if(iter == head){
            head = iter.next;
            if(iter.next == null){
                head = tail = null;
            } else {
                head.previous = null;
                iter.next = null;
            }
        } else if(iter == tail){
            tail = iter.previous;
            tail.next = null;
            iter.previous = null;

        } else {
            iter.previous.next = iter.next;
            iter.next.previous = iter.previous;
            iter.previous = null;
            iter.next = null;
        }

        size--;
        return iter.value;
    }

    @Override
    public int indexOf(Object o) {

        Node<T> iter = head;

        if(o == null){
            for (int i = 0; i < size; i++) {
                if(iter.value == null) return i;
                iter = iter.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if(o.equals(iter.value)) return i;
                iter = iter.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {

        Node<T> iter = tail;

        if(o == null){
            for (int i = size - 1; i >= 0; i--) {
                if(iter.value == null) return i;
                iter = iter.previous;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if(o.equals(iter.value)) return i;
                iter = iter.previous;
            }
        }

        return -1;
    }

    @Override
    public ListIterator listIterator() {
//        NOP
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        //        NOP

        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {

        if(fromIndex < 0 || fromIndex >= size || toIndex >= size) throw new IndexOutOfBoundsException();
        if(fromIndex > toIndex) throw new IllegalArgumentException();

        List<T> retList = new LinkedList<>();
        Node<T> iter = findNode(fromIndex);

        while (fromIndex != toIndex){
            retList.add(iter.value);
            iter = iter.next;
            fromIndex++;
        }

        return retList;
    }

    @Override
    public boolean retainAll(Collection c) {

        List<T> list;
        int same = 0;
        Node<T> iter = head;
        Node<T> forDel;

        try {
            list = (MyLinkedList<T>) c;
        } catch (ClassCastException ex){
            throw new ClassCastException();
        }

        while (iter != null){

            forDel = iter;
            iter = iter.next;

            for (T t : list) {
                if(t.equals(forDel.value)) same++;
            }

            if(same == 0){
                remove(forDel.value);
            }

            same = 0;
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection c) {

        List<T> list;
        int saveSize = size;

        try {
            list = (MyLinkedList<T>) c;
        } catch (ClassCastException ex){
            throw new ClassCastException();
        }

        for (T t : list) {
            remove(t);
        }

        return saveSize > size;
    }

    @Override
    public boolean containsAll(Collection c) {

        List<T> list;

        try {
            list = (MyLinkedList<T>) c;
        } catch (ClassCastException ex){
            throw new ClassCastException();
        }

        for (T t : list) {
            if(!contains(t)) return false;
        }

        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        //        NOP
        return new Object[0];
    }

    private static class Node<T> {
        Node<T> next;
        Node<T> previous;
        T value;


        public Node(){
        }

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> next, Node<T> previous, T value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
        public Node(Node<T> previous, T value) {
            this.previous = previous;
            this.value = value;
        }
    }

    private class MyIterator implements Iterator{

        Node<T> iterator;

        public MyIterator(){
            iterator = new Node<>();
            iterator.next = head;
        }

        @Override
        public boolean hasNext() {
            return iterator.next != null;
        }

        @Override
        public T next() {
            iterator = iterator.next;
            return iterator.value;
        }
    }
}