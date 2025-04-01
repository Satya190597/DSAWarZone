import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InsertElementInTree {
    public static void main(String[] args)
    {
        try {
            Scanner scanner = new Scanner(System.in);
            TreeFactory treeFactory = new TreeFactory();
            InsertElementInTree insertElementInTree = new InsertElementInTree();
            BinaryTree existingTree = treeFactory.createBinaryTree();
            System.out.println("Original Tree");
            insertElementInTree.print(existingTree);
            System.out.println("\nEnter An Element You Want To Insert : ");
            int element = scanner.nextInt();
            System.out.println("Enter 1 For Recursion And 2 For Without Recursion :");
            int option = scanner.nextInt();
            if (option == 1)
                insertElementInTree.insertElement(existingTree, element);
            else if (option == 2)
                insertElementInTree.insertElementWithoutRecursion(existingTree, element);
            else
                throw new RuntimeException("Invalid Option Selected");
            System.out.println("Tree After Insertion");
            insertElementInTree.print(existingTree);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    public void insertElement(BinaryTree node,int data) {
        if(node==null)
            return;
        if(data<node.getData()) {
            if(node.getLeftNode()!=null)
                insertElement(node.getLeftNode(), data);
            else
                node.setLeftNode(new BinaryTree(data));
        }
        else {
            if(node.getRightNode()!=null)
                insertElement(node.getRightNode(), data);
            else
                node.setRightNode(new BinaryTree(data));
        }
    }
    public void insertElementWithoutRecursion(BinaryTree node, int data) {
        Queue<BinaryTree> listOfNodes = new LinkedList<>();
        listOfNodes.add(node);
        while (!listOfNodes.isEmpty())
        {
            BinaryTree currentNode = listOfNodes.poll();
            if(data<currentNode.getData())
            {
                if(currentNode.getLeftNode()!=null)
                    listOfNodes.add(currentNode.getLeftNode());
                else
                {
                    currentNode.setLeftNode(new BinaryTree(data));
                    break;
                }
            }
            else
            {
                if(currentNode.getRightNode()!=null)
                    listOfNodes.add(currentNode.getRightNode());
                else
                {
                    currentNode.setRightNode(new BinaryTree(data));
                    break;
                }
            }
        }
    }
    public void print(BinaryTree binaryTree) {
        if(binaryTree == null)
            return;
        System.out.print(binaryTree.getData()+" ");
        print(binaryTree.getLeftNode());
        print(binaryTree.getRightNode());
    }
}
