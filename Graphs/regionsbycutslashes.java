package Graphs;
//https://leetcode.com/problems/regions-cut-by-slashes/submissions/856569715/
//https://www.youtube.com/watch?v=Wafu5vOxPRE&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=29
public class regionsbycutslashes {
        static int[] parent;
        static int[] rank;
        static int count;
           public static int find(int x, int[] par) {
            if (x == par[x]) {
                return x;
            }
            int temp = find(par[x], par);
            par[x] = temp;
            return temp;
        }
        public static void union(int x,int y){
         int lx = find(x,parent);
         int ly = find(y,parent);
         if(lx!=ly){
         if(rank[lx]> rank[ly]){
             parent[ly]= lx;
         }
         else if(rank[ly] > rank[lx]){
             parent[lx]= ly;
         }
         else{
             parent[ly ]= lx;
             rank[lx]++;
         }
        }
        else{
            count++;
        }
        }
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            int dots =n+1;
         parent= new int[dots*dots];
         rank= new int[dots*dots];
         count =1;
         for(int i=0;i< parent.length;i++){
             parent[i]=i;
             rank[i]=1;
         }  
         // for boundary connection  
         for(int i=0;i<dots;i++){
             for(int j =0;j<dots;j++){
                 if(i==0 || j==0 || i==dots-1 || j== dots-1){
                     int cellno = i*dots+j;
                     if(cellno!=0)
                     union(0,cellno);
                 }
             }
         }
         for(int i=0;i<grid.length;i++){
             char arr[]= grid[i].toCharArray();
             for(int j=0;j<arr.length;j++){
                 if(arr[j]=='/'){
                 int cellno1= i*dots+(j+1);
                 int cellno2= (i+1)*dots+j;
                 union(cellno1,cellno2);
                 }
                 else if(arr[j]== '\\'){
                     int cellno1= i*dots+j;
                     int cellno2= (i+1)*dots+(j+1);
                     union(cellno1,cellno2);
    
                 }
    
             }
         }
         return count;
    
        }
    }

