// Last updated: 7/12/2026, 11:14:18 PM
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls) grid[w[0]][w[1]] = 2;

        boolean[][] seen = new boolean[m][n];

        for (int[] g : guards) {
            int r = g[0], c = g[1] + 1;
            while (c < n && grid[r][c] != 2 && grid[r][c] != 1) {
                seen[r][c] = true;
                c++;
            }
        }
        for (int[] g : guards) {
            int r = g[0], c = g[1] - 1;
            while (c >= 0 && grid[r][c] != 2 && grid[r][c] != 1) {
                seen[r][c] = true;
                c--;
            }
        }
        for (int[] g : guards) {
            int r = g[0] + 1, c = g[1];
            while (r < m && grid[r][c] != 2 && grid[r][c] != 1) {
                seen[r][c] = true;
                r++;
            }
        }
        for (int[] g : guards) {
            int r = g[0] - 1, c = g[1];
            while (r >= 0 && grid[r][c] != 2 && grid[r][c] != 1) {
                seen[r][c] = true;
                r--;
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !seen[i][j]) count++;
            }
        }
        return count;
    }
}