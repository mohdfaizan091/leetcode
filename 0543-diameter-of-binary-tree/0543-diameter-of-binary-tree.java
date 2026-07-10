
class Solution {
    static HashMap<TreeNode, Integer> dp = new HashMap<>();
    public int levels(TreeNode root) {
        if (root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);
        int left = levels(root.left);
        int right = levels(root.right);
        int height = 1 + Math.max(left, right);
        dp.put(root, height);
        return height;
    }
    public int diameter(TreeNode root) {
        if(root == null) return 0;
        int dia = levels(root.left) + levels(root.right);
        int left = diameter(root.left);
        int right = diameter(root.right);
        return Math.max(dia, Math.max(left, right));

    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);

    }
}