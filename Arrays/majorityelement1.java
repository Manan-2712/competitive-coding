package Arrays;

public class majorityelement1 {
    public int majorityElement(int[] nums) {
        // Brute Force Approach
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        // int count =0;
        // for(int j =0;j<n;j++){
        // if(nums[i]== nums[j]){
        // count ++;
        // }
        // }
        // if(count > n/2){
        // return nums[i];
        // }

        // }
        // return -1;
        // }
        // }




        // Better Approach - using Hashing or HashMaps
        // int n = nums.length;
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<n;i++){
        // map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }
        // for (Map.Entry<Integer, Integer> it : map.entrySet()) {
        // if (it.getValue() > (n / 2)) {
        // return it.getKey();
        // }
        // }

        // return -1;
        // }

        // }

        
        // OPTIMAL APPROACH
        // USING MOORE'S VOTING ALGORITHM
        int count = 0;
        int elem = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                elem = nums[i];
                count = 1;
            } else if (nums[i] == elem) {
                count++;
            } else {
                count--;
            }
        }
        int count1 = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == elem) {
                count1++;
            }
            if (count1 > nums.length / 2) {
                return elem;
            }

        }
        return -1;

    }
}
