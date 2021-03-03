import src.Color;
import src.Node;
import src.RedBlackTree;
import static java.lang.System.out;

/**
 * main
 */
public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>(100);

        out.println(tree.getRoot().getData());
        out.println(tree.getRoot().toString());

        tree.insertNode(new Node<Integer>(22, Color.RED));
        tree.insertNode(new Node<Integer>(122, Color.RED));
        tree.insertNode(new Node<Integer>(125, Color.RED));
        tree.insertNode(new Node<Integer>(127, Color.RED));
        out.println(tree.getRoot().toString());
    }
}
