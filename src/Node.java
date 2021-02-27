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
        if (this.parentNode != null || parent.getChild(position) != null) {
            throwExceptionOnNodeReplacement();
        }

        parent.setChildNode(this, position);
        this.position = position;
        this.parentNode = parent;

        return this;
    }

    public Node<T> setChildNode(Node<T> node, Position position) throws Exception {
        if (node.getParentNode() != null || this.getChild(position) != null) {
            throwExceptionOnNodeReplacement();
        }
        node.setParentNode(this, position);

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

    private void throwExceptionOnNodeReplacement() throws Exception {
        throw new Exception("Cannot replace an already existing node!");
    }
}
