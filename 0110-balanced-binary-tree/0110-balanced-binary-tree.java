
class Solution {
    static boolean flag;
    public int levels(TreeNode root) {
        if(root == null) return 0;
        int left = levels(root.left);
        int right = levels(root.right);
        if(Math.abs(left - right)>1){
            flag = false;
        }
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        flag = true;
        levels(root);
        return flag;
    }
}