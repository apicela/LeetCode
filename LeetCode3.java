import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3 {
    public static void main(String[] args) {
        var leet = new LeetCode3();
        var ans1 =   leet.lengthOfLongestSubstring("abcdefghjklewroewjfeofjeodjeiodjiasdjsiadhsaidsaifhsiafsiafsafiekowfoweifhweopfkoewfhioewojjowetjowoejtjowejotoewjtowrietjrioetjretorejtiorethretuiorhetuorehturethroetretuhretohretuorhretoretretretretretretre");
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int biggest = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (hashSet.contains(s.charAt(j))) {
                    break;
                }
                hashSet.add(s.charAt(j));
                if (j == length - 1) {
                    return Math.max(biggest, hashSet.size());
                }
            }
            biggest = Math.max(biggest, hashSet.size());
            hashSet.clear();
        }
        return biggest;
    }
}
