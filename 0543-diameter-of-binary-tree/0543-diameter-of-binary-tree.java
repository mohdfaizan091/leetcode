
class Solution {
    public int levels(TreeNode root) {
        if(root == null) return 0;
        int left = levels(root.left);
        int right = levels(root.right);
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int dia = levels(root.left) + levels(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        return Math.max(dia, Math.max(left, right));

    }
}