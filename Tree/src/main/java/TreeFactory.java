import java.util.Scanner;

public class TreeFactory {
    public BinaryTree createBinaryTree() {
        System.out.println("Enter Number Nodes You Want To Create : ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        System.out.println("Enter Number Of Element "+size);
        int[] numberOfNodes = new int[size];
        for(int i = 0; i < size; i++)
        {
            numberOfNodes[i] = scanner.nextInt();
        }
        BinaryTree rootNode = new BinaryTree();
        rootNode.setData(numberOfNodes[0]);
        for(int i = 1; i < size; i++)
        {
            insert(rootNode,numberOfNodes[i]);
        }
        return rootNode;
    }
    public void insert(BinaryTree node,int data) {
        if(node.getData()>data)
        {
            if(node.getLeftNode()!=null)
                insert(node.getLeftNode(),data);
            else
                node.setLeftNode(new BinaryTree(data));
        }
        else
        {
            if(node.getRightNode()!=null)
                insert(node.getRightNode(),data);
            else
                node.setRightNode(new BinaryTree(data));
        }
    }
}
