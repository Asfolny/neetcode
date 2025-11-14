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
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode node, int curSum, int targetSum) {
        if (node == null) return false;

        curSum += node.val;
        if (node.left == null && node.right == null) {
            return curSum == targetSum;
        }

        return dfs(node.left, curSum, targetSum) || dfs(node.right, curSum, targetSum);
    }
}
