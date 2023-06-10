package task2;

import task1.Student;

public class Node<Key extends Comparable<Key>, Value> {

    // Implement the required properties of a red-black tree node
    public Key key;
    public Value value;
    public Node<Key, Value> left, right;
    public boolean color;

    /* Node constructor */
    public Node(Key key, Value value, boolean color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }


}
