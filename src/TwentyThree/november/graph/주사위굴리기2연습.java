package TwentyThree.november.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주사위굴리기2연습 {
    static int[] dice = {1, 2, 3, 4, 5, 6};
    static int N, M, K, dir;

    // 동 - 남 - 서 - 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] map;
    static int d_x, d_y;

    public static class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 방향 (동)
        dir = 0;

        //점수
        int score = 0;

        // 첨음 동쪽으로 한번 굴린거
        int rotate_cnt = 1;

        // 주사위 초기 위치
        d_x = 1;
        d_y = 1;

        while (rotate_cnt++ <= K) {
            d_x += dx[dir];
            d_y += dy[dir];
            // 이동할 수 없는 곳
            if(d_x < 1 || d_x > N || d_y < 1 || d_y > M){
                d_x -= dx[dir];
                d_y -= dy[dir];
                // 이동방향 반대로 전환
                dir = (dir+2) % 4;
                d_x += dx[dir];
                d_y += dy[dir];
            }

            // 주사위 면 변화
            changeDice();

            // 같은 인접한 점수가 몇개 있는지 카운트
            int cnt = bfs();

            // 점수 획득
            score += (cnt*map[d_x][d_y]);

            // 방향변경 : 아랫면이 x, y 좌표와 같은지 큰지, 작은지
            if (dice[5] > map[d_x][d_y]) {
                dir = (dir + 1) % 4;
            } else if(dice[5] < map[d_x][d_y]){
                dir = (dir == 0 ? 3 : dir - 1);
            }
        }

        sb.append(score);
        System.out.println(sb.toString());
    }


    public static void changeDice() {
        int temp = dice[0];
        //  2
        //4 1 3
        //  5
        //  6
//        오른쪽 -> 아래 -> 왼쪽 -> 윗쪽 -> 오른쪽
        switch (dir) {
            case 0: // 동
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 1: // 남
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            case 2: // 서
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
            case 3: // 북
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
        }
    }

    public static int bfs() {
        boolean[][] visited = new boolean[N+1][M+1];
        int cnt = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(d_x, d_y));
        visited[d_x][d_y] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i <= 3; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (1 <= nx && nx <= N && 1 <= ny && ny <= M) {
                    if (!visited[nx][ny] && map[nx][ny] == map[d_x][d_y]) {
                        visited[nx][ny] = true;
                        cnt++;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean isRange(int x, int y) {
        return x < 1 || x > N || y < 1 || y > M;
    }
}
