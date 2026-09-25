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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return arr;
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            

            for(int i = 0; i < size; i++)
            {
                TreeNode ptr = q.poll();
                if(i == size-1) arr.add(ptr.val);
                

                if(ptr.left != null) q.add(ptr.left);
                if(ptr.right != null) q.add(ptr.right);

            }
            

        }
        return arr;
        
    }
}