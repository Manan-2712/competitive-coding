
import java.util.*;
//https://leetcode.com/problems/spiral-matrix/description/
public class spiralorder {
        public List<Integer> spiralOrder(int[][] matrix) {
            
            int minrow= 0;
            int mincol=0;
            int maxrow= matrix.length -1;
            int maxcol = matrix[0].length -1;
            // to avoid repetition
             boolean [][]visited = new boolean[matrix.length][matrix[0].length];
             for(int i=0;i<matrix.length;i++){
                 for(int j =0;j<matrix[0].length;j++){
                     visited[i][j]= false;
                 }
             }
            List<Integer> res = new ArrayList<>();
            if(matrix.length ==0 ){
                return res;
            }
            while(minrow <= maxrow && mincol <= maxcol ){
             //  while(true){
                // right traversal
                for(int i= minrow,j = mincol;j<= maxcol;j++){
                    if(!visited[i][j]){
                    res.add(matrix[i][j]);
                    }
                    visited[i][j]= true;
    
                }
                minrow++;
                // down traversal
                for(int i= minrow,j= maxcol;i<=maxrow;i++){
                    if(!visited[i][j]){
                    res.add(matrix[i][j]);
                    }
                     visited[i][j]= true;
    
                }
                maxcol--;
                // left traversal;
                for(int i = maxrow,j= maxcol;j>=mincol;j--){
                    if(!visited[i][j]){
                    
                    res.add(matrix[i][j]);
                    }
                    visited[i][j]= true;
                }
                maxrow--;
                // up traversal
                for(int i = maxrow,j= mincol;i>= minrow;i--){
                    if(!visited[i][j]){
                    
                    res.add(matrix[i][j]);
                    }
                    //res.add(matrix[i][j]);
                    visited[i][j]= true;
                }
                mincol++;
           // return res;
            }
            return res;
            
        }
    }

