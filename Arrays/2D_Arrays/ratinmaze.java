//package 2D_Arrays;
import java.util.* ;
import java.io.*; 
//https://www.codingninjas.com/codestudio/problems/758966?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class ratinmaze {

     static int dir[][]={{0,-1},{0,1},{-1,0},{1,0}};
     public static boolean isvalid(int x,int y,int n){
        if(x <0 || y <0 || x >= n || y >= n){
            return false;
        }
        return true;
     }
    public static void  solve(int[][]maze,int[][]visited,ArrayList<ArrayList<Integer>> ans,int i,int j,int n){
        if(i == n-1 && j == n-1){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int r=0;r<n;r++){
                for(int c =0;c<n;c++){
                    temp.add(visited[r][c]);
                }
            }
            ans.add(temp);
            return ;
        }
        
        if(maze[i][j]==0){
            return ;
        }
        for(int k =0;k<4;k++){
            int x = i+ dir[k][0];
            int y = j+ dir[k][1];
            
            if(isvalid(x,y,n)  && maze[x][y]==1 && visited[x][y]==0){
                visited[x][y]=1;
                solve(maze,visited,ans,x,y,n);
                visited[x][y]=0;
                
            }
        }
        
    }
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
         int [][]visited= new int[n][n];
         for(int i=0;i<n;i++){
             for(int j =0;j<n;j++){
                 visited[i][j]=0;
             }
         }
        ArrayList<Integer> res = new ArrayList<>();
        
          if(maze[0][0]==1){
              visited[0][0]=1;
              solve(maze,visited,ans,0,0,n);
          }
        

         return ans;
        
            }
}
