package src;

public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> parentNode;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private Color color; // Current node color
    private Position position; // Tells if current node is a left or right child of its parent

    public Node(T data, Color color) {
        this.data = data;
        this.color = color;
    }

    public Node<T> setChildNode(Node<T> node) throws Exception {
        if (node.getParentNode() != null) {
            throwExceptionOnNodeReplacement();
        }
        if (node.getData().compareTo(this.getData()) < 0) {
            return this.setChildNode(node, Position.LEFT);
        }
        return this.setChildNode(node, Position.RIGHT);
    }

    private Node<T> setChildNode(Node<T> node, Position position) throws Exception {
        if (this.getChild(position) != null || node.getParentNode() != null) {
            throwExceptionOnNodeReplacement();
        }
        node.parentNode = this;
        node.position = position;
        if (position == Position.LEFT) this.leftNode = node;
        else this.rightNode = node;

        return this;
    }

    public Node<T> getSiblingNode() {
        if (this.position == Position.LEFT) {
            return this.parentNode.getChild(Position.LEFT);
        }

        // No other checks needed
        return this.parentNode.getChild(Position.RIGHT);
    }

    public Node<T> getParentNode() {
        return this.parentNode;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getChild(Position position) {
        if (position == Position.LEFT) return this.leftNode;
        else return this.rightNode;
    }

    public Color getColor() {
        return this.color;
    }

    public Node<T> toggleColor() {
        if (this.color == Color.BLACK) this.color = Color.RED;
        else this.color = Color.BLACK;

        return this;
    }

    public String toString() {
        return "{Node value is %s and its children are %s and %s}"
            .formatted(
                this.getData(),
                this.getChild(Position.LEFT),
                this.getChild(Position.RIGHT)
            );
    }

    private void throwExceptionOnNodeReplacement() throws Exception {
        throw new Exception("Cannot replace an already existing node!");
    }
}
