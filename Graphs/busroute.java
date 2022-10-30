package Graphs;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/bus-routes-official/ojquestion
//https://www.youtube.com/watch?v=WhuiqhMXhxM&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=8
import java.io.*;
import java.util.*;

public class busroute {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
            }
        }

        String[] st1 = br.readLine().split(" ");
        int src = Integer.parseInt(st1[0]);
        int dest = Integer.parseInt(st1[1]);
        System.out.println(numBusesToDestination(arr, src, dest));

    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();// Map is used to keep record of
        int n = routes.length;// busstops with buses i.e buses we can board.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[0].length; j++) {
                int bustopno = routes[i][j];
                ArrayList<Integer> busno = map.getOrDefault(bustopno, new ArrayList<>());
                busno.add(i);
                map.put(bustopno, busno);
            }
        }
        Queue<Integer> q = new LinkedList<>();// used for bfs
        HashSet<Integer> busvis = new HashSet<>();// to marks buses visited;
        HashSet<Integer> bustopvis = new HashSet<>();// to mark bus stops visited
        int level = -1;
        q.add(S);// initially adding source in the queue;
        bustopvis.add(S);// mark it visited;
        while (q.size() > 0) {// for level updation
            int size = q.size();
            level++;
            while (size-- > 0) {// for actual bfs
                int rem = q.remove();// removing the source busstop;
                if (rem == T) {
                    return level;
                }
                ArrayList<Integer> buses = map.get(rem);// get arraylist of buses corresponding to the
                for (int bus : buses) { // bus stop,for each loop to get buses one by one
                    if (busvis.contains(bus) == true) { // if bus is already visited then continue,
                        continue;
                    }
                    int[] arr = routes[bus];// get the 1-D array of the first row of 2-D array;
                    for (int bustoop : arr) {// if bustoop is already visited continue, else add it in queue
                        if (bustopvis.contains(bustoop) == true) { // and mark them visited;
                            continue;
                        }
                        q.add(bustoop);
                        bustopvis.add(bustoop);
                    }
                    busvis.add(bus);// after processing the i'th bus we mark it visited, so that whenever
                                    // we reach at this i'th bus again, there is no need to chk it's // stations,
                                    // just skip it;
                }

            }
            // level++;
        }
        return -1;

    }
}
