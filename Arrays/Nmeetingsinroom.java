//https://www.codingninjas.com/codestudio/problems/1062658?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

import java.util.*;

class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingcomparator implements Comparator<Meeting> {
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end < o2.end) {
            return -1;
        } else if (o1.end > o2.end) {
            return 1;
        } else if (o1.pos < o2.pos) {
            return -1;
        }
        return 1;
    }
}

public class Nmeetingsinroom {

    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        ArrayList<Meeting> list = new ArrayList<>();
        meetingcomparator mc = new meetingcomparator();
        for (int i = 0; i < start.length; i++) {
            list.add(new Meeting(start[i], end[i], i + 1));
        }
        Collections.sort(list, mc);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(list.get(0).pos);
        int limit = list.get(0).end;
        for (int i = 1; i < start.length; i++) {
            if (list.get(i).start > limit) {
                limit = list.get(i).end;
                ans.add(list.get(i).pos);
            }

        }
        return ans;

    }
}
