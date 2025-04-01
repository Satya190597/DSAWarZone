public class BinaryTree {
    private int data;
    private BinaryTree leftNode, rightNode;

    public BinaryTree() {

    }

    public BinaryTree(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTree leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTree getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTree rightNode) {
        this.rightNode = rightNode;
    }
}
