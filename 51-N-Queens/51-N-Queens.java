// Last updated: 7/21/2026, 9:36:05 AM
1class Solution {
2    public List<List<String>> solveNQueens(int n) {
3        List<List<String>> result=new ArrayList<>();
4        char[][] board=new char[n][n];
5        for(char[] row:board){
6            Arrays.fill(row,'.');
7        }
8        int leftRow[]=new int[n];
9        int lowerDiagnol[]=new int[2*n-1];
10        int upperDiagnol[]=new int[2*n-1];
11        getBoard(0,board,n,leftRow,lowerDiagnol,upperDiagnol,result);
12        return result;
13    }
14    private static void getBoard(int col,char[][] board,int n,int leftRow[],int lowerDiagnol[],int upperDiagnol[], List<List<String>> result){
15        if(col==n){
16            List<String> tempString=new ArrayList();
17            for(int i=0;i<n;i++){
18                tempString.add(new String(board[i]));
19            }
20            result.add(tempString);
21        }
22        for(int row=0;row<n;row++){
23            if(leftRow[row]==0 && lowerDiagnol[row+col]==0 && upperDiagnol[n-1+col-row]==0){
24                    board[col][row]='Q';
25                    leftRow[row]=1;
26                    lowerDiagnol[row+col]=1;
27                    upperDiagnol[n-1+col-row]=1;
28                    getBoard(col+1,board,n,leftRow,lowerDiagnol,upperDiagnol,result);
29                    board[col][row]='.';
30                    leftRow[row]=0;
31                    lowerDiagnol[row+col]=0;
32                    upperDiagnol[n-1+col-row]=0;
33            }
34        }
35    }
36
37
38    
39}