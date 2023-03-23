//https://leetcode.com/problems/jump-game/description/
public class jumpgame {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        // if(nums[0]==0 && nums.length > 0){
        // return false;
        // }
        // int previousreach =0;
        for (int i = 0; i <= reachable; i++) {
            if (reachable >= nums.length - 1) {
                return true;
            }
            reachable = Math.max(reachable, i + nums[i]);
            // previousreach = reachable;
        }
        return false;
    }
}
