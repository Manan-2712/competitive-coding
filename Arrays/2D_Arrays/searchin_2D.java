//https://leetcode.com/problems/search-a-2d-matrix/description/
public class searchin_2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Brute Force approach is just linear traversal and find target.

        // Better approach1 below using binary search on each row of matrix.
        // if(matrix.length ==0){
        // return false;
        // }
        // int row = matrix.length-1;
        // int col = matrix[0].length-1;
        // int right = col;
        // int left = 0;
        // int top = 0;
        // while(top <= row){
        // left = 0;
        // right = col;
        // while( left <= right ){
        // int mid = (left + right)/2;
        // if(matrix[top][mid]== target){
        // return true;
        // }
        // else if (matrix[top][mid]> target){
        // right = mid -1;
        // }
        // else {
        // left = mid+1;

        // }
        // }
        // top++;
        // }

        // return false;

        // }

        // Better Approach 2
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int i = 0;
        // int j = matrix[0].length -1;
        // while(i < m && j>=0){
        // if(matrix[i][j]== target){
        // return true;
        // }
        // else if(matrix[i][j]> target){
        // j--;
        // }
        // else{
        // i++;
        // }
        // }
        // return false;

        // OPTIMAL APPROACH
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix.length == 0) {
            return false;
        }
        int low = 0;
        int high = (m * n) - 1;
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            // Point to Remember -> divide always by total no.of coloumns and take divide
            // first then modulo.
            int col = mid / (n);
            int row = mid % (n);
            if (matrix[col][row] == target) {
                return true;
            } else if (matrix[col][row] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;

    }
}
