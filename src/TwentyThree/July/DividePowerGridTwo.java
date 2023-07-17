package TwentyThree.July;

import java.util.*;

public class DividePowerGridTwo {

    /*

       다끊어봐야할거같다
       N이 고작 100 이하니까
       완탐 문제일거같음
       그리고 트리를 끊었을때
       그 트리의

     */
    public static void main(String[] args) {
        DividePowerGridTwo two = new DividePowerGridTwo();
        int[][] wires = {
                {1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
        };
        System.out.println(two.solution1(9, wires));
    }

    public int solution1(int n, int[][] wires) {
        int answer = n;
        int treeANodeCnt = 0;
        int treeBNodeCnt = 0;
        int currentANode = 0;
        int currentBNode = 0;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < wires.length; i++) {
            ArrayList<Integer> integers = hashMap.getOrDefault(wires[i][0], new ArrayList<>());
            integers.add(wires[i][1]);
            hashMap.put(wires[i][0], integers);
        }

        // 간선 없애기 i 순으로 차례대로
        for (int i = 0; i < wires.length; i++) {
            currentANode = wires[i][0];
            currentBNode = wires[i][1];
            temp = hashMap.remove(wires[i][0]);

            // 지금 간선 하나 끊긴 상태 ( wires[i] 번째)
            while (treeANodeCnt + treeBNodeCnt != n) {
                if (hashMap.containsKey(currentANode)) {
                    for (Integer item : hashMap.get(currentANode)) {
                        stack.push(item);
                    }
                    currentANode = stack.peek();
                } else {
                    if (stack.isEmpty()) {
                        stack.pop();
                        treeANodeCnt++;
                    }
                }
                if (hashMap.containsKey(currentBNode)) {
                    for (Integer item : hashMap.get(currentBNode)) {
                        stack.push(item);
                    }
                    currentBNode = stack.peek();
                } else {
                    if (stack.isEmpty()) {
                        stack.pop();
                        treeBNodeCnt++;
                    }
                }
            }

            answer = Math.min(answer, Math.abs(treeANodeCnt - treeBNodeCnt));
            hashMap.put(wires[i][0], temp);
            treeANodeCnt = 0;
            treeBNodeCnt = 0;
        }

        return answer;
    }

    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;
        arr= new int[n+1][n+1];

        //1. 인접행렬에 input
        for(int i=0; i<wires.length; i++){
            arr[wires[i][0]][wires[i][1]]=1;
            arr[wires[i][1]][wires[i][0]]=1;
        }

        //2. 선을 하나씩 끊어보며 순회
        int a, b;
        for(int i=0; i<wires.length; i++){
            a= wires[i][0];
            b= wires[i][1];

            //선을 하나 끊고
            arr[a][b]=0;
            arr[b][a]=0;

            //bfs
            answer= Math.min(answer, bfs(n, a));

            //선 다시 복구
            arr[a][b]=1;
            arr[b][a]=1;
        }

        return answer;
    }

    public int bfs(int n, int start){
        int[] visit= new int[n+1];
        int cnt=1;

        Queue<Integer> queue= new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int point= queue.poll();
            visit[point]= 1;

            for(int i=1; i<=n; i++){ //point와 연결된 애들 중에 방문한적 없는 노드 전부 큐에 넣기
                if(visit[i]==1) continue;
                if(arr[point][i]==1) {
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return (int)Math.abs(n-2*cnt); //cnt-(n-cnt);
    }//bfs
}
