# 101 Symmetric Tree
## Leetcode Question Link
https://leetcode.com/problems/symmetric-tree/description/
## Solution Approach.
- It's a binary tree, so there will be a maximum of 2 child nodes at any given point in time.
- The first node, or root node, will always be symmetric.
- We need to perform two parallel DFS operations: one on the left side of a subtree and another on the right side of the subtree.
- If both nodes are null, we can return True, which means all the nodes before the current ones are equal.
- If either of them is null, return False, because both the left and right nodes should be equal.
- Otherwise, compare the current node values and compare the left node's left subtree with the right node's right subtree, as well as the left node's right subtree with the right node's left subtree.