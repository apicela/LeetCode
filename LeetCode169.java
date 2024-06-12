import java.util.HashMap;

public class LeetCode169 {
    public static void main(String[] args) {
        var leet = new LeetCode169();

    }
    public int majorityElement(int[] nums) {
        var hmap = new HashMap<Integer, Integer>();
        int max = 0;
        int elementNumber = 0;
        for(int element : nums){
            int valueOfKey = hmap.getOrDefault(element, 0);
            hmap.put(element, valueOfKey++);
            if(max < valueOfKey){
                max = valueOfKey;
                elementNumber = element;
            }
        }
        return elementNumber;
    }
}
