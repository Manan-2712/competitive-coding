package coursera.C_2_Data_Structures.week_3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {
    private int numWorkers;
    private int[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
        // for (int m : assignedWorker) {
        // System.out.print(m + " ");
        // }
        // System.out.println();
        // for (long n : startTime) {
        // System.out.print(n + " ");
        // }
    }

    private void assignJobs() {
        // TODO: replace this code with a faster algorithm.
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        // long[] nextFreeTime = new long[numWorkers];
        // for (int i = 0; i < jobs.length; i++) {
        // int duration = jobs[i];
        // int bestWorker = 0;s
        // for (int j = 0; j < numWorkers; ++j) {
        // if (nextFreeTime[j] < nextFreeTime[bestWorker])
        // bestWorker = j;
        // }
        // assignedWorker[i] = bestWorker;
        // startTime[i] = nextFreeTime[bestWorker];
        // nextFreeTime[bestWorker] += duration;
        // }

        PriorityQueue<worker> q = new PriorityQueue<>(numWorkers, new workercomparator());
        for (int i = 0; i < numWorkers; i++) {
            q.offer(new worker(i));
        }
        for (int i = 0; i < jobs.length; i++) {
            worker front = q.poll();
            assignedWorker[i] = front.id;
            startTime[i] = front.nextFreeTime;
            front.nextFreeTime += jobs[i];
            q.offer(front);
        }

    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    class worker {
        int id;
        long nextFreeTime;

        public worker(int id) {
            this.id = id;
            this.nextFreeTime = 0;
        }
    }

    class workercomparator implements Comparator<worker> {
        public int compare(worker w1, worker w2) {
            if (w1.nextFreeTime == w2.nextFreeTime) {
                return w1.id - w2.id;
            } else {
                return (int) (w1.nextFreeTime - w2.nextFreeTime);
            }
        }
    }

}
