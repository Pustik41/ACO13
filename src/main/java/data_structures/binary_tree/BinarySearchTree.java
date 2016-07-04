package data_structures.binary_tree;


import java.util.*;

/**
 * Created by gorobec on 02.07.16.
 */
public class BinarySearchTree<E> extends AbstractSet<E> implements NavigableSet<E>, Set<E>, Iterable<E> {

    private Node<E> root;
    private int size;
    private Comparator<? super E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
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

        if( comparator != null){
            // todo search with comparator
            // search with Comparable
        } else {

            if(o == null) throw new NullPointerException();

            Node<E> iterator = root;
            Comparable<? super E> comparable = (Comparable<? super E> ) o;
            int compare;

            while (iterator != null){
                compare = comparable.compareTo(iterator.value);
                if(compare > 0) iterator = iterator.rightChild;
                else if(compare < 0) iterator = iterator.leftChild;
                else return true;
            }
        }
        return false;
    }

    @Override
    public E lower(E e) {
        return null;
    }

    @Override
    public E floor(E e) {
        return null;
    }

    @Override
    public E ceiling(E e) {
        return null;
    }

    @Override
    public E higher(E e) {
        return null;
    }

    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyBinaryTreeIterator<>();
    }

    @Override
    public NavigableSet<E> descendingSet() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        return null;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return null;
    }

    @Override
    public E first() {
        if(isEmpty()) throw new NoSuchElementException("size == 0");
        Node<E> iter = root;
        return  findLeft(iter);
    }

    private E findLeft(Node<E> iter) {
        return iter.leftChild !=  null ? findLeft(iter.leftChild) : iter.value;
    }

    @Override
    public E last() {
        if(isEmpty()) throw new NoSuchElementException("size == 0");
        Node<E> iter = root;
        return  findRight(iter);
    }

    private E findRight(Node<E> iter) {
        return iter.rightChild !=  null ? findRight(iter.rightChild) : iter.value;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {

        if(root == null){
            root = new Node<>(e);
            size++;
            return true;
        }

        if(comparator != null){
//            todo compare with comparator
        } else if(e != null) {

            @SuppressWarnings("unchecked")
            Comparable<? super E> eComparable = (Comparable<? super E>) e;

            Node<E> iter = root;
            Node<E> parent;
            int compareResult;

            do {
                parent = iter;
                compareResult = eComparable.compareTo(iter.value);

                if (compareResult > 0) {
                    iter = iter.rightChild;
                } else if (compareResult < 0) {
                    iter = iter.leftChild;
                } else {
                    return false;
                }
            } while (iter != null);

            if(compareResult > 0){
                parent.rightChild = new Node<>(e, parent);
            } else {
                parent.leftChild = new Node<>(e, parent);
            }

            size++;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private static class Node<T> {

        T value;
        Node<T> parent;
        Node<T> leftChild;
        Node<T> rightChild;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private class MyBinaryTreeIterator<E> implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
