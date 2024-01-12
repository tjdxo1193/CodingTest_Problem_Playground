package TwentyThree.December;

import java.util.ArrayList;

public class 한화생명_코테1 {

    static class Edge {
        int to;

        public Edge(int to) {
            this.to = to;
        }
    }

    static int count = 0;

    public static int solution(int n, int[][] edges, int k, int a, int b) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(new Edge(v));
            graph[v].add(new Edge(u));
        }

        boolean[] visited = new boolean[n];
        dfs(graph, a, b, k, visited, 0);

        return count;
    }

    public static void dfs(ArrayList<Edge>[] graph, int current, int destination, int k, boolean[] visited, int moves) {
        visited[current] = true;

        if (current == destination && moves <= k) {
            count++;
        }

        if (moves < k) {
            for (Edge neighbor : graph[current]) {
                int nextNode = neighbor.to;

                if (!visited[nextNode]) {
                    dfs(graph, nextNode, destination, k, visited, moves + 1);
                }
            }
        }

        visited[current] = false;
    }

    public static void main(String[] args) {
        // 예시
        int n = 8;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 0}, {5, 1},{6, 1},{7, 2},{7, 3},{4, 5},{5, 6},{6, 7}};
        int k = 4;
        int a = 0;
        int b = 3;

        int result = solution(n, edges, k, a, b);
        System.out.println(result);
    }
}

