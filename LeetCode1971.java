import java.util.ArrayList;

public class LeetCode1971 {

    boolean[] visited;
    ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) {
        var leet = new LeetCode1971();
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int[][] edges1 = {{0,1},{1,2},{2,0}};
        int[][] edges2 = {{0,4}};

        System.out.println(leet.validPath(6, edges, 0,5));
        System.out.println(leet.validPath(3, edges1, 0,2));
        System.out.println(leet.validPath(5, edges2, 0,4));


    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];
        list = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            list.add(new ArrayList<>());
        }
        // preenchendo a matriz
        for(int[] edge : edges){
            int p1 = edge[0], p2 = edge[1];
            list.get(p1).add(p2);
            list.get(p2).add(p1);
        }
        dfs(source);
        return visited[destination];
    }

    void dfs(int source){
        if(visited[source]) return;
        visited[source] = true;
        for(int i = 0; i< list.get(source).size();i++){
            int index = list.get(source).get(i);
                if(!visited[index]) { dfs(index); }
        }
    }
}

/*
MEMORY LIMIT :

    boolean[] visited;
    boolean[][] matrix;
    public static void main(String[] args) {
        var leet = new LeetCode1971();
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int[][] edges1 = {{0,1},{1,2},{2,0}};
        System.out.println(leet.validPath(6, edges, 0,5));
        System.out.println(leet.validPath(3, edges1, 0,2));

    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         visited = new boolean[n];
         matrix = new boolean[n][n];

        // preenchendo a matriz
        for(int[] edge : edges){
            int p1 = edge[0], p2 = edge[1];
            matrix[p1][p2] = true;
            matrix[p2][p1] = true;
        }
        dfs(source);
        return visited[destination];
    }

    void dfs(int source){
        if(visited[source]) return;
        visited[source] = true;
        for(int i = 0; i< matrix.length;i++){
            if(matrix[source][i] == true){
                if(!visited[i]) { dfs(i); }
            }
        }
    }
 */