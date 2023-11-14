package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문찾기_d3 {
    static char[][] map;
    static int answer;

    public static void main(String args []) throws NumberFormatException, IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num;
        for(int test_case = 1; test_case <= 1; test_case++)
        {
            num = Integer.parseInt(br.readLine());
            map = new char[8][8];
            String input;
            for (int i = 0; i < 8; i++) {
                input = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = input.charAt(j);
                }
            }
            answer = countAnswer(num);
            System.out.println("#" + test_case + " " + answer);
        }

    }

    private static int countAnswer(int num) {
        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(j  > 8 - num) {
                    break;
                }
                int countGa = 0;
                int countSe = 0;
                for(int k = j; k < j + num/2; k++) {
                    if(map[i][k] == map[i][j + (num-1) + (j - k)]) {
                        countGa++;
                    }
                    if(map[k][i] == map[j + (num-1) + (j - k)][i]) {
                        countSe++;
                    }
                }

                if(countGa == num/2) {
                    cnt++;
                }
                if(countSe == num/2) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
