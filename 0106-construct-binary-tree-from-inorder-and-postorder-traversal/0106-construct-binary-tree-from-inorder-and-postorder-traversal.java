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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;

        int n = inorder.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i = 0; i<n; i++)
        {
            mpp.put(inorder[i], i);
        }

        TreeNode root = build(inorder, 0, n-1, postorder, 0, n-1, mpp);
        return root;
        
    }

    TreeNode build(int[]inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> mpp)
    {
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = mpp.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(inorder, inStart, inRoot - 1, postorder, postStart, postStart+numsLeft -1, mpp);

        root.right = build(inorder, inRoot + 1, inEnd, postorder, postStart+numsLeft, postEnd-1, mpp);

        return root;
    } 
}