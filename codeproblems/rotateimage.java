package codeproblems;
//https://leetcode.com/problems/rotate-image/
public class rotateimage {
        void transpose(int [][]matrix){
            int i;
            int j;
           // int temp[][]= new int [matrix.length];
            for(i=0;i<matrix.length;i++){
                for( j=0;j<i;j++){
                   int  temp= matrix[i][j];
                    matrix[i][j]= matrix[j][i];
                    matrix[j][i]= temp;
                
            }
        }
        }
        void reverse(int [][]matrix){
            for(int i=0;i<matrix.length;i++){
                int left=0;
                int right= matrix.length-1;
                while(left<right){
                    int temp= matrix[i][left];
                    matrix[i][left]= matrix[i][right];
                    matrix[i][right]=temp;
                 left++;
                    right--;
                }
            }
        }
        public void rotate(int[][] matrix) {
            transpose(matrix);
            reverse(matrix);
            
        }
    }
}
