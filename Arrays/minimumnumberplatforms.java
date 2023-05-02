import java.util.*;

//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
public class minimumnumberplatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plfneeded = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (arr[i]  <= dep[j] )
                plfneeded++;
                i++;
            } else if (arr[i] > dep[j]) {
                plfneeded--;
                j++;
            }
            if (plfneeded > result) {
                result = plfneeded;
            }
        }
        return result;
    }
