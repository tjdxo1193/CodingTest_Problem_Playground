package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sum_d3 {

    /*
    ※ SW Expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

다음 100X100의 2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하는 프로그램을 작성하여라.

다음과 같은 5X5 배열에서 최댓값은 29이다.
    [제약 사항]

총 10개의 테스트 케이스가 주어진다.

배열의 크기는 100X100으로 동일하다.

각 행의 합은 integer 범위를 넘어가지 않는다.

동일한 최댓값이 있을 경우, 하나의 값만 출력한다.

[입력]

각 테스트 케이스의 첫 줄에는 테스트 케이스 번호가 주어지고 그 다음 줄부터는 2차원 배열의 각 행 값이 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 답을 출력한다.
     */

    static final int N = 100;
    static int [][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number;
        StringTokenizer st;
        int[] 가로;
        int[] 세로;
        int[] 대각선;

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            number = Integer.parseInt(br.readLine());
            board = new int[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            가로 = new int[N];
            세로 = new int[N];
            대각선 = new int[2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    가로[i] += board[i][j];
                    세로[i] += board[j][i];
                    if (i == j) {
                        대각선[0] = board[i][j];
                    }
                    if (i + j == N - 1) {
                        대각선[1] = board[i][j];
                    }
                }
            }
            int anwser = 0;
            Integer 가로짱 = Arrays.stream(가로).max().getAsInt();
            Integer 세로짱 = Arrays.stream(세로).max().getAsInt();
            anwser = Math.max(가로짱, Math.max(세로짱, Math.max(대각선[0], 대각선[1])));
            System.out.println("#" + test_case + " " + anwser);
        }
    }
}
