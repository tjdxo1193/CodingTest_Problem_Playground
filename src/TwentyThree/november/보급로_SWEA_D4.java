package TwentyThree.november;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 보급로_SWEA_D4 {
    /*
    ※ SW Expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

2차 세계 대전에서 연합군과 독일군의 전투가 점점 치열해지고 있다.

전투가 진행중인 지역은 대규모 폭격과 시가전 등으로 인해 도로 곳곳이 파손된 상태이다.

그림 1(a)에서와 같이 도로들은 전투로 인해 트럭이나 탱크와 같은 차량들이 지날 갈 수 없다.

전투에서 승리하기 위해서는 기갑사단과 보급부대가 신속하게 이동하기 위한 도로가 있어야 한다.

공병대는 출발지(S) 에서 도착지(G)까지 가기 위한 도로 복구 작업을 빠른 시간 내에 수행하려고 한다.

도로가 파여진 깊이에 비례해서 복구 시간은 증가한다.

출발지에서 도착지까지 가는 경로 중에 복구 시간이 가장 짧은 경로에 대한 총 복구 시간을 구하시오.

깊이가 1이라면 복구에 드는 시간이 1이라고 가정한다.

지도 정보는 그림1(b)와 같이 2차원 배열 형태로 표시된다.

출발지는 좌상단의 칸(S)이고 도착지는 우하단의 칸(G)가 된다.

이동 경로는 상하좌우 방향으로 진행할 수 있으며, 한 칸씩 움직일 수 있다.

지도 정보에는 각 칸마다 파여진 도로의 깊이가 주어진다. 현재 위치한 칸의 도로를 복구해야만 다른 곳으로 이동할 수 있다.

[입력]

가장 첫 줄은 전체 테스트케이스의 수이다.

각 테스트 케이스마다 지도의 크기(N x N)가 주어진다. 지도의 크기는 최대 100 x 100이다.

그 다음줄 부터 지도의 크기만큼 2차원 배열 형태의 지도 정보가 주어진다.

[출력]

각 테스트 케이스의 답을 순서대로 출력하며, 각 케이스마다 줄의 시작에 “#C”를 출력하여야 한다.

이때 C는 케이스의 번호이다.

같은 줄에 빈 칸을 하나 두고, 주어진 입력에서 출발지에서 도착지까지 가는 경로 중에 복구 작업에 드는 시간이 가장 작은 경로의 복구 시간을 출력하시오.
     */
    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int time;
    // 상하좌우 높이가 x , 너비가 y
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            time = Integer.MAX_VALUE;
            String input;
            for (int i = 0; i < N; i++) {
                input = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }
            move(0, 0 , 0);
            System.out.println("#" + test_case + " " + time);
        }
    }

    private static void move(int x, int y, int t) {
        System.out.println("X: " + x + " Y: " + y + " T: " + t);
        if (time <= t) {
            return;
        }

        if (x == N - 1 && y == N - 1) {
            time = Math.min(time, t);
            return;
        }
        int nx;
        int ny;
        int tempTime = 0;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (range(nx, ny) && map[nx][ny] != -1) {
                tempTime = map[nx][ny];
                map[nx][ny] = - 1;
                move(nx, ny, t + tempTime);
            }
        }
    }
    public static boolean range(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

}
