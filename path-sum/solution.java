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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return pathSumWalk(root, targetSum, new ArrayList<Integer>());
    }

    private boolean pathSumWalk(TreeNode node, int target, List<Integer> path) {
        path.add(node.val);
        var sum = path.stream().reduce(0, Integer::sum);

        if (sum == target && node.left == null && node.right == null) {
            return true;
        }

        if (node.left != null && pathSumWalk(node.left, target, path)) {
            return true;
        }

        if (node.right != null && pathSumWalk(node.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
