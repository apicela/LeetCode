import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
       public int lengthOfLongestSubstring(String s) {
        int[] lastIndexCharacter = new int[128];
        Arrays.fill(lastIndexCharacter, -1);
        int count = 0, max = 0, start = 0;
        for(int i =0; i < s.length(); i++){
            int ch = s.charAt(i);
            if(lastIndexCharacter[ch] >= start){
            start = lastIndexCharacter[ch] + 1;
            count = i - start + 1; 
            } else {
                count++;
            }
            lastIndexCharacter[ch] = i;
            max = Math.max(count, max);
        }
        return max;
    }
}
