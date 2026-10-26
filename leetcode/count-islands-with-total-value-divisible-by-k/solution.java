class Solution {
    int[][] vis;

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] > 0) {
                    long total = fn(grid, i, j);
                    if (total % k == 0) count++;
                }
            }
        }
        return count;
    }

    public long fn(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 0;
        if (grid[i][j] == 0 || vis[i][j] == 1) return 0;

        vis[i][j] = 1;
        long sum = grid[i][j];

        sum += fn(grid, i + 1, j);
        sum += fn(grid, i - 1, j);
        sum += fn(grid, i, j + 1);
        sum += fn(grid, i, j - 1);

        return sum;
    }
}