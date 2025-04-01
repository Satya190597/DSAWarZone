import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumElementInTree {
    private int maximumElement = Integer.MIN_VALUE;
    /**
     * Find largest/maximum element in a binary tree.
     */
    public static void main(String[] args)
    {
        TreeFactory treeFactory = new TreeFactory();
        BinaryTree tree = treeFactory.createBinaryTree();
        MaximumElementInTree maximumElementInTree = new MaximumElementInTree();
        maximumElementInTree.iterateAndFindMaximum(tree);
        System.out.println("Find Maximum Element In A Tree Using Tree Traversal "+maximumElementInTree.maximumElement);
        System.out.println("Find Maximum Value By Dividing The Problem In Sub Problem "+maximumElementInTree.findMaximumUsingSubProblem(tree));
        System.out.println("Find Maximum Value Without Recursion "+maximumElementInTree.findMaximumElementWithoutRecursion(tree));
    }
    public void iterateAndFindMaximum(BinaryTree node) {
        if(node == null)
            return;
        iterateAndFindMaximum(node.getLeftNode());
        iterateAndFindMaximum(node.getRightNode());
        if(maximumElement<node.getData())
            maximumElement = node.getData();
    }
    public int findMaximumUsingSubProblem(BinaryTree node)
    {
        if(node == null)
            return Integer.MIN_VALUE;
        int leftNode = findMaximumUsingSubProblem(node.getLeftNode());
        int rightNode = findMaximumUsingSubProblem(node.getRightNode());
        return Math.max(Math.max(leftNode,rightNode),node.getData());
    }
    public int findMaximumElementWithoutRecursion(BinaryTree node) {
        int maximumValue = Integer.MIN_VALUE;
        Queue<BinaryTree> listOfNodes = new LinkedList<>();
        listOfNodes.add(node);
        while(!listOfNodes.isEmpty())
        {
            BinaryTree currentNode = listOfNodes.poll();
            if(currentNode!=null && currentNode.getData()>maximumValue)
                maximumValue = currentNode.getData();
            if(currentNode!=null)
            {
                if(currentNode.getLeftNode()!=null)
                    listOfNodes.add(currentNode.getLeftNode());
                if(currentNode.getRightNode()!=null)
                    listOfNodes.add(currentNode.getRightNode());
            }
        }
        return maximumValue;
    }
}
