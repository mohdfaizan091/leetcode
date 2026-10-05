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

class pair {
    TreeNode node;
    int idx;
    pair(TreeNode node , int idx) {
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        long ans = -1;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root , 0));
        while(!q.isEmpty()) {
            int size = q.size();
            int firstIdx = q.peek().idx;
            int lastIdx = 0;
            for(int i=0 ; i<size ; i++) {
                pair top = q.remove();
                TreeNode node = top.node;
                int idx = top.idx;
                lastIdx = idx;
                
                if(node.left != null) {
                    q.add(new pair(node.left , 2 * idx + 1));
                }

                if(node.right != null) {
                    q.add(new pair(node.right , 2 * idx + 2));
                }
            }
            long width = lastIdx - firstIdx + 1;

            ans = Math.max(ans, width);
        }

         return (int) ans;
    }
}