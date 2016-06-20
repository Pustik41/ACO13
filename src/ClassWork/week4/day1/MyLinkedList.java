package ClassWork.week4.day1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by zhabenya on 18.06.16.
 */
public class MyLinkedList implements List {

    private Node head;
    private Node tail;
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
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object object) {

        if(head == null){
            head = tail = new Node(object);
            size++;
            return true;
        }

        Node newNode = new Node(tail, object);
        tail.next = newNode;
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }
//todo Exeption
    @Override
    public Object get(int index) {

        Node iter = findNode(index);

        return iter.value;
    }

    private Node findNode(int index) {

        if(index > size || index < 0){
            System.exit(1);
        }

        Node iter = head;

        for (int i = 1; i <= index ; i++) {
            iter = iter.next;
        }

        return iter;
    }

    @Override
    public Object set(int index, Object element) {

        Node iter = findNode(index);
        Object toReturn = iter.value;

        iter.value = element;

        return toReturn;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {

        Node iter = findNode(index);

        if(iter == head){
            head = iter.next;
            if(iter.next == null){
                head = tail = null;
            }
            else{
                head.previos = null;
                iter.next = null;
            }
        }else  if(iter == tail){
            tail = iter.previos;
            tail.next = null;
            iter.previos = null;
            size--;
        }else {
            iter.previos.next = iter.next;
            iter.next.previos = iter.previos;
            iter.next = null;
            iter.previos = null;
        }

        size--;
        return iter.value;
    }

    @Override
    public int indexOf(Object o) {

        Node iter = head;

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
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private static class Node {

        private Node previos;
        private Node next;
        private Object value;

        public Node(Object value) {
            this.value = value;
        }

        public Node(Node previos, Object value) {
            this.previos = previos;
            this.value = value;
        }

        public Node(Node previos, Node next, Object value) {
            this.previos = previos;
            this.next = next;
            this.value = value;
        }
    }
}
