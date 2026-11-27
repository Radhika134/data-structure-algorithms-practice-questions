class Pair
{
    int row;
    int col;
    Pair(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<Pair>();

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if((i == 0 || i == m-1 || j == 0 || j == n-1) && grid[i][j] == 1)
                {
                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                }
            }
        }
        
        return BFS(grid, vis, m, n, q);
    }

    public int BFS(int [][] grid, int[][] vis, int m , int n, Queue<Pair> q)
    {
        int []dr = {-1, 0, 1, 0};
        int []dc = {0, 1, 0, -1};
        int count = 0;

        while(!q.isEmpty())
        {
            Pair current = q.poll();
            int r = current.row;
            int c = current.col;

            for(int i = 0; i<4; i++)
            {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >=0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && vis[nr][nc] != 1)
                {
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = 1;
                }
            }

        }

        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(grid[i][j] == 1 && vis[i][j] != 1)
                {
                    count++;
                } 
            }
        }
        
        return count;

    }
}