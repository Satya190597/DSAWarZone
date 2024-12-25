/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode leftNode,TreeNode rightNode) {
        if(leftNode == null && rightNode == null)
            return true;
        if(leftNode == null || rightNode == null)
            return false;
        boolean isNodeAreEqual = leftNode.val == rightNode.val;
        boolean isLeftSubTreeEqual = dfs(leftNode.left,rightNode.right);
        boolean isRightSubTreeEqual = dfs(leftNode.right,rightNode.left);
        return isNodeAreEqual && isLeftSubTreeEqual && isRightSubTreeEqual;
    }
}