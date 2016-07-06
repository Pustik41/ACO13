package data_structures.binary_tree;


import data_structures.node.Node;

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

        Node<E> search = null;

        if(comparator != null){
//            todo search with comparator
//            search with Comparable
        } else {

            search = findNode(o);

        }
        return search != null;
    }

    private Node<E> findNode(Object o) {
        if(o == null) throw new NullPointerException();
        Node<E> iterator = root;
        int compare;
        @SuppressWarnings("unchecked")
        Comparable<? super E> comparable = (Comparable<? super E>) o;
        while (iterator != null){
            compare = comparable.compareTo(iterator.value);
            if(compare > 0) iterator = iterator.rightChild;
            else if(compare < 0) iterator = iterator.leftChild;
            else return iterator;
        }
        return null;
    }

    @Override
    public E lower(E e) {

        if(!isEmpty() && e != null) {

            if(comparator != null){
//            todo compare with comparator
            } else {

                Node<E> element = root;
                Node<E> parent;


                Comparable<? super E> eComparable = (Comparable<? super E>) e;
                int compareResult;

                do{
                    parent = element;
                    compareResult = eComparable.compareTo(element.value);

                    if(compareResult > 0){
                        element = element.rightChild;

                    } else {
                        element = element.leftChild;
                    }

                }while (element != null);

                compareResult = eComparable.compareTo(parent.value);
                if(compareResult < 0 ){
                    if(eComparable.compareTo(parent.parent.value) > 0) return parent.parent.value;
                    return null;
                }

                return parent.value;
            }
        }

        return null;
    }

    @Override
    public E floor(E e) {

        if(!isEmpty() && e != null) {

            if(comparator != null){
//            todo compare with comparator
            } else {

                Node<E> element = root;
                Node<E> parent;
                Comparable<? super E> eComparable = (Comparable<? super E>) e;
                int compareResult;

                do{
                    parent = element;
                    compareResult = eComparable.compareTo(element.value);

                    if(compareResult == 0){
                        return element.value;
                    } else if(compareResult > 0) {
                        element = element.rightChild;
                    } else {
                        element = element.leftChild;
                    }


                }while (element != null);

                compareResult = eComparable.compareTo(parent.value);
                if(compareResult < 0 ){
                    if(eComparable.compareTo(parent.parent.value) > 0) return parent.parent.value;
                    return null;
                }

                return parent.value;
            }
        }

        return null;
    }

    @Override
    public E ceiling(E e) {
        //        TODO
        return null;
    }

    @Override
    public E higher(E e) {
        //        TODO
        return null;
    }

    @Override
    public E pollFirst() {
        //        TODO
        return null;
    }

    @Override
    public E pollLast() {
        //        TODO
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyBinaryTreeIterator<>();
    }

    @Override
    public NavigableSet<E> descendingSet() {
//        NOP
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
//        NOP
        return null;
    }

    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
//        NOP
        return null;
    }

    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
//        NOP
        return null;
    }

    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
//        NOP
        return null;
    }

    @Override
    public Comparator<? super E> comparator() {
        //        TODO
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
//        NOP
        return null;
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
//        NOP
        return null;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
//        NOP
        return null;
    }

    @Override
    public E first() {
        if(isEmpty()) throw  new NoSuchElementException("size == 0");
        return findLeft(root);
    }

    private E findLeft(Node<E> iter) {
        return iter.leftChild != null ? findLeft(iter.leftChild) : iter.value;
    }

    @Override
    public E last() {
        if(isEmpty()) throw  new NoSuchElementException("size == 0");
        return findRight(root);
    }

    private E findRight(Node<E> iter) {
        return iter.rightChild != null ? findRight(iter.rightChild) : iter.value;
    }

    @Override
    public Object[] toArray() {
        //        TODO
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        //        TODO
        return null;
    }

    @Override
    public boolean add(E e) {

        if(root == null){
            canCompare(e, e);
            root = new Node<>(e);
            size++;
            return true;
        } else if(comparator != null){
//            todo compare with comparator
        } else {
            @SuppressWarnings("unchecked")
            Comparable<? super E> eComparable = (Comparable<? super E>) e;

            Node<E> iterator = root;
            Node<E> parent;
            int compareResult;

            do {
                parent = iterator;
                compareResult = eComparable.compareTo(iterator.value);
                if (compareResult > 0) {
                    iterator = iterator.rightChild;
                } else if (compareResult < 0) {
                    iterator = iterator.leftChild;
                } else {
                    return false;
                }
            } while (iterator != null);

            if(compareResult > 0){
                parent.rightChild = new Node<>(e, parent);
            } else {
                parent.leftChild = new Node<E>(e, parent);
            }
            size++;
            return  true;

        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private int canCompare(E element1, E element2) {
        return comparator != null ? comparator.compare(element1, element2) :
                ((Comparable<? super E>)element1).compareTo(element2);
    }

    @Override
    public boolean remove(Object o) {

        Node<E> current = findNode(o);
        if(current == null) return false;
        size--;
        if(current.rightChild == null && current.leftChild == null){ // doesn't have children
            if(current == root) root = null;
            else if(current == current.parent.leftChild) current.parent.leftChild = null;
            else  current.parent.rightChild = null;

            current.parent = null;
        } else if (current.rightChild == null){ // has only left child
            if(current == root){
                root = current.leftChild;
                root.parent = null;

            }
            else if(current == current.parent.leftChild) {
                current.parent.leftChild = current.leftChild;
                current.leftChild.parent = current.parent;
                current.parent = null;
            }
            else {
                current.parent.rightChild = current.leftChild;
                current.leftChild.parent = current.parent;
                current.parent = null;
            }
            current.leftChild = null;

        } else if (current.leftChild == null) { // has only right child
            if (current == root) {
                root = current.rightChild;
                root.parent = null;

            } else if (current == current.parent.leftChild) {
                current.parent.leftChild = current.rightChild;
                current.rightChild.parent = current.parent;
                current.parent = null;
            } else {
                current.parent.rightChild = current.rightChild;
                current.rightChild.parent = current.parent;
                current.parent = null;
            }
            current.rightChild = null;

        } else {
            Node<E> successor = findSuccessor(current);
            successor.leftChild = current.leftChild;
            current.leftChild.parent = successor;
            current.leftChild = null;
            current.rightChild = null;
        }

        return true;
    }

    private Node<E> findSuccessor(Node<E> current) {
        Node<E> successor = current.rightChild;

        while (successor.leftChild != null){
            successor = successor.leftChild;
        }
        if(successor.parent !=  current){
            successor.parent.leftChild = successor.rightChild;
            successor.rightChild.parent = successor.parent;
            successor.rightChild = current.rightChild;
            current.rightChild.parent = successor;
        }
        return successor;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        //        TODO
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        //        TODO
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
//        NOP
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
//        TODO

    }

    private static class Node<E> {

        E value;
        Node<E> parent;
        Node<E> leftChild;
        Node<E> rightChild;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private class MyBinaryTreeIterator<E> implements Iterator<E> {
        //        TODO

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