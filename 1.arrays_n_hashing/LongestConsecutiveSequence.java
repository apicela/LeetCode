import java.util.*;


class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 1, count = 1;
        Arrays.sort(nums);
        for(int i =1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            else if(nums[i] == nums[i-1] + 1){
                count++;
                max = Math.max(count,max);
            }
            else count = 1;
        }
        return max;
    }
}
