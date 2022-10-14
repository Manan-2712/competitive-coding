package coursera.C_3_Algorithms_on_graphs.week5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class node{
    int x;
    int y;
    int parent;
    int rank;
    public node(int x,int y,int parent){
        this.x= x;
        this.y= y;
        this.parent= parent;
        rank=0;
    }
}
class edge{
    int src;
    int dest;
    double weight;
    public edge(int src,int dest,double weight){
        this.src=src;
        this.dest= dest;
        this.weight= weight;
    }
}
public class kruskalalgo {
    public static void makeset(int i,int x[],int y[],node[]nodesarr){
        nodesarr[i]= new node(x[i], y[i], i);
    }
    public static int find(int x,node []nodesarr){
        if(x!=nodesarr[x].parent){
            nodesarr[x].parent= find(nodesarr[x].parent, nodesarr);
        }
        return nodesarr[x].parent;
    }
    public static double weight(int x1,int y1,int x2,int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
    public static void union(int x,int y,node[]nodesarr){
        int x_id= find(x, nodesarr);
        int y_id= find(y, nodesarr);
        if(x_id==y_id){
            return ;
        }
        if(x_id!=y_id){
             if(nodesarr[x_id].rank>nodesarr[y_id].rank){
                nodesarr[y_id].parent= x_id;
             }
             else{
                nodesarr[x_id].parent= y_id;
                if(nodesarr[x_id].rank== nodesarr[y_id].rank){
                    nodesarr[y_id].rank++; 
                }
             }
        }
    }
    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        int n = x.length;
        node[]nodesarr= new node[n];
        for(int i=0;i<n;i++){
            makeset(i, x, y, nodesarr);
        }
       // ArrayList<edge> list = new ArrayList<>();
        PriorityQueue<edge> pq = new PriorityQueue<>(new Comparator<edge>() {
            public int compare(edge o1,edge o2){
            return o1.weight<o2.weight?-1:1;
            }
        });
        for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            pq.offer(new edge(i, j, weight(x[i], y[i], x[j], y[j])));
        }
    }
    int numunion =0;
    while(!pq.isEmpty()){
        edge curredge= pq.poll();
        int src = curredge.src;
        int dest= curredge.dest;
        int src_id= find(src, nodesarr);
        int dest_id = find(dest, nodesarr);
        if(src_id!=dest_id){
            result+=curredge.weight;
            numunion++;
            union(src, dest, nodesarr);
        }
    
    }
              
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }
}

