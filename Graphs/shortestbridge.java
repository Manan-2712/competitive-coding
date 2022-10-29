package Graphs;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/shortest-bridge-official/ojquestion
//https://www.youtube.com/watch?v=VuNzLtd8PBg&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=7
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class shortestbridge {
  


  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(shortestBridge(arr));

  }
   public static  class Pair{
       int row;
       int col;
       public Pair(int row,int col){
           this.row = row;
           this.col = col;
       }
   }
   public static int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
  public static int shortestBridge(int[][] A) {
      Queue<Pair> q = new LinkedList<>();
      int level =-1;
       int n = A.length;
       int m = A[0].length;
       boolean visited [][]= new boolean[n][m];
       boolean flag = false;// this is used because we just need first occurence of 1 and all it;s 
       for(int i=0;i<n && !flag;i++){ // connected component,so initially it is false and when we found
           for(int j=0;j<m && !flag;j++){ // first occurence of 1 we just turn it;s value to true
               if(A[i][j]==1){             // so that we never call it again.
                   dfs(i,j,visited,A,q);
                   flag = true;
               }
           }
       }
       while(!q.isEmpty()){// this loop is used for updation of level 
           int size = q.size();
           level++;
           while(size-->0){ // this loop is used for actual bfs traversal 
               Pair rem = q.remove();
               for(int i=0;i<dirs.length;i++){
               int rowdash = rem.row+dirs[i][0];
               int coldash = rem.col+dirs[i][1];
               if(rowdash < 0 || coldash <0 || rowdash >= A.length || coldash >=A[0].length ||                              visited[rowdash][coldash]== true){
               continue;
           }
           if(A[rowdash][coldash]==1){
               return level;
           }
           q.add(new Pair(rowdash,coldash));
           }
       }
      // level++;
       }
       return -1;
       
       
  }
  // dfs is used to get all connected component of first occurence of 1 in the graph i.e first island. 
  public static void dfs(int r,int c,boolean [][]visited,int [][]A,Queue<Pair> q ){
      visited[r][c]= true;
      int level =-1;
    //  Queueu<Pair> q = new LinkedList<>();
      q.add(new Pair(r,c));
      for(int i=0;i<dirs.length;i++){
        int rowdash = r+dirs[i][0];
        int coldash = c +dirs[i][1];
        if(rowdash < 0 || coldash <0 || rowdash >= A.length|| coldash >=A[0].length || visited[rowdash][coldash]== true || A[rowdash][coldash]==0){
            continue;
        }
        dfs(rowdash,coldash,visited,A,q);
      }
    
      
  }
}

