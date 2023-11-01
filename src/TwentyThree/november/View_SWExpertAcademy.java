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
import java.util.Scanner;
public class View_SWExpertAcademy {
        public static void main(String args[]) throws Exception
        {
            Scanner sc = new Scanner(System.in);
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
            for(int test_case = 1; test_case <= 10; test_case++)
            {
                int bulidCnt = sc.nextInt();
                int result = 0;
                int[] bulidHeights = new int[bulidCnt];
                for (int i = 0; i < bulidCnt; i++) {
                    bulidHeights[i] = sc.nextInt();
                }

                for (int i = 2; i < bulidHeights.length - 2; i++) {
                    int area[] = new int[4];
                    area[0] = bulidHeights[i-2];
                    area[1] = bulidHeights[i-1];
                    area[2] = bulidHeights[i+1];
                    area[3] = bulidHeights[i+2];
                    if(area[0] >= bulidHeights[i] || area[1] >= bulidHeights[i] || area[2] >= bulidHeights[i] || area[3] >= bulidHeights[i]){
                        continue;
                    }else{
                        Arrays.sort(area);
                        result += bulidHeights[i] - area[3];
                    }
                }
                System.out.println(result);
            }
        }
}
