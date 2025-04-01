import java.util.Scanner;

public class TraverseBinaryTree {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TreeFactory treeFactory = new TreeFactory();
        BinaryTree tree = treeFactory.createBinaryTree();
        System.out.println("Successfully Created A Tree");
    }
}
