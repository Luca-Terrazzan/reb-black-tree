package src;

public class RedBlackTree<T extends Comparable<T>> {
    private Node<T> root;

    public RedBlackTree(T data) {
        this.root = new Node<T>(data, Color.BLACK);
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public RedBlackTree<T> insertNode(Node<T> node) {
        try {
            this.findNewNodeLocation(node, this.root);
        } catch (Exception e) {
            System.out.println("Error while trying to insert node.");
        }

        return this;
    }

    private void findNewNodeLocation(Node<T> newNode, Node<T> startNode) throws Exception {
        if (newNode.getData().compareTo(startNode.getData()) > 0) {
            if (startNode.getChild(Position.RIGHT) == null) {
                startNode.setChildNode(newNode);
                return;
            } else {
                findNewNodeLocation(newNode, startNode.getChild(Position.RIGHT));
            }
        } else {
            if (startNode.getChild(Position.LEFT) == null) {
                startNode.setChildNode(newNode);
                return;
            } else {
                findNewNodeLocation(newNode, startNode.getChild(Position.LEFT));
            }
        }
    }
}
