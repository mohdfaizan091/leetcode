
class Solution {
    static int max;
    public int levels(TreeNode root) {
        if (root == null) return 0;
        int left = levels(root.left);
        int right = levels(root.right);
        int dia = left + right;
        max = Math.max(max, dia);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        levels(root);
        return max;

    }
}