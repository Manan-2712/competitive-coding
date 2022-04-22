import java.util.ArrayList;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class insert_intervals {

    // Definition for an interval.

    public class Solution {
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            ArrayList<Interval> ans = new ArrayList<>();
            int idx = 0;
            while (idx < intervals.size()) {
                if (intervals.get(idx).start < newInterval.start) {
                    ans.add(intervals.get(idx));
                    idx++;
                } else {
                    break;
                }
            }

            if (ans.size() == 0 || (newInterval.start > ans.get(ans.size() - 1).end)) {
                ans.add(newInterval);
            } else {
                Interval lastinterval = ans.get(ans.size() - 1);
                lastinterval.end = Math.max(lastinterval.end, newInterval.end);
            }
            while (idx < intervals.size()) {
                Interval lastinterval = ans.get(ans.size() - 1);
                if (lastinterval.end >= intervals.get(idx).start) {
                    lastinterval.end = Math.max(lastinterval.end, intervals.get(idx).end);
                } else {
                    ans.add(intervals.get(idx));
                }
                idx++;
            }
            return ans;

        }
    }

}
