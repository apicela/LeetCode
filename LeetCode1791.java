import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1791 {
    public static void main(String[] args) {
        var leet = new LeetCode1791();
        int edges[][] = {{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(leet.findCenter(edges));
    }
    public int findCenter(int[][] edges) {

        int n1 = edges[0][0];
        int n2 = edges[0][1];
        if(n1 == edges[1][0] || n1 == edges[1][1]){
            return n1;
        } else return n2;
    }
}
