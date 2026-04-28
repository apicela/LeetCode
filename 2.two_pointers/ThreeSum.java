import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum { 
        public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) return res;

            int left  = i + 1, right = nums.length - 1; 
            while(left < right){
                int soma = nums[i] + nums [left] + nums[right];
                if(soma > 0) right--;
                else if (soma < 0) left++;
                else if(soma == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
