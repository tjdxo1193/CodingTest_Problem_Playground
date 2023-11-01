package TwentyThree.november;
/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 최대상금_SWExpertAcademy {

    static int chance;
    static int answer;
    static String[] target;
        public static void main(String args[]) throws Exception
        {

            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            sc.nextLine();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
            for(int test_case = 1; test_case <= T; test_case++)
            {
                String input = sc.nextLine();
                String[] inputArray = input.split(" ");

                target = inputArray[0].split("");
                chance = Integer.valueOf(inputArray[1]);
                answer = 0;
                answer = dfs(0, 0);

                System.out.println("#" + test_case + " " + answer);
            }
        }

    private static int dfs(int k, int count) {
        String temp;
        String targetNum = "";

        return answer;
    }
}
