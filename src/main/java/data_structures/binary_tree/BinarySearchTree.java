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
        search = findNode(o);
        return search != null;
    }

    private Node<E> findNode(Object o) {
        if(o == null) throw new NullPointerException();
        Node<E> iterator = root;
        int compare;
        while (iterator != null){
            compare = canCompare((E) o, iterator.value);
            if(compare > 0) iterator = iterator.rightChild;
            else if(compare < 0) iterator = iterator.leftChild;
            else return iterator;
        }
        return null;
    }

    @Override
    public E lower(E e) {

        if(!isEmpty() && e != null) {

            Node<E> element = root;
            Node<E> parent = null;
            int compareResult;

            while (element != null){

                compareResult = canCompare(e, element.value);

                if(compareResult > 0){
                    parent = element;
                    element = element.rightChild;
                } else {
                    element = element.leftChild;
                }
            }

            return parent != null ? parent.value : null;
        }

        return null;
    }

    @Override
    public E floor(E e) {

        if(!isEmpty() && e != null) {

            Node<E> element = root;
            Node<E> parent = null;
            int compareResult;

            while (element != null) {

                compareResult = canCompare(e, element.value);

                if (compareResult == 0) {
                    return element.value;
                } else if (compareResult > 0) {
                    parent = element;
                    element = element.rightChild;
                } else {
                    element = element.leftChild;
                }
            }

            return parent != null ? parent.value : null;
        }

        return null;
    }

    @Override
    public E ceiling(E e) {

        if(!isEmpty() && e != null) {

            Node<E> element = root;
            Node<E> parent = null;
            int compareResult;

            while (element != null){

                compareResult = canCompare(e, element.value);

                if(compareResult == 0) {
                    return element.value;
                } else if(compareResult > 0){
                    element = element.rightChild;
                } else {
                    parent = element;
                    element = element.leftChild;
                }
            }

            return parent != null ? parent.value : null;
        }

        return null;
    }

    @Override
    public E higher(E e) {

        if(!isEmpty() && e != null) {

            Node<E> element = root;
            Node<E> parent = null;
            int compareResult;

            while (element != null){

                compareResult = canCompare(e, element.value);

                if(compareResult >= 0){
                    element = element.rightChild;
                } else {
                    parent = element;
                    element = element.leftChild;
                }
            }

            return parent != null ? parent.value : null;
        }

        return null;
    }

    @Override
    public E pollFirst() {

        if(!isEmpty()) {

            Node<E> delNode;
            Node<E> iter  = root;

            do{
                delNode = iter;
                iter = iter.leftChild;
            }while (iter != null);

            return remove(delNode.value) ? delNode.value : null;

        }
        return null;
    }

    @Override
    public E pollLast() {

        if(!isEmpty()) {

            Node<E> delNode;
            Node<E> iter  = root;

            do{
                delNode = iter;
                iter = iter.rightChild;
            }while (iter != null);

            return remove(delNode.value) ? delNode.value : null;
        }

        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyBinaryTreeIterator<>(root);
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
        return comparator != null ? comparator : null;
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

        Object[] array = new Object[size];
        int count = 0;

        Iterator iterator = iterator();

        while (iterator.hasNext()){
            array[count++] = iterator.next();
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        int count = 0;
        Iterator iterator = iterator();

        if(a.length < size){
             a = (T[]) new Object[size];
        }

        while (iterator.hasNext()){
            try {
            a[count++] = (T) iterator.next();
            }catch (ArrayStoreException ex){
            throw new ArrayStoreException();
            }
        }

        return a;
    }

    @Override
    public boolean add(E e) {

            if (root == null) {
                canCompare(e, e);
                root = new Node<>(e);
                size++;
                return true;
            } else {

                Node<E> iterator = root;
                Node<E> parent;
                int compareResult;

                do {
                    parent = iterator;
                    compareResult = canCompare(e, iterator.value);
                    if (compareResult > 0) {
                        iterator = iterator.rightChild;
                    } else if (compareResult < 0) {
                        iterator = iterator.leftChild;
                    } else {
                        return false;
                    }
                } while (iterator != null);

                if (compareResult > 0) {
                    parent.rightChild = new Node<>(e, parent);
                } else {
                    parent.leftChild = new Node<E>(e, parent);
                }
                size++;
                return true;

            }
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

            if(current == root) root = successor;

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

            if(successor.rightChild != null) {
                successor.parent.leftChild = successor.rightChild;
                successor.rightChild.parent = successor.parent;
            } else {
                successor.parent.leftChild = null;
            }

            successor.rightChild = current.rightChild;
            current.rightChild.parent = successor;
        }
        return successor;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        Collection<E> delAll = null;

        try {
            delAll = (Collection<E>) c;
        }catch (ClassCastException ex){
           throw new ClassCastException();
        }

        if(delAll != null && !isEmpty()) {
            for (E e : delAll) {
                if(findNode(e) == null) return false;
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        if(c != null) {
            for (E e : c) {
                add(e);
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
//        NOP
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        Collection<E> delAll = null;

        try {
            delAll = (Collection<E>) c;
        }catch (ClassCastException ex){
            throw new ClassCastException();
        }

        if(delAll != null && !isEmpty()) {
            for (E e : delAll) {
                remove(e);
            }
            return true;
        }

        return false;
    }

    @Override
    public void clear() {
        while (root != null){
            remove(root.value);
        }
    }

    static class Node<E> {

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

        private Node<E> next;

        public MyBinaryTreeIterator(Node<E> root){
            next = root;
            if(next == null)
                return;
            while (next.leftChild != null)
                next = next.leftChild;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {

            if(!hasNext()) throw new NoSuchElementException();

            Node retNode = next;

            if(next.rightChild != null){
                next = next.rightChild;
                while (next.leftChild != null)
                    next = next.leftChild;
                return (E) retNode.value;

            }else while(true){
                if(next.parent == null){
                    next = null;
                    return (E) retNode.value;
                }
                if(next.parent.leftChild == next){
                    next = next.parent;
                    return (E) retNode.value;
                }
                next = next.parent;
            }
        }
    }
}