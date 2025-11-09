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
    public int kthSmallest(TreeNode root, int k) {
        var res = new int[k];
        var i = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while ((cur != null || !stack.isEmpty()) && i < k) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res[i] = cur.val;
            i++;
            cur = cur.right;
        }

        return res[k-1];
    }
}

