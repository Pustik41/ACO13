package design_patterns.state_observer;

/**
 * Created by gorobec on 05.06.16.
 */
public class Node {

    public Node next;
   public Node previous;
    Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node(Node next, Node previous, Object value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public Node(Node previous, Object value) {
        this.previous = previous;
        this.value = value;
    }
}
