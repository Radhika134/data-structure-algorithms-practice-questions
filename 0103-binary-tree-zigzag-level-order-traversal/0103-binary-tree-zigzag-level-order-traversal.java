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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list1 = new ArrayList<>();
        

        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list1;

        q.add(root);
        int k = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> list2 = new ArrayList<>();

            for(int i = 0; i < size; i++)
            {
                TreeNode ptr = q.poll();
                list2.add(ptr.val);

                if(ptr.left != null) q.add(ptr.left);
                if(ptr.right != null) q.add(ptr.right);

            }
            
            if(k%2 == 0)
            {
                Collections.reverse(list2);
            }
            list1.add(list2);
            k++;
        }
        return list1;
    }
}