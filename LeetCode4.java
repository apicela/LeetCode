import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode4 {
    public static void main(String[] args) {
       int[]  nums1 = {1,1};
        int[]  nums2 = {1,2};
        var leet = new LeetCode4();
        System.out.println(leet.findMedianSortedArrays(nums1, nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int[] arr = new int[nums1.length + nums2.length];
        while(i < nums1.length || i < nums2.length){
            if(i < nums1.length){
                arr[j] = nums1[i];
                j++;
            }
            if(i < nums2.length) {
                arr[j] = nums2[i];
                j++;
            }
            i++;
        }
        Arrays.sort(arr);
        int middle = arr.length/2;
        if(arr.length % 2 == 0){
            return (double) (arr[middle] + arr[middle - 1]) /2;
        } else return arr[(middle)];
    }
}
