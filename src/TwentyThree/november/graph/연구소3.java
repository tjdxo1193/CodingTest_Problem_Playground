package TwentyThree.november.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3 {
    /*
    인체에 치명적인 바이러스를 연구하던 연구소에 승원이가 침입했고, 바이러스를 유출하려고 한다.
    바이러스는 활성 상태와 비활성 상태가 있다. 가장 처음에 모든 바이러스는 비활성 상태이고,
    활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제되며, 1초가 걸린다.
    승원이는 연구소의 바이러스 M개를 활성 상태로 변경하려고 한다.

    연구소는 크기가 N×N인 정사각형으로 나타낼 수 있으며,
    정사각형은 1×1 크기의 정사각형으로 나누어져 있다.
    연구소는 빈 칸, 벽, 바이러스로 이루어져 있으며,
    벽은 칸 하나를 가득 차지한다. 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.

    예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자. 0은 빈 칸, 1은 벽, 2는 바이러스의 위치이다.

     M = 3이고, 바이러스를 아래와 같이 활성 상태로 변경한 경우 6초면 모든 칸에 바이러스를 퍼뜨릴 수 있다.
     벽은 -, 비활성 바이러스는 *, 활성 바이러스는 0, 빈 칸은 바이러스가 퍼지는 시간으로 표시했다.

     시간이 최소가 되는 방법은 아래와 같고, 4초만에 모든 칸에 바이러스를 퍼뜨릴 수 있다.

     연구소의 상태가 주어졌을 때, 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간을 구해보자.

     첫째 줄에 연구소의 크기 N(4 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M(1 ≤ M ≤ 10)이 주어진다.
    둘째 줄부터 N개의 줄에 연구소의 상태가 주어진다.
    0은 빈 칸, 1은 벽, 2는 비활성 바이러스의 위치이다.
    2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수이다.

    연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간을 출력한다.
    바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우에는 -1을 출력한다.
     */
    static int map[][];
    static int N, M;
    static ArrayList<Node> list;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int time = Integer.MAX_VALUE;
    static Node[] virusArr;
    static int originEmptySpace = 0;
    static class Node{
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


    public static void main(String arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virusArr = new Node[M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    list.add(new Node(i, j, 0));
                } else if (map[i][j] == 0) {
                    originEmptySpace++;
                }
            }
        }
        // solution
        if (originEmptySpace == 0) {
            System.out.println(0);
        } else {
            selectVirus(0, 0);
            System.out.println(time == Integer.MAX_VALUE ? -1 : time);
        }

    }


    private static void selectVirus(int start, int selectCount) {
        // 종료조건
        if(selectCount == M) {
            spreadVirus(originEmptySpace);
            return;
        }

        // 조합
        for(int i = start; i < list.size(); i++) {
            virusArr[selectCount] = list.get(i);
            selectVirus(i + 1, selectCount + 1);
        }
    }


    private static void spreadVirus(int emptySpace) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] infected = new boolean[N][N];
        for(int i = 0; i < M; i++) {
            Node virus = virusArr[i];
            infected[virus.x][virus.y] = true;
            queue.add(virus);
        }

        while(!queue.isEmpty()) {

            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 확산하지 않을 조건
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if(infected[nx][ny] || map[nx][ny] == 1) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    emptySpace--;
                }

                if(emptySpace == 0) {
                    time = Math.min(time, node.time + 1);
                    return;
                }

                infected[nx][ny] = true;
                queue.add(new Node(nx, ny, node.time + 1));
            }

        }


    }
}
