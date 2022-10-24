package Arrays;

public class subarrayswith_gcdK {
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currgcd = nums[i];
            if (currgcd == k) {// if current gcd == k ,ans++;
                ans++;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < k) {// if nums[j]<k then even more elements in subarray will give gcd <k, so break;
                    break; // and start subarray with next element
                }
                currgcd = gcd(currgcd, nums[j]);
                if (currgcd == k) {// if current gcd == k ,then ans ++;
                    ans++;
                }
            }
        }
        return ans;

    }
}
