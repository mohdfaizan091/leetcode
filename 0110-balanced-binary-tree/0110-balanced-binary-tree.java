
class Solution {
    public int levels(TreeNode root) {
        if(root == null) return 0;
        int left = levels(root.left);
        int right = levels(root.right);
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(levels(root.left)-levels(root.right))>1){
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));

    }
}