import src.Color;
import src.Node;
import src.Position;
import src.RedBlackTree;
import static java.lang.System.out;

/**
 * main
 */
public class Main {
    public static void main(String[] args) throws Exception {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>(100);

        out.println(tree.getRoot().getData());
        out.println(tree.getRoot().toString());

        tree.insertNode(new Node<Integer>(22, Color.RED));
        tree.insertNode(new Node<Integer>(122, Color.RED));
        tree.insertNode(new Node<Integer>(125, Color.RED));
        tree.insertNode(new Node<Integer>(127, Color.RED));
        // out.println(tree.getRoot().toString());

        assertTrue(tree.getRoot().getData() == 100);
        assertTrue(tree.getRoot().getChild(Position.RIGHT).getData() == 122);
    }

    private static void assertTrue(boolean condition) throws Exception{
        if (condition == false) throw new Exception("Assertion failure");
    }
}
