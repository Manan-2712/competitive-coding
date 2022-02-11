package Arrays;

public class FirstMissingPositive {

    public static int firstMissing(int[] arr, int n) {
        boolean one = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                one = true;
            }
            if (arr[i] < 1 || arr[i] > n) {
                arr[i] = 1;
            }

        }
        if (one == false) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);
            arr[index - 1] = -1 * Math.abs(arr[index - 1]);

        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
