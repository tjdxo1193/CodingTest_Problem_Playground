package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 암호문_d3 {
    static int[] pw;
    static String answer;

    public static void main(String args []) throws NumberFormatException, IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            pw = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                pw[i] = Integer.parseInt(input[i]);
            }
            answer = createPw();
            System.out.println("#" + test_case + " " + answer);
        }

    }

    private static String createPw() {
        int num = 0;
        int index = 0;
        int pointer = 0;
        while(true) {
            for(int i = 1; i <= 5; i++) {
                pointer = index++%8;
                num = pw[pointer] - i;
                if(num > 0) {
                    pw[pointer] = num;
                }else {
                    pw[pointer] = 0;
                    break;
                }
            }
            if(pw[pointer] == 0) {
                pointer = index++%8;
                break;
            }
        }

        String result = String.valueOf(pw[pointer]);
        for(int i = 0; i < pw.length-1; i++) {
            pointer = index++%8;
            result += " " + pw[pointer];
        }
        return result;
    }

}
