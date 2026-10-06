/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parent_track)
    {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return;
        q.add(root);
        parent_track.put(root, null);

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();

            if(curr.left != null)
            {
                q.offer(curr.left);
                parent_track.put(curr.left, curr);
            }

            if(curr.right != null)
            {
                q.offer(curr.right);
                parent_track.put(curr.right, curr);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track);

        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int curr_level = 0;
        q.add(target);
        visited.put(target, true);

        while(!q.isEmpty())
        {
            if(curr_level == k) break;
            curr_level++;

            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                TreeNode curr = q.poll();

                if(curr.left != null && visited.get(curr.left) == null)
                {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && visited.get(curr.right) == null)
                {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null)
                {
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }

            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            TreeNode ptr = q.poll();
            ans.add(ptr.val);
        }

        return ans;
    
    }
}