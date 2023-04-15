//https://leetcode.com/problems/unique-paths/description/
public class uniquepaths {
    // BRUTE FORCE APPROACH USING RECURSION
    // public int countpaths(int i,int j,int m,int n){
    // if(i== m-1 && j == n-1){
    // return 1;
    // }
    // if(i >= m || j>=n){
    // return 0;
    // }
    // return countpaths(i+1,j,m,n)+ countpaths(i,j+1,m,n);
    // }
    // public int uniquePaths(int m, int n) {
    // int i=0;
    // int j =0;
    // return countpaths(i,j,m,n);

    // }
    // }

    // OPTIMAL APPROACH USING DP
    // public int countpaths(int i,int j,int m,int n,int[][]dp){
    // if(i == m-1 && j==n-1){
    // return 1;
    // }
    // if(i >=m || j>=n){
    // return 0;
    // }
    // if(dp[i][j]!=-1){
    // return dp[i][j];
    // }else{
    // dp[i][j]= countpaths(i+1,j,m,n,dp)+ countpaths(i,j+1,m,n,dp);
    // return dp[i][j];
    // }

    // }
    // public int uniquePaths(int m, int n) {
    // int [][]dp = new int[m][n];
    // for(int i=0;i<m;i++){
    // for(int j =0;j<n;j++){
    // dp[i][j] = -1;
    // }
    // }
    // return countpaths(0,0,m,n,dp);

    // }
    //

    // Tricky solution
    // solution link - https://www.youtube.com/watch?v=t_f0nwwdg5o
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int r = m - 1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }
}
