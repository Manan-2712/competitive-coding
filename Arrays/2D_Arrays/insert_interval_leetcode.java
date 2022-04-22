//https://leetcode.com/problems/insert-interval/submissions/
import java.util.ArrayList;



public class insert_interval_leetcode {
 
        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<int[]> ans= new ArrayList<>();
            int idx =0 ;
            while(idx< intervals.length){
                if(intervals[idx][0] < newInterval[0] ){
                    ans.add(intervals[idx]);
                    idx++;
                }
                else {
                    break;
                }
            }
            if(ans.size()==0 || (newInterval[0]> ans.get(ans.size()-1)[1])){
                ans.add(newInterval);
            }
            else {
                int lastinterval[] = ans.get(ans.size()-1);
                lastinterval[1] = Math.max(lastinterval[1],newInterval[1]);
            }
            while(idx < intervals.length){
                int lastinterval[] = ans.get(ans.size()-1);
                if(intervals[idx][0] <= lastinterval[1] ){
                    lastinterval[1] = Math.max(lastinterval[1],intervals[idx][1]);
                }
                else {
                    ans.add(intervals[idx]);
                }
                idx++;
            }
            return ans.toArray(new int[ans.size()][]);
            
            
        }
    }
    
}
