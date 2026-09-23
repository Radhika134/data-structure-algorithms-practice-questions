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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();

        TreeNode curr = root;

      
        while(curr != null || !stk.isEmpty())
        {
           
            //go left as possible
            while(curr!=null)
            {
                stk.push(curr);
                curr = curr.left;
            }

            //process root
            curr = stk.pop();
            arr.add(curr.val);

            //now right

            curr = curr.right;
        }
        return arr;
        
    }
}