class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) return true;

        boolean[] visited = new boolean[n];
        visited[source] = true;

        // Loop until there are no changes in the visited nodes
        while (true)
        {
            boolean flag = false; // Flag to track if any new nodes are visited in this iteration

            // Traverse through each edge
            for (int[] edge : edges)
            {
                int u = edge[0], v = edge[1]; // Extracting vertices from the edge

                // If one of the vertices is visited and the other is not, mark both as visited
                if (visited[u] != visited[v])
                {
                    visited[u] = visited[v] = true; // Mark both vertices as visited
                    flag = true; // Set the flag to true, indicating a change in visited nodes

                    // If either of the vertices is the destination, return true
                    if (u == destination || v == destination)
                        return true;
                }
            }

            // If no new nodes are visited in this iteration, break the loop
            if (!flag) break;
        }

        // If the destination is not reachable from the source, return false
        return false;
    }
}