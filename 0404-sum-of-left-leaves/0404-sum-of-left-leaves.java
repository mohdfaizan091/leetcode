/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans;
    public void sumOfLeft(TreeNode root , String side) {
        if(root == null) return;

        if(side == "L" && root.left == null && root.right == null) {
            ans += root.val;
        }

        sumOfLeft(root.left , "L");
        sumOfLeft(root.right , "R");
    }
    public int sumOfLeftLeaves(TreeNode root) {
        ans = 0;
        sumOfLeft(root.left , "L");
        sumOfLeft(root.right , "R");
        return ans;
    }
}