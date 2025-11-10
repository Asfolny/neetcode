class TreeMap {
    TreeNode root;

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        if (this.root == null)
            this.root = new TreeNode(val, key);

        var curr = this.root;
        while (true) {
            if (key == curr.key) {
                curr.val = val;
                return; // duplicate
            }

            if (key > curr.key) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val, key);
                    return;
                }

                curr = curr.right;
                continue;
            }

            if (key < curr.key) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val, key);
                    return;
                }

                curr = curr.left;
            }
        }
    }

    public int get(int key) {
        var curr = this.root;

        while (curr != null) {
            if (curr.key == key)
                return curr.val;
            if (curr.key > key) {
                curr = curr.left;
                continue;
            }
            if (curr.key < key) {
                curr = curr.right;
                continue;
            }
        }

        return -1;
    }

    public int getMin() {
        if (this.root == null) return -1;

        var curr = this.root;

        while (curr.left != null)
            curr = curr.left;

        return curr.val;
    }

    public int getMax() {
        if (this.root == null) return -1;

        var curr = this.root;

        while (curr.right != null)
            curr = curr.right;

        return curr.val;
    }

    public void remove(int key) {
       this.root = this.deleteNode(this.root, key);
    }

    private TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = minKeyNode(root.right);
                root.key = minNode.key;
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.key);
            }
        }
        return root;
    }

    private TreeNode minKeyNode(TreeNode root) {
        TreeNode curr = root;
        while(curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = this.root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.key);
            curr = curr.right;
        }

        return res;
    }
}

private class TreeNode {
    int val;
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, int key) {
        this.val = val;
        this.key = key;
    }
}
