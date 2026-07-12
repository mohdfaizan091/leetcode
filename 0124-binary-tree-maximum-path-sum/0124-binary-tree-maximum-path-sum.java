
class Solution {
    static int val;
    public int sumPath(TreeNode root) {
        if(root == null) return 0;
        int left = sumPath(root.left);
        int right = sumPath(root.right);
        int linesum = root.val;
        if(left > 0) linesum+=left;
        if(right > 0) linesum+=right;
        val = Math.max(root.val, Math.max(val, linesum));
        return root.val + Math.max(0, Math.max(left, right));
    }
    public int maxPathSum(TreeNode root) {
        val = Integer.MIN_VALUE;
        sumPath(root);
        return val;
    }
}