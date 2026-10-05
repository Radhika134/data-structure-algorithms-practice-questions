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
    public int findSum(TreeNode root,int []mSum)
    {
        if(root == null) return 0;

        int lSum = Math.max(0, findSum(root.left, mSum));
        int rSum = Math.max(0, findSum(root.right, mSum));

        mSum[0] = Math.max(mSum[0] , root.val + lSum + rSum);

        return root.val + Math.max(lSum, rSum);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int[] mSum = new int[1]; 
        mSum[0] = Integer.MIN_VALUE;
        findSum(root, mSum);
        return mSum[0];
        
    }
}