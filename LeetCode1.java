import java.util.HashMap;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> storedValues = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int value = target - nums[i];
            if(storedValues.containsKey(value)){
                return new int[] {i, storedValues.get(value)};
            }
            storedValues.put(nums[i], i);
        }
        return null;
    }
}
