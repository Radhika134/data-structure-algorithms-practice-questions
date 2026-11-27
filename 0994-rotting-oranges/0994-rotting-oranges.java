class Pair {
    int rows;
    int cols;
    int time;

    Pair(int rows, int cols, int time) {
        this.rows = rows;
        this.cols = cols;
        this.time = time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] mark = new int[m][n];
        Queue<Pair> q = new LinkedList<Pair>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    mark[i][j] = 2;
                }

            }
        }
        return BFS(grid, mark, q, m, n);

    }

    public int BFS(int[][] grid, int[][] mark, Queue<Pair> q, int m, int n) {

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int minutes = 0;

        while (!q.isEmpty()) {
            Pair current = q.poll();

            int r = current.rows;
            int c = current.cols;
            minutes = current.time;

            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && mark[nr][nc] != 2) {
                    q.add(new Pair(nr, nc, minutes + 1));
                    mark[nr][nc] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && mark[i][j] != 2) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}