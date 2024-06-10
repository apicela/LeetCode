package LeetCode;

import java.util.LinkedHashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LeetCode387 {
    public static void main(String[] args) {
        LeetCode387 challenge = new LeetCode387();
        String s = "loveleetcode";
        System.out.println(challenge.firstUniqChar(s));

    }

    public  int firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();

        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            if (map.get(letter) == null) {
                map.put(letter, true);
            } else {
                map.put(letter, false);
            }
        }

        for(int i = 0; i < s.length(); i++){
            char letter = s.charAt(i);
            Boolean unique = map.get(letter);
            if(unique){
                return i;
            }
        }
        return -1;
    }
}