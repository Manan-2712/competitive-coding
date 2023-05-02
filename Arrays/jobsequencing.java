import java.util.*;
import java.io.*;

//https://www.codingninjas.com/codestudio/problems/job-sequencing-problem_1169460?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class jobsequencing {

    public static int jobScheduling(int[][] jobs) {
        // sort on basis of max profit.
        Arrays.sort(jobs, (a, b) -> (b[1] - a[1]));
        int maxi = 0;
        int profit = 0;
        int n = jobs.length;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(jobs[i][0], maxi);
        }
        // System.out.println(maxi);

        int result[] = new int[maxi + 1];
        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = jobs[i][0]; j >= 0; j--) {
                if (result[j] == -1) {
                    result[j] = i;
                    profit += jobs[i][1];
                    break;

                }
            }
        }
        return profit;

    }
}
