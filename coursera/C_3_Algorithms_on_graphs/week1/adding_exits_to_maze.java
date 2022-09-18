package coursera.C_3_Algorithms_on_graphs.week1;
import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Scanner;

public class adding_exits_to_maze {

    private static int numberOfComponents(ArrayList<Integer>[] adj) {
     int result =0;
     boolean isvisited[]= new boolean[adj.length];
     for(int i=0;i<adj.length;i++){ // loop over visited array to check ,if any 
     if(isvisited[i]==false){     // comp[onent of graph left
        explore(adj, i, isvisited);
        result++;
     }
     }
    return result;     
        
    }
       public static void explore(ArrayList<Integer>[]adj,int src,boolean[]isvisited){ 
        isvisited[src]= true;
        for(int i=0;i<adj.length;i++){
            for(Integer elem:adj[src]){
              if(isvisited[elem]==false){
                explore(adj, elem, isvisited);
              }
            }
        }
       }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}
