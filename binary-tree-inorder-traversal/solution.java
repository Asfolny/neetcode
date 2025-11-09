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
    public List<Integer> inorderTraversal(TreeNode root) {
        var res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        var queue = new ArrayList<TreeNode>();
        var lefted = new ArrayList<Integer>(); 
        queue.add(root);
        TreeNode item = null;
        do {
            item = queue.remove(queue.size() - 1);

            if (item.left != null && !lefted.contains(item.hashCode())) {
                queue.add(item);
                queue.add(item.left);
                lefted.add(item.hashCode());
                continue;
            }

            res.add(item.val);

            if (item.right != null) {
                queue.add(item.right);
            }
        } while(!queue.isEmpty());
        
        return res;
    }
}
