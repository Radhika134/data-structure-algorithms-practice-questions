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
    public int height(TreeNode root)
    {
        //height of the tree ka cod eh bs simply
        if(root == null) return 0;

        int lh = height(root.left);
        if(lh == -1) return -1;   // mtlb agar pehle khi bhi -1 aagya toh seedha false 
        int rh = height(root.right);
        if(rh == -1) return -1;
        
        if(Math.abs(lh - rh) > 1) return -1;  // -1 mtlb balanced nhi h

        return Math.max(lh, rh) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
        
    }
}