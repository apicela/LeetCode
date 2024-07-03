import java.util.HashSet;

public class LeetCode217 {
    public static void main(String[] args) {
        var leet = new LeetCode217();

    }
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(hset.contains(nums[i])) return true;
            hset.add(nums[i]);
        }
        return false;
    }
}
