package DP;

public class minsquare {
    // RECURSIVE APPROACH 
        public static int countsquare(int m) {
            if (m <= 3) {
                return m;
            }
     
            int res = Integer.MAX_VALUE;
            for (int i = 1; i * i <= m; i++) {
    
                int temp =1+ countsquare(m - (i * i));
                res = Math.min(res, temp);
                res = temp;
           
    
            }
            return res;
    
        }
    

        // MEMOIZATION APPROACH 
        public static int countsquareM(int m) {
            int storage[] = new int[m + 1];
            return countsquareM(m, storage);
        }
    
        public static int countsquareM(int m, int storage[]) {
            if (m <= 3) {
                storage[m] = m;
                return storage[m];
            }
            if (storage[m] != 0) {
                return storage[m];
            }
            int res = m;
            for (int i = 1; i * i <= m; i++) {
                int temp = 1 + countsquareM(m - (i * i), storage);
                res = Math.min(res, temp);
                storage[m] = res;
            }
            return storage[m];
    
        }
       

        // DP APPROACH 
        public static int countsquareDP(int m) {
            int storage[] = new int[m + 1];
            storage[0] = 0;
            storage[1] = 1;
            storage[2] = 2;
            storage[3] = 3;
    
            for (int i = 4; i <= m; i++) {
                storage[i] = i;
                for (int j = 0; j * j <= i; j++) {
                    storage[i] = Math.min(storage[i], 1 + storage[i - (j * j)]);
                }
            }
            return storage[m];
        }
    
        public static void main(String[] args) {
            int m = 1000;
            // System.out.println(countsquare(m));
            System.out.println(countsquareM(m));
            System.out.println(countsquareDP(m));
             System.out.println(countsquare(m));
    
        }
    
    }
    

