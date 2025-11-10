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
    public List<Integer> rightSideView(TreeNode root) {
        var right = new ArrayList<Integer>();
        if (root == null) return right;
        var queue = new ArrayDeque<TreeNode>() {{ add(root); }};

        while (!queue.isEmpty()) {
            var levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                var item = queue.removeFirst();
                if (item.left != null)
                    queue.add(item.left);
                if (item.right != null)
                    queue.add(item.right);
                if (i == levelLength - 1)
                    right.add(item.val);
            }
        }

        return right;
    }
}

