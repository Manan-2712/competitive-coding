package Graphs;

public class floodfillalgo {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor = image[sr][sc];
        int[][] ans = image;
        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, +1, 0, -1 };
        dfs(ans, image, sr, sc, inicolor, color, delrow, delcol);
        return ans;

    }

    public void dfs(int ans[][], int[][] image, int row, int col, int inicolor, int newcolor, int[] delrow,
            int[] delcol) {
        ans[row][col] = newcolor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int newrow = row + delrow[i];
            int newcol = col + delcol[i];
            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && image[newrow][newcol] == inicolor
                    && ans[newrow][newcol] != newcolor) {
                dfs(ans, image, newrow, newcol, inicolor, newcolor, delrow, delcol);
            }
        }
    }
}
