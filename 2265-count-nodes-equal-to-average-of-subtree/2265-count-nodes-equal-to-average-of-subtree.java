class Solution {

    int count = 0;
    public int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    public int nodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + nodes(root.left) + nodes(root.right);
    }

    public void countNode(TreeNode root) {
        if (root == null) return;
        int s = sum(root);
        int n = nodes(root);
        int average = s / n;
        if (root.val == average) {
            count++;
        }
        countNode(root.left);
        countNode(root.right);
    }

    public int averageOfSubtree(TreeNode root) {
        count = 0;
        countNode(root);
        return count;
    }
}