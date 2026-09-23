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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr1 = new ArrayList<>();
       

        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return arr1;
        q.add(root);

        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> arr = new ArrayList<>();

            for(int i = 0; i < size; i++)
            {
                TreeNode ptr = q.poll();
                arr.add(ptr.val);

                if(ptr.left != null) q.add(ptr.left);
                if(ptr.right != null) q.add(ptr.right);

            }
            arr1.add(arr);

        }
        return arr1;
    }
}