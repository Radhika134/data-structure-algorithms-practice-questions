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
class Pair {
    TreeNode node;
    int idx;

    public Pair(TreeNode node, int index)
    {
        this.node = node;
        this.idx = index;

    }
}

class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<Pair>();

        int ans = 0;
        q.add(new Pair(root, 0));

        while(!q.isEmpty())
        {
            int size = q.size();
            int min_idx = q.peek().idx;
            int first = 0, last = 0;

            for(int i = 0; i<size; i++)
            {
                int curr_idx = q.peek().idx - min_idx;
                TreeNode curr = q.peek().node;
                q.poll();

                if(i == 0) first = curr_idx;
                if(i == size-1) last = curr_idx;

                if(curr.left != null) q.add(new Pair(curr.left, curr_idx*2+1));
                if(curr.right != null) q.add(new Pair(curr.right, curr_idx*2+2));
                
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}