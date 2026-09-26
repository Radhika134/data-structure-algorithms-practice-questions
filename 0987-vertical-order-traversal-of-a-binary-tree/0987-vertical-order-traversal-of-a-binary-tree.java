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
class Tuple{
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode root, int row, int col)
    {
        this.node = root;
        this.row = row;
        this.col = col;

    }
} 

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<Tuple>();

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mpp = new TreeMap<>();
        List<List<Integer>> arr = new ArrayList<>();

        if(root == null) return arr;
        q.add(new Tuple(root, 0, 0));


        while(!q.isEmpty())
        {
            Tuple nn = q.poll();

            int r = nn.row;
            int c = nn.col;

            if(!mpp.containsKey(c))
            {
                mpp.put(c, new TreeMap<>());
            }

            if(!mpp.get(c).containsKey(r))
            {
                mpp.get(c).put(r, new PriorityQueue<>());
            }

            mpp.get(c).get(r).offer(nn.node.val);

            if(nn.node.left != null) q.add(new Tuple(nn.node.left, r+1, c-1));
            if(nn.node.right != null) q.add(new Tuple(nn.node.right, r+1, c+1));
            
        }

        for(int cols: mpp.keySet())
        {
            List<Integer> temp = new ArrayList<>();
            for(int rows: mpp.get(cols).keySet())
            {
                PriorityQueue<Integer> pq = mpp.get(cols).get(rows);
                while(!pq.isEmpty())
                {
                    temp.add(pq.poll());

                }
            }
            arr.add(temp);
        }
        return arr;
    }
}