
package src;

public class RedBlackTree<T> {
    private Node<T> root;

    public RedBlackTree(T data) {
        this.root = new Node<T>(data, Color.BLACK);
    }

    public Node<T> getRoot() {
        return this.root;
    }
}
