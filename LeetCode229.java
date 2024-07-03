import java.util.ArrayList;
import java.util.List;

public class LeetCode229 {
    public static void main(String[] args) {
        var leet = new LeetCode229();
        int[] arr = {3,3, 3,2,3, 3, 3};
        var x = leet.majorityElement(arr);
        System.out.println(x);
    }
    public List<Integer> majorityElement(int[] nums) {
        int n =nums.length;
        int l = n/3;
        List<Integer> list = new ArrayList<>();
        int count1 =0, count2 =0;
        int el1 =0, el2 =0;

        for(int i=0; i<n;i++){
            if(count1 ==0 && nums[i] != el2){
                el1 = nums[i];
                count1 =1;
            }
            else if(count2 ==0 && nums[i] != el1){
                el2 = nums[i];
                count2 =1;
            }
            else if(nums[i] == el1) count1++;
            else if(nums[i] == el2) count2++;
            else {
                count1--;
                count2--;
            }

        }
        count1 =0;
        count2 =0;
        for(int i=0; i<n; i++){
            if(el1 == nums[i]) count1++;
            else if(el2 == nums[i]) count2++;

        }
        if(count1 > l) list.add(el1);
        if(count2 > l) list.add(el2);
        return list;
    }
}
