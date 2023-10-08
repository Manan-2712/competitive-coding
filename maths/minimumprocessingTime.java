package maths;
import java.util.Collections;
import java.util.List;

public class minimumprocessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks);
        int n = tasks.size();
        Collections.sort(processorTime);
        int ans =0;
        for(int i=0;i<processorTime.size();i++){
             for(int j = n-1;j>=n-4;j--){
                 ans = Math.max(ans,processorTime.get(i) + tasks.get(j));
             }
             n = n-4;
        }
        return ans;
    }
}

