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
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int n = inorder.length;

        for(int i = 0; i < n; i++)
        {
            mpp.put(inorder[i],i);
        }

        TreeNode root = build(preorder, 0, n-1, inorder, 0, n-1, mpp);
        return root;
   
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, 
     int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> mpp)
    {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = mpp.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = build(preorder, preStart+1, preStart + numsLeft, inorder, inStart, inRoot-1, mpp);

        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot+1, inEnd, mpp);

        return root;

    }

}