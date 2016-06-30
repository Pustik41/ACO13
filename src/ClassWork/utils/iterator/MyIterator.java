package ClassWork.utils.iterator;

import ClassWork.utils.node.Node;

import java.util.Iterator;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class MyIterator<T> implements Iterator<T>  {

        Node<T> iterator;
        Node<T> head;

        public MyIterator(){
            iterator = new Node<>();
            iterator.setNext(head);
        }

        @Override
        public boolean hasNext() {
            return iterator.getNext() != null;
        }

        @Override
        public T next() {
            iterator = iterator.getNext();
            return iterator.getValue();
        }

}
