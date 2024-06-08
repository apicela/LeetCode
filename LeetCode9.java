public class LeetCode9 {
    public static void main(String[] args) {
        var test = new LeetCode9();
        System.out.println(test.isPalindrome(120021));
    }
    public boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int size = number.length();
        for(int i = 0; i < size/2;i ++){
            if(number.charAt(i) != number.charAt(size - i - 1)) return false;
        }
        return true;
    }
}

// 0 1 2 3 4 5
// size:
// 5 -> 0
// 4 -> 1
// 3 -> 2
