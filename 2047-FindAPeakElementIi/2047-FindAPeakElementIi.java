// Last updated: 7/12/2026, 11:15:11 PM
class Solution {
    public int[] findPeakGrid(int[][] mat) {

            int row=mat.length;
            int col=mat[0].length;

            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){

                    if(check(i,j,mat)){
                        return new int[]{i,j};
                    }
                }
            }

            return new int []{-1,-1};
    }

   private static boolean check(int r, int c, int[][] mat) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (mat[nr][nc] > mat[r][c]) {
                    
                    return false;
                }
            }
        }
        return true;
    }
}