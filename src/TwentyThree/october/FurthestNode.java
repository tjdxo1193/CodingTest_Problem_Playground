package TwentyThree.october;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FurthestNode {

    /*
가장 먼 노드
문제 설명
n개의 노드가 있는 그래프가 있습니다.
각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

제한사항
노드의 개수 n은 2 이상 20,000 이하입니다.
간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

입출력 예
n	vertex	return
6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3

입출력 예 설명

예제의 그래프를 표현하면 아래 그림과 같고,
1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.

     */

    static ArrayList<ArrayList<Integer>> graph; //integer를 저장할 수 있는 ArrayList를 저장하는 ArrayList
    static int[] ch, dis; //방문 기록, 레벨 기록

    public static void main(String[] args) {

    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        // BFS를 사용하여 각 노드로 부터 최단 거리 구하고, 정렬하여 가장 먼 노드를 구한다.

        // BFS 를 이용해서 비가중치 그래프의 최단 거리를 구할때
        // 순환되는 노드를 처리해줘야함.
        

        return answer;
    }

    public static void bfs(int v) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(v); //0레벨 루트
        int L = 0; //레벨

        while(!Q.isEmpty()) {
            int len = Q.size();

            //큐 순회
            for(int i=0; i<len; i++) {
                int cv = Q.poll(); //꺼냄

                //x 정점이 갈 수 있는 정점 순회
                for(int nv : graph.get(cv)) {
                    if(ch[nv] == 0) { //방문한 적이 없으면
                        ch[nv] = 1; //방문 기록
                        dis[nv] = L+1; //레벨 기록
                        Q.offer(nv); //큐에 추가
                    }
                }

            }
            L++; //큐 순회가 끝나면 레벨 증가
        }
    }
}
