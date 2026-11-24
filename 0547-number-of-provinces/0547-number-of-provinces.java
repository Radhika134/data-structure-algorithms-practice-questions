class Solution {

    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, int []vis)
    {
        vis[node] = 1;

        for(int neighbour : adj.get(node))
        {
            if(vis[neighbour] == 0)
            {
                dfs(adj, neighbour, vis);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = isConnected.length;
        
        for(int i = 0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(isConnected[i][j] == 1 && i != j )
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int count = 0;
        int[] vis = new int[n];
        for(int i = 0; i<n; i++)
        {
            if(vis[i] == 0)
            {
                count++;
                dfs(adj, i, vis);
            }
        }

        return count;
    }
}