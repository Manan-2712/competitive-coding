import java.util.ArrayList;
import java.util.List;
import java.util.*;

//https://www.codingninjas.com/codestudio/problems/1062712?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

class pair {
    int start;
    int finish;
    int pos;

    pair(int start, int finish, int pos) {
        this.start = start;
        this.finish = finish;
        this.pos = pos;
    }
}

class paircomparator implements Comparator<pair> {
    public int compare(pair p1, pair p2) {
        if (p1.finish < p2.finish) {
            return -1;
        } else if (p1.finish > p2.finish) {
            return 1;
        } else if (p1.pos < p2.pos) {
            return -1;
        }
        return 0;
    }

}

public class maximumactivities {

    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        paircomparator pc = new paircomparator();
        List<pair> list = new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {
            list.add(new pair(start.get(i), end.get(i), i));
        }
        Collections.sort(list, pc);
        int limit = list.get(0).finish;
        int n = start.size();
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (list.get(i).start >= limit) {
                limit = list.get(i).finish;
                count++;
            }
        }
        return count;
    }
}
