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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var order = new ArrayList<List<Integer>>();

        if (root == null) {
            return order;
        }

        var queue = new ArrayDeque<TreeNode>() {{ add(root); }};
        var level = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for (int i = 0; i < levelLength; i++) {
                var curr = queue.removeFirst();
                level.add(curr.val);
                
                if(curr.left != null)
                    queue.add(curr.left);  
                if(curr.right != null)
                    queue.add(curr.right);
            }

            order.add(level);
            level = new ArrayList<Integer>();
        }

        return order;
    }
}

