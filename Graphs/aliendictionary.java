//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/alien-dictionary-official/ojquestion
//https://www.youtube.com/watch?v=_u1Mn4_2hIo&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ&index=13
package Graphs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class aliendictionary {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] words = br.readLine().split(" ");

        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        for (String st : words) {
            for (char ch : st.toCharArray()) {
                indegree.put(ch, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            boolean flag = false; // to handle edge case;
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                if (ch1 != ch2) {
                    HashSet<Character> set = new HashSet<>();
                    if (map.containsKey(ch1) == true) {
                        set = map.get(ch1);
                        if (set.contains(ch2) == false) {
                            set.add(ch2);
                            indegree.put(ch2, indegree.get(ch2) + 1);
                            map.put(ch1, set);
                        }
                    } else {
                        set.add(ch2);
                        indegree.put(ch2, indegree.get(ch2) + 1);
                        map.put(ch1, set);

                    }
                    flag = true;
                    break;
                }
            }
            if (flag == false && curr.length() > next.length()) {
                return " ";
            }
        }
        // KAHN'S ALGORITHM
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : indegree.keySet()) {
            if (indegree.get(ch) == 0) {
                q.add(ch);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            Character rem = q.remove();
            sb.append(rem);
            count++;

            if (map.containsKey(rem) == true) {
                HashSet<Character> nbrs = map.get(rem);
                for (char nbr : nbrs) {
                    indegree.put(nbr, indegree.get(nbr) - 1);
                    if (indegree.get(nbr) == 0) {
                        q.add(nbr);
                    }
                }
            }
        }
        if (count == indegree.size()) {
            return sb.toString();
        } else {
            return " ";
        }

    }
}
