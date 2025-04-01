import java.util.*;

public class LevelOrderTraversal {
    public static void main(String[] args)
    {
        TreeFactory treeFactory = new TreeFactory();
        BinaryTree binaryTree = treeFactory.createBinaryTree();
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 For Level Order Traversal\nEnter 2 To Get Result As A Matrix\nEnter 3 For Reverse Order");
        int option = scanner.nextInt();
        if(option == 1)
            levelOrderTraversal.levelOrderTraversal(binaryTree);
        else if(option==2)
            levelOrderTraversal.levelOrderTraversalAsMatrix(binaryTree);
        else if(option==3)
            levelOrderTraversal.levelOrderTraversalReverse(binaryTree);
        else
            System.out.println("Invalid Option Selected");
    }

    public void levelOrderTraversalReverse(BinaryTree binaryTree) {
        Queue<BinaryTree> listOfNodes = new LinkedList<>();
        Stack<BinaryTree> result = new Stack<>();
        listOfNodes.add(binaryTree);
        while(!listOfNodes.isEmpty())
        {
            BinaryTree currentNode = listOfNodes.poll();
            result.add(currentNode);
            if(currentNode.getLeftNode()!=null)
                listOfNodes.add(currentNode.getLeftNode());
            if(currentNode.getRightNode()!=null)
                listOfNodes.add(currentNode.getRightNode());
        }
        System.out.println("Level Order Traversal : ");
        while(!result.isEmpty())
        {
            System.out.print(result.pop().getData()+" ");
        }
    }

    public void levelOrderTraversal(BinaryTree binaryTree) {
        Queue<BinaryTree> listOfNodes = new LinkedList<>();
        List<BinaryTree> result = new LinkedList<>();
        listOfNodes.add(binaryTree);
        while(!listOfNodes.isEmpty())
        {
            BinaryTree currentNode = listOfNodes.poll();
            result.add(currentNode);
            if(currentNode.getLeftNode()!=null)
                listOfNodes.add(currentNode.getLeftNode());
            if(currentNode.getRightNode()!=null)
                listOfNodes.add(currentNode.getRightNode());
        }
        System.out.println("Level Order Traversal : ");
        for(BinaryTree node : result)
        {
            System.out.print(node.getData()+" ");
        }
    }
    public void levelOrderTraversalAsMatrix(BinaryTree binaryTree) {
        Queue<BinaryTree> listOfNodes = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        listOfNodes.add(binaryTree);
        while(!listOfNodes.isEmpty())
        {
            int sizeOfQueue = listOfNodes.size();
            List<Integer> listOfItemsWithinALevel = new ArrayList<>();
            for(int i = 0; i < sizeOfQueue; i++) {
                BinaryTree currentNode = listOfNodes.poll();
                listOfItemsWithinALevel.add(currentNode.getData());
                if (currentNode.getLeftNode() != null)
                    listOfNodes.add(currentNode.getLeftNode());
                if (currentNode.getRightNode() != null)
                    listOfNodes.add(currentNode.getRightNode());
            }
            result.add(listOfItemsWithinALevel);
        }
        System.out.println(result);
    }
}
