public class floodfill {
        public static void helper(int image[][],int sr,int sc,int color,boolean [][]isvisited,int start){
            if(sr<0 || sc<0 || sr>= image.length || sc>=image[0].length||  image[sr][sc]!=start || isvisited[sr][sc]== true){
                return ;
            }
            isvisited[sr][sc]= true;
            image[sr][sc]= color;
            helper(image,sr-1,sc,color,isvisited,start);
            helper(image,sr+1,sc,color,isvisited,start);
            helper(image,sr,sc+1,color,isvisited,start);
            helper(image,sr,sc-1,color,isvisited,start);
            
    
            
            
            
        }
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            int n = image.length;
            int m = image[0].length;
            int start = image[sr][sc];// if sr =0 and sc = 0 ,to handle this case start variable is used.
            boolean isvisited[][]= new boolean[n][m];
            helper(image,sr,sc,color,isvisited,start);
            return image;
            
        }
    }
