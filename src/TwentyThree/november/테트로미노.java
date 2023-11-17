package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static TwentyThree.november.구슬탈출.isRange;

public class 테트로미노 {

    /*

    폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

    정사각형은 서로 겹치면 안 된다.
    도형은 모두 연결되어 있어야 한다.
    정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
    정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.

    아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

    테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

    테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

    입력
    첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

    둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

    출력
    첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

     */

    static int N,M;
    static int[][] paper;
    static int max = Integer.MIN_VALUE;
    static boolean[][] isVisited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                bfs(i, j, paper[i][j], 1);
                isVisited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    private static void bfs(int x, int y, int sum, int count) {
        if(count == 4){
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i <= 3; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (isRange(cx, cy)) {
                continue;
            }

            if (!isVisited[cx][cy]) {
                if (count == 2) {
                    isVisited[cx][cy] = true;
                    bfs(x, y, sum + paper[cx][cy], count + 1);
                    isVisited[cx][cy] = false;
                }
            }

            isVisited[cx][cy] = true;
            bfs(cx, cy, sum + paper[cx][cy], count + 1);
            isVisited[cx][cy] = false;
        }
    }

    static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x <= N && y <= M;
    }

}
