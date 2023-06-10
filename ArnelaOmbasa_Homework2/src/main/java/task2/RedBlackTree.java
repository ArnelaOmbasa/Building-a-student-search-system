package task2;

public class RedBlackTree <Key extends Comparable<Key>, Value> {
    // Implement the required properties of a red-black tree
    private Node<Key, Value> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;


    // track the number of iterations needed for the get() operation to complete
    public int numSteps = 0;

    public Value get(Key key) {
        // implement the actual logic (remove next line)
        Node<Key, Value> x = root;
        numSteps = 0;

        while (x != null) {
            numSteps++;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    private Node<Key, Value> rotateLeft(Node<Key, Value> h) {
        Node<Key, Value> x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node<Key, Value> rotateRight(Node<Key, Value> h) {
        Node<Key, Value> x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node<Key, Value> h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

    private boolean isRed(Node<Key, Value> x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public void put(Key key, Value value) {
        // implement the actual logic
        root = put(root, key, value);
    }
    private Node<Key, Value> put(Node<Key, Value> h, Key key, Value value) {
        if (h == null) {
            return new Node<Key, Value>(key, value, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        return h;
    }
    public int countRedLinks() {
        return countRedLinks(root);
    }

    private int countRedLinks(Node<Key, Value> node) {
        if (node == null) return 0;
        int count = 0;
        if (isRed(node.left)) count++;
        if (isRed(node.right)) count++;
        return count + countRedLinks(node.left) + countRedLinks(node.right);
    }

}




