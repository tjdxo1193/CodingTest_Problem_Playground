package TwentyThree.December;

import java.util.*;

public class 한화생명그래프문제 {
    static int N=0;
    static int[][] graph;
    static int[] ch;
    static List<Integer> visited = new ArrayList<>();
    static int maxCount;
    static HashMap<Node, Integer> map = new HashMap<>();
    public static int solution(int n, int[][] edges, int k, int a, int b) {
        int answer = 0;
        N = n;
        graph = new int[n][n];

        maxCount = k;
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
            map.put(new Node(edges[i][0], edges[i][1]), 0);
        }

        ch = new int[edges.length];
        visited.add(a);
        dfs(a, b, 0);

        for(Map.Entry<Node, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int current, int destination, int moveCount) {
        // 이동횟수가
        if (moveCount > maxCount) {
            return;
        }

        if(current==destination){
            Node node;
            int temp;
            // visited[] 에 기록
            for (int i = 0; i < visited.size() - 1; i++) {
                node = new Node(visited.get(i), visited.get(i+1));
                if (!map.containsKey(node)) {
                    temp = node.from;
                    node.from = node.to;
                    node.to = temp;
                }

                map.put(node, 1);
            }
        }
        else{
            // 0번 노드 부터 n 번 노드까지
            for(int i = 0; i<N; i++){
                // 연결되어 있는 노드 중에서 ch 방문하지 않은곳
                if(graph[current][i]==1 && ch[i]==0){
                    ch[i]=1;
                    visited.add(i);
                    dfs(i, destination, moveCount + 1);
                    ch[i]=0;
                    visited.remove(visited.size()-1);
                }
            }
        }
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

    public static class Node{
        int to;
        int from;

        public Node(int to, int from) {
            this.to = to;
            this.from = from;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return to == node.to && from == node.from;
        }

        @Override
        public int hashCode() {
            return Objects.hash(to, from);
        }
    }
}
