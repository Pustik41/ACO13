package ClassWork.utils.node;

/**
 * Created by dfsdfsddfsdf on 30.06.16.
 */
public class Node<T> {

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

    public Node(Node<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public Node(T value, Node<T> previous) {
        this.previous = previous;
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
