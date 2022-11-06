package Graphs;
//https://leetcode.com/problems/swim-in-rising-water/submissions/
//https://www.youtube.com/watch?v=Wq1NibUMrNU&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=17
import java.util.PriorityQueue;

public class swiminrisingwater {
        public int swimInWater(int[][] grid) {// Application of dijkstra 
          int n = grid.length;
          PriorityQueue<Pair> pq = new PriorityQueue<>();
          pq.add (new Pair(0,0,grid[0][0]));
          boolean [][]vis = new boolean[n][n];
          int dirs[][]= {{1,0},{0,1},{-1,0},{0,-1}};
          while(!pq.isEmpty()){
              Pair rem = pq.remove();
              if(rem.row ==n-1 && rem.col== n-1 ){
                  return rem.msf;
              }
              if(vis[rem.row][rem.col]== true){
                  continue;
              }
              vis[rem.row][rem.col]= true;
              for(int i=0;i<4;i++){
                  int rowdash = rem.row+dirs[i][0];
                  int coldash = rem.col+dirs[i][1];
                  if(rowdash <0 || coldash <0 || rowdash>=n || coldash >=n || vis[rowdash][coldash] == true){
                      continue;
                  }
                  pq.add(new Pair(rowdash,coldash,Math.max(rem.msf,grid[rowdash][coldash])));// to store the maximum value in path so far ;
                  
              }
              
          }
          return 0;
          
          
      }
      public class Pair implements Comparable<Pair>{
          int row;
          int col;
          int msf;
          public Pair(int row,int col,int msf){
              this.row= row;
              this.col= col;
              this.msf = msf;
          }
          public int compareTo(Pair o){
              return this.msf- o.msf;
          }
      }
    }
    

