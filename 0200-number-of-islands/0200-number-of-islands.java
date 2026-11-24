class Solution {
    public void dfs(char [][]grid, int row, int col, int[][]vis, int r, int c)
    {
        vis[row][col] = 1;

        if(row - 1 >=0 && grid[row-1][col] == '1' && vis[row-1][col] == 0)
        {
            dfs(grid, row-1, col, vis, r, c);
        }

        if(col + 1 <= c && grid[row][col + 1] == '1' && vis[row][col + 1] == 0)
        {
            dfs(grid, row, col+1, vis, r, c);
        }

        if(row+1 <=r && grid[row + 1][col] == '1' && vis[row + 1][col] == 0)
        {
            dfs(grid, row+1, col, vis, r, c);
        }

        if(col-1 >= 0 && grid[row][col - 1] == '1' && vis[row][col - 1] == 0)
        {
            dfs(grid, row, col-1, vis, r, c);
        }

    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int [][]vis = new int[row][col];
        

        int count = 0;
        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<col; j++)
            {
                if(vis[i][j] == 0 && grid[i][j] == '1')
                {
                    count++;
                    dfs(grid, i, j, vis, row-1, col-1);

                }
            }
        }

        return count;
        
    }
}