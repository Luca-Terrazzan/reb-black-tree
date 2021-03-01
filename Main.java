import src.RedBlackTree;
import static java.lang.System.out;

/**
 * main
 */
public class Main {
    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>(100);

        out.println(tree.getRoot().getData());
    }
}
