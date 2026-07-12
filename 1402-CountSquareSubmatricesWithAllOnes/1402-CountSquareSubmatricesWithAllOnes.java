// Last updated: 7/13/2026, 12:12:15 AM
class Solution {
    public int countSquares(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;

        int dp[][]=new int[row][col];

        for(int i=0;i<col;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=0;i<row;i++){
            dp[i][0]=matrix[i][0];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(matrix[i][j]==0){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        int sum=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sum+=dp[i][j];
            }
        }
        return sum;
       // return dp[row-1][col-1];
    }
}