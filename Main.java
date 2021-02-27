import src.RedBlackTree;
import static java.lang.System.out;

/**
 * main
 */
public class Main {
    public static void main(String[] args) {
        RedBlackTree<String> tree = new RedBlackTree<String>("root");

        out.println(tree.getRoot().getData());
    }
}
