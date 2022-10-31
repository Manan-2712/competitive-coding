package Graphs;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/pepcoder-and-reversing-official/ojquestion
//https://www.youtube.com/watch?v=Xqq7uELiYnE&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=11
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int vtx;
    int wt;
    public Pair(int vtx,int wt){
        this.vtx= vtx;
        this.wt=wt;
    }
}
public class zero_onebfs {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
         graph.add(new ArrayList<>());
        }
    for(int i=0;i<m;i++){
        st = br.readLine().split(" ");
        int u = Integer.parseInt(st[0])-1;
        int v = Integer.parseInt(st[1])-1;
        graph.get(u).add(new Pair(v, 0));
        graph.get(v).add(new Pair(u,1 ));
    }
    Queue<Pair>q= new LinkedList<>();
    boolean vis[]= new boolean[n];
    q.add(new Pair(0, 0));
    while(!q.isEmpty()){
        Pair rem = q.remove();
        vis[rem.vtx]=true;
        if(rem.vtx==n-1){
            System.out.println(rem.wt);
            return;
        }
        for(Pair nbs: graph.get(rem.vtx)){
            if(vis[nbs.vtx]== true){
                continue;
            }
        
            if(nbs.wt==0){
                q.add(new Pair(nbs.vtx, rem.wt + 0));
            }
            else{
                q.add(new Pair(nbs.vtx, rem.wt + 1));
            }
        }
    }
    System.out.println("-1");
}

}
