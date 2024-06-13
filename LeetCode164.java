import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode164 {
    public static void main(String[] args) {
        var leet = new LeetCode164();

    }
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for(int i = 0 ; i < nums.length - 1; i++){
            maxGap = Math.max(maxGap, nums[i+1] - nums[i]);
        }
        return maxGap;
    }



}

/*
BUCKET SORT TO ANALYZE AND STUDY AFTER

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int hi = 0, lo = Integer.MAX_VALUE, ans = 0;
        for (int n : nums) {
            hi = Math.max(hi, n);
            lo = Math.min(lo, n);
        }
        int bsize = Math.max((hi - lo) / (nums.length - 1), 1);
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = (hi - lo) / bsize; i >= 0; i--)
            buckets.add(new ArrayList<>());
        for (int n : nums)
            buckets.get((n - lo) / bsize).add(n);
        int currhi = 0;
        for (List<Integer> b : buckets) {
            if (b.isEmpty()) continue;
            int prevhi = currhi > 0 ? currhi : b.get(0), currlo = b.get(0);
            for (int n : b) {
                currhi = Math.max(currhi, n);
                currlo = Math.min(currlo, n);
            }
            ans = Math.max(ans, currlo - prevhi);
        }
        return ans;
    }

 */