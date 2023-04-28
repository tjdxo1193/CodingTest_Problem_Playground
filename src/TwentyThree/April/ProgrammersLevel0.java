package TwentyThree.April;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProgrammersLevel0 {


    public static void main(String[] args) {
        System.out.println(solution2("banana", "na"));
        System.out.println(solution2("banana", "ke"));
    }
        public static int[] solution1(int[] arr, int k) {
            return Arrays.stream(arr).map(i -> k%2 == 0 ? i+k : i*k).toArray();
        }

        /*
        부분 문자열이란 문자열에서 연속된 일부분에 해당하는 문자열을 의미합니다. 예를 들어,
        문자열 "ana", "ban", "anana", "banana", "n"는 모두 문자열 "banana"의 부분 문자열이지만,
        "aaa", "bnana", "wxyz"는 모두 "banana"의 부분 문자열이 아닙니다.

        문자열 my_string과 target이 매개변수로 주어질 때, target이 문자열 my_string의 부분 문자열이라면 1을,
         아니라면 0을 return 하는 solution 함수를 작성해 주세요.
         */
        public static int solution2(String myStr, String target) {
            return  myStr.contains(target) ? 1 : 0;
        }

        public int solution3(int a, int b, boolean flag) {
            return flag ? a + b : a - b;
        }

        public int solution4(int number, int n, int m) {
            return (number % n == 0 ) && (number % m == 0) ? 1 : 0;
        }

        public int[] solution5(int[] num_list, int n) {
            return Arrays.copyOfRange(num_list , 0, n);
        }

        public String solution5(String myString) {
            return myString.toLowerCase();
        }

        public String solution6(String my_string, int n) {
            return my_string.substring(n);
        }
        public String solution7(String my_string, int k) {
            return my_string.repeat(k);
        }

        public String solution8(String rny_string) {
            return rny_string.replaceAll("m", "rn");
        }

        public int solution9(int[] num_list) {
            return IntStream.range(0, num_list.length)
                    .filter(i -> num_list[i] < 0)
                    .findFirst()
                    .orElse(-1);    // 타겟을 찾지 못하면 -1 반환
        }

    public int solution10(int[] num_list, int n) {
        return Arrays.stream(num_list).filter(i -> i == n).findFirst().orElse(-1) > 0  ? 1 : 0 ;
    }
}
