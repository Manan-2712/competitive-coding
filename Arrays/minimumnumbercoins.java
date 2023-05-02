import java.util.*;
import java.io.*;

public class minimumnumbercoins {

    public static int findMinimumCoins(int amount) {

        int curr[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int n = curr.length;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= curr[i]) {
                amount -= curr[i];
                count++;

            }
        }
        return count;

    }
}
