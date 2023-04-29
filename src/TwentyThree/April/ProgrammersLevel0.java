package TwentyThree.April;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgrammersLevel0 {


    public static void main(String[] args) {
        System.out.println(solution2("banana", "na"));
        System.out.println(solution2("banana", "ke"));
        System.out.println(solution26("aaawas"));
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

    public int[] solution11(String[] strlist) {
        int[] answer = Arrays.stream(strlist).mapToInt(String::length).toArray();
        return answer;
    }
    public String solution12(String my_string) {
        String[] arr = my_string.split("");
        String answer = "";
        for (int i= arr.length-1; i >= 0; i--){
            answer += arr[i];
        }
        return answer;
    }

    public int[] solution13(int[] num_list) {
        int[] answer = {(int) Arrays.stream(num_list).filter(i -> i%2==0).count()
                ,(int) Arrays.stream(num_list).filter(i -> i%2!=0).count()};

        return answer;
    }
/*
numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

 */
    public int solution14(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }

    public int solution15(int[] array, int height) {
        return (int) Arrays.stream(array).filter(i -> i > height).count();
    }

    public int solution16(int[] dot) {
        int x = dot[0];
        int y = dot[1];
        if (x > 0) {
            if (y > 0) {
                return 1;
            }else {
                return 4;
            }
        }else {
            if (y > 0) {
                return 2;
            }else {
                return 3;
            }
        }
    }

    public int[] solution17(int money) {
        return new int[]{money/5500, money%5500};
    }
    static int PAN = 1;
    public int solution18(int slice, int n) {
        if(slice*PAN > n){
            return PAN;
        }else{
            PAN++;
           return solution18(slice, n);
        }
    }

    public int solution19(int n) {
        return (int) Math.ceil(n / 7.0);
    }

    public String solution20(String my_string) {
        return my_string.replaceAll("[a,e,i,o,u]", "");
    }

    public int solution21(String message) {
        return message.length()*2;
    }

    public int solution22(int[] sides) {
        Arrays.sort(sides);
        return sides[2] < sides[0] + sides[1] ? 1 : 0;
    }

    public String solution23(String my_string, int n) {
        String[] arrStr = my_string.split("");
        String answer = "";
        for (int i = 0; i < arrStr.length; i++) {
            for (int l = 0; l < n; l++) {
                answer += arrStr[i];
            }
        }
        return answer;
    }

    public int solution24(int price) {
        return (int) (price >= 500000 ? price*0.8 : price >= 300000 ? price*0.9 : price >= 100000 ? price*0.95 : 0);
    }

    public int solution25(int box[], int n) {
        return (box[0]/n) * (box[1]/n) * (box[2]/n);
    }

    public static String solution26(String rsp) {
        String[] arrStr = rsp.split("");
        Map<String, String> map = new HashMap<>();
        map.put("0", "5");
        map.put("2", "0");
        map.put("5", "2");
        return Arrays.stream(arrStr).map(map::get).collect(Collectors.joining());
    }

    public int solution27(int n) {
        int 약수수 = 0;
        for (int i = 1; i <= n; i++) {
            if (n%i == 0)약수수++;
        }
        return 약수수;
    }

    public int solution28(String[] s1, String[] s2) {
        int answer = 0;
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if(s1[i].equals(s2[j]))answer++;
            }
        }
        return answer;
    }

    // 피자 n 명이 6조각씩의 피자를 한조각도 남김없이 다먹을 수 있는 최소 수
    public int solution29(int n) {
        int 최소공배수 = n;
        if (n % 2 == 0) {
            최소공배수 /= 2;
        }
        if (n % 3 == 0) {
            최소공배수 /= 3;
        }
        return 최소공배수;
    }

    // 자릿수 더하기
    public int solution30(int n) {
        int answer = 0;
        return answer;
    }

    public int solution(String my_string) {
        String[] arrStr = my_string.split("");

        return 1;
    }

}
