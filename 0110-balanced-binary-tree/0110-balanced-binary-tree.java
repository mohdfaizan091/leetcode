
class Solution {
    // optimzation using memoaization
    HashMap<TreeNode, Integer> dp = new HashMap<>();
    public int levels(TreeNode root) {
        if(root == null) return 0;
        if (dp.containsKey(root)) return dp.get(root);
        int left = levels(root.left);
        int right = levels(root.right);
        int bal = 1 + Math.max(left, right);
        dp.put(root, bal);
        return bal;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(levels(root.left)-levels(root.right))>1){
            return false;
        }
        return (isBalanced(root.left) && isBalanced(root.right));

    }
}