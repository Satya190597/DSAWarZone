import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTheTree {
    public static void main(String[] args)
    {
        TreeFactory treeFactory = new TreeFactory();
        BinaryTree binaryTree = treeFactory.createBinaryTree();
        HeightOfTheTree heightOfTheTree = new HeightOfTheTree();
        heightOfTheTree.calculateHeight(binaryTree);
        System.out.println("Height Of The Tree : "+heightOfTheTree.calculateHeight(binaryTree));
        System.out.println("Height Of The Tree Without Recursion : "+heightOfTheTree.calculateHeightWithoutRecursion(binaryTree));
    }
    private int calculateHeight(BinaryTree node)
    {
        if(node==null)
            return 0;
        int heightOfLeftSubtree = calculateHeight(node.getLeftNode());
        int heightOfRightSubtree = calculateHeight(node.getRightNode());
        return Math.max(heightOfLeftSubtree,heightOfRightSubtree)+1;
    }
    private int calculateHeightWithoutRecursion(BinaryTree node) {
        Queue<BinaryTree> nodeList = new LinkedList<>();
        nodeList.add(node);
        int height = 0;
        while(!nodeList.isEmpty())
        {
            int size = nodeList.size();
            for(int i = 0; i < size; i++)
            {
                BinaryTree currentNode = nodeList.poll();
                if(currentNode.getLeftNode()!=null)
                    nodeList.add(currentNode.getLeftNode());
                if(currentNode.getRightNode()!=null)
                    nodeList.add(currentNode.getRightNode());
            }
            height++;
        }
        return height;
    }

}
