
class Solution {
    public boolean doesExist(TreeNode root , TreeNode temp) {
        if(root == null) return false;
        if(root.val == temp.val) return true;
        return doesExist(root.left , temp) || doesExist(root.right , temp);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q) return root;
        boolean isPExistInLeft = doesExist(root.left , p);
        boolean isQExistInleft = doesExist(root.left , q);
        if(isPExistInLeft && isQExistInleft) return lowestCommonAncestor(root.left , p , q);
        if(!isPExistInLeft && !isQExistInleft) return lowestCommonAncestor(root.right , p , q);
        return root;
    }
}