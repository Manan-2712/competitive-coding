package Graphs;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/optimize-water-distribution-official/ojquestion
//https://www.youtube.com/watch?v=gc6ShDTldb4&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=16
import java.io.*;
import java.util.*;
public class optimisedwatersuplly {



  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int v = Integer.parseInt(st[0]);
    int e = Integer.parseInt(st[1]);

    int[] wells = new int[v];
    String[] words = br.readLine().split(" ");

    for (int i = 0; i < wells.length; i++) {
      wells[i] = Integer.parseInt(words[i]);
    }

    int[][] pipes = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st1 = br.readLine().split(" ");
      pipes[i][0] = Integer.parseInt(st1[0]);
      pipes[i][1] = Integer.parseInt(st1[1]);
      pipes[i][2] = Integer.parseInt(st1[2]);

    }

    System.out.println(minCostToSupplyWater(v, wells, pipes));

  }

  public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
      ArrayList<ArrayList<Pair>>graph = new ArrayList<>();
      for(int i=0;i<=n;i++){
          graph.add(new ArrayList<>());
          
      }
      for(int i=0;i<pipes.length;i++){
           int u = pipes[i][0];
           int v = pipes[i][1];
           int wt = pipes[i][2];
           graph.get(u).add(new Pair(v,wt));
           graph.get(v).add(new Pair(u,wt));
      }
      for(int i=1;i<=n;i++){// this is dummy node (0) to handle the cost of digging of well ,so that 
          graph.get(i).add(new Pair(0,wells[i-1]));// it becomes easy for us to implement mst 
          graph.get(0).add(new Pair(i,wells[i-1]));// This question is  mixture of dijkstra and kruskal
      }
        int ans =0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean isvisited[]= new boolean[n+1];
        pq.add(new Pair(0,0));
        //isvisited[0]= true;
        while(!pq.isEmpty()){
            Pair rem = pq.remove();
            if(isvisited[rem.vtx]== true){
                continue;
            }
            ans+=rem.wt;
            isvisited[rem.vtx]= true;
            ArrayList<Pair> nbrs = graph.get(rem.vtx);
            for(Pair nbr : nbrs){
               if(isvisited[nbr.vtx]== false){
                   pq.add(nbr);
               }
            }
            
            
        }
        return ans;
  }
  public static class Pair implements Comparable<Pair>{
      int vtx;
      int wt;
      public Pair(int vtx,int wt){
          this.vtx = vtx;
          this.wt = wt;
      }
      public int compareTo(Pair o){
        return this.wt- o.wt;
      }
  }
}

