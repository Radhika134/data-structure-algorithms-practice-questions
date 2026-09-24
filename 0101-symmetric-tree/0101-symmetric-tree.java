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
    public boolean mirror(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        boolean x = mirror(p.left, q.right);
        boolean y = mirror(p.right, q.left);

        return x&&y;
    }
    public boolean isSymmetric(TreeNode root) {
        boolean res = mirror(root.left, root.right);
        return res;
        
    }
}