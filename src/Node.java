package src;

public class Node<T> {
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

    public Node<T> setParentNode(Node<T> parent, Position position) throws Exception {
        if (position == Position.LEFT) {
            if (parent.getLeftNode() != null) {
                throw new Exception("Cannot replace an already existing node!");
            }
            parent.setLeftNode(this);
        }
        if (position == Position.RIGHT) {
            if (parent.getRightNode() != null) {
                throw new Exception("Cannot replace an already existing node!");
            }
            parent.setRightNode(this);
        }

        this.position = position;
        this.parentNode = parent;

        return this;
    }

    public Node<T> setLeftNode(Node<T> node) throws Exception {
        if (this.leftNode != null || node.getParentNode() != null) {
            throw new Exception("Cannot replace an already existing node!");
        }
        node.setParentNode(this, Position.LEFT);

        return this;
    }

    public Node<T> setRightNode(Node<T> node) throws Exception {
        if (this.rightNode != null || node.getParentNode() != null) {
            throw new Exception("Cannot replace an already existing node!");
        }
        node.setParentNode(this, Position.RIGHT);

        return this;
    }

    public Node<T> getSiblingNode() {
        if (this.position == Position.LEFT) {
            return this.parentNode.getLeftNode();
        }

        // No other checks needed
        return this.parentNode.getRightNode();
    }

    public Node<T> getParentNode() {
        return this.parentNode;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getLeftNode() {
        return this.leftNode;
    }

    public Node<T> getRightNode() {
        return this.rightNode;
    }

    public Color getColor() {
        return this.color;
    }
}
