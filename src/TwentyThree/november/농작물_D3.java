package TwentyThree.november;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 농작물_D3 {

        static int[][] map;
        static int answer;
        static int N;

        public static void main(String args []) throws NumberFormatException, IOException {


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
            for(int test_case = 1; test_case <= T; test_case++)
            {
                N = Integer.parseInt(br.readLine());
                map = new int[N][N];
                String input;
                for (int i = 0; i < N; i++) {
                    input = br.readLine();
                    for (int j = 0; j < N; j++) {
                        map[i][j] = input.charAt(j) - '0';
                    }
                }
                answer = countScore();
                System.out.println("#" + test_case + " " + answer);
            }

        }

    private static int countScore() {
        if(N == 1 ) {return map[0][0];}
        int num = N-1;
        int count = 0;
        for(int i = 0; i <= N/2; i++, num = num-2) {
            for(int j = num; j >= 0; j--) {
                if(num == N-1) {
                    count += map[N/2][j];
                    continue;
                }
                count += map[N/2-i][i+j];
                count += map[N/2+i][i+j];
            }
        }
        return count;
    }

}
