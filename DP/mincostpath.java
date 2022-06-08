package DP;

public class mincostpath {

    // RECURSIVE SOLUTION

    // T.C =O(3^(X.Y)); // AS WE HAVE TO MAKE THREE CALLS EVERY TIME TO FILL THE
    // NEXT CELL (WHERE X AND Y ARE THE COORDINATES OF THE MATRIX OR CELLS)
    // public static int mincostpath(int [][]cost,int m,int n,int x,int y ,int i,int
    // j){
    // if(i ==x-1 && j==y-1){
    // return cost[i][j];
    // }
    // if(i>=x || j>=y ){
    // return Integer.MAX_VALUE;
    // }
    // int op1= mincostpath(cost,m,n,x,y,i+1,j);
    // int op2= mincostpath(cost,m,n,x,y,i,j+1);
    // int op3= mincostpath(cost,m,n,x,y,i+1,j+1);
    // return cost[i][j]+(Math.min(op1,Math.min(op2,op3)));
    // }
    // public static int minCostPath(int[][] cost, int x, int y)
    // {
    // int m= cost.length;
    // int n = cost[0].length;
    // int i=0;
    // int j=0;
    // return mincostpath(cost,m,n,x,y,i,j);

    // }

    // MEMOIZATION APPROACH

    // T.C= O(x*y) WHERE X AND Y ARE COORDINATES IN THIS X*Y CELLS TO CONSIDER NOT
    // THE WHOLE MATRIX AS WE STORE THE PREVIOUS RESULT WHICH TAKES O(1) TO COMPUTE
    // RESULT FOR NEXT CELL;
    // public static int minCostPath(int[][] cost, int x, int y) {
    // int m = cost.length;
    // int n = cost[0].length;
    // int i=0,j=0;
    // int storage [][]= new int [m][n];
    // for(int k =0;k<m;k++){
    // for(int l=0;l<n;l++){
    // storage[k][l]= -1;
    // }
    // }
    // return mincostpathM(cost,x,y,m,n,i,j,storage);
    // }
    // public static int mincostpathM(int [][]cost,int x,int y ,int m,int n, int i
    // ,int j,int storage[][]){
    // if(i==x-1 && j==y-1){
    // storage[x-1][y-1]= cost[i][j];
    // return storage[x-1][y-1];
    // }
    // if(i>=x || j>=y){

    // return Integer.MAX_VALUE;

    // }
    // if(storage[i][j]!=-1){
    // return storage[i][j];
    // }
    // int op1 = mincostpathM(cost,x,y,m,n,i+1,j,storage);
    // int op2= mincostpathM(cost,x,y,m,n,i+1,j+1,storage);
    // int op3 = mincostpathM(cost,x,y,m,n,i,j+1,storage);
    // storage[i][j]= cost[i][j]+ Math.min(op1,Math.min(op2,op3));
    // return storage[i][j];
    // }

    // DP APPROACH
    
    // T.C= O(X*Y) REASON SAME AS ABOVE IN MEMOIZATION

    public static int minCostPath(int[][] cost, int x, int y) {
        int m = cost.length;
        int n = cost[0].length;
        int dp[][] = new int[m][n];
        dp[x - 1][y - 1] = cost[x - 1][y - 1];
        for (int j = y - 2; j >= 0; j--) {
            dp[x - 1][j] = dp[x - 1][j + 1] + cost[x - 1][j];
        }
        for (int i = x - 2; i >= 0; i--) {
            dp[i][y - 1] = dp[i + 1][y - 1] + cost[i][y - 1];
        }
        for (int i = x - 2; i >= 0; i--) {
            for (int j = y - 2; j >= 0; j--) {
                dp[i][j] = cost[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
            }
        }
        return dp[0][0];
    }

}
