class Solution {
    public TreeNode helper(int[] Root , int[] Position , int rootLeftIdx , int rootRightIdx , int positionLeftIdx , int positionRightIdx){
        if( rootLeftIdx > rootRightIdx) return null;
        TreeNode root = new TreeNode(Root[rootLeftIdx]);
        int r = 0;

        while(Position[r] != Root[rootLeftIdx]){
            r++;
        }

        int leftOfRoot = r - positionLeftIdx;
        root.left = helper(Root , Position , rootLeftIdx + 1 , rootLeftIdx + leftOfRoot , positionLeftIdx, positionLeftIdx - r - 1);
        root.right = helper(Root , Position , rootLeftIdx + leftOfRoot + 1 , rootRightIdx , r + 1 , positionRightIdx);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder , inorder , 0 , n - 1 , 0 , n - 1);            
    }
}