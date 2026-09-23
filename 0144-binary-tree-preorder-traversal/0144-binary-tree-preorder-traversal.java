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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        List<Integer> arr = new ArrayList<>();

        if(root == null) return arr;

        stk.push(root);
        while(!stk.isEmpty())
        {
            TreeNode ptr = stk.pop();
            arr.add(ptr.val);

            if(ptr.right != null) stk.push(ptr.right);
            if(ptr.left != null) stk.push(ptr.left);
        }
        return arr;
    }
}