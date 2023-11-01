package TwentyThree.october;

import java.util.*;

public class ConnectingTheIslands {
    /*
문제 설명
n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.

다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다.
예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.

제한사항

섬의 개수 n은 1 이상 100 이하입니다.
costs의 길이는 ((n-1) * n) / 2이하입니다.
임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
연결할 수 없는 섬은 주어지지 않습니다.
     */


    public static void main(String[] args) {
        ConnectingTheIslands islands = new ConnectingTheIslands();

        System.out.println(islands.solution(	4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));

    }

    private static int find(int[] parent, int x) {
        if(parent[x] == x)
            return x;
        else
            return find(parent, parent[x]);
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int[] makeSet(int size) {
        // 각 인덱스에 번호가 대응하도록 사이즈를 1더하여 배열 선언.
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
    public int solution_크루스칼(int n, int[][] costs) {
        int answer = 0;
        int parent[] = makeSet(n);

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];

            if (find(parent, a) != find(parent, b)) {
                union(parent, a, b);
                answer += costs[i][2];
            }
        }

        return answer;
    }


    public class Point implements Comparable<Point>{
        int node, cost;

        public Point (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo (Point o) {
            return this.cost - o.cost;
        }
    }


    public List<List<Point>> map = new ArrayList<>();

    public int solution(int n, int[][] costs) {
        //초기화
        for (int i = 0; i < n; i++)
            map.add(new ArrayList<>());
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int val = costs[i][2];
            map.get(from).add(new Point(to, val));
            map.get(to).add(new Point(from, val));
        }

        //프림 알고리즘
        boolean[] visit = new boolean[n];
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(0, 0));

        int result = 0;
        while(!q.isEmpty()) {
            Point cur = q.poll();

            if (visit[cur.node]) continue;
            visit[cur.node] = true;
            result += cur.cost;

            for (int i = 0; i < map.get(cur.node).size(); i++) {
                int next = map.get(cur.node).get(i).node;
                int cost = map.get(cur.node).get(i).cost;
                if (visit[next]) continue;
                q.add(new Point(next, cost));
            }
        }

        return result;
    }


    public int solution2_실패(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });

        Set<Integer> select = new HashSet<>();

        for (int i = 0; i < costs.length; i++) {
            if (select.size() == n) {
                return answer;
            }
            if (!(select.contains(costs[i][0]) && select.contains(costs[i][1]))) {
                select.add(costs[i][0]);
                select.add(costs[i][1]);
                answer += costs[i][2];
            }
        }

        return answer;
    }
}
