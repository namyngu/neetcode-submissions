class TreeNode {
    int key;
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class TreeMap {
    TreeNode root;

    public TreeMap() {
        root = null;
    }

    public void insert(int key, int val) {
        TreeNode newNode = new TreeNode(key, val);
        if (root == null) {
            root = newNode;
            return;
        } else {
            TreeNode curr = root;
            while (true) {
                if (key < curr.key) {
                    if (curr.left == null) {
                        curr.left = newNode;
                        return;
                    }
                    curr = curr.left;
                }

                else if (key > curr.key) {
                    if (curr.right == null) {
                        curr.right = newNode;
                        return;
                    }
                    curr = curr.right;
                }

                else {
                    curr.val = val;
                    return;
                }
            }
        }
    }

    public int get(int key) {
        if (root == null) {
            return -1;
        }

        TreeNode curr = root;
        while (true) {
            if (key < curr.key) {
                if (curr.left == null) {
                    return -1;
                }
                curr = curr.left;
            } else if (key > curr.key) {
                if (curr.right == null) {
                    return -1;
                }
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
    }

    public int getMin() {
        if (root == null) {
            return -1;
        }

        TreeNode curr = root;
        while (true) {
            if (curr.left == null) {
                return curr.val;
            }
            curr = curr.left;
        }
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }

        TreeNode curr = root;
        while (true) {
            if (curr.right == null) {
                return curr.val;
            }
            curr = curr.right;
        }
    }

    public void remove(int key) {
        root = removeHelper(root, key);
    }

    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.key);
        inorder(root.right, list);
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    public TreeNode removeHelper(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = removeHelper(root.left, key);
        } else if (key > root.key) {
            root.right = removeHelper(root.right, key);
        } else {
            // Case 1: 1 or less children
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Case 2: 2 children
                TreeNode minNode = findMin(root.right);
                root.key = minNode.key;
                root.val = minNode.val;
                root.right = removeHelper(root.right, minNode.key);
            }
        }

        return root;
    }
}
