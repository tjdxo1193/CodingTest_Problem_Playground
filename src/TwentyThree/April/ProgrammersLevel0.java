package TwentyThree.April;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgrammersLevel0 {


    public static void main(String[] args) {
        System.out.println(solution2("banana", "na"));
        System.out.println(solution2("banana", "ke"));
        System.out.println(solution44(0,"wsdawsdassw"));
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
        String s = Integer.toString(n); //int n을 String으로 변환

        for(int i=0; i<s.length(); i++){
            answer += Integer.parseInt(s.substring(i, i+1));
        }
        return answer;
    }

    public int solution31(String my_string) {
        String[] arrStr = my_string.split("");

        return 1;
    }


    public int solution32(int[] num_list) {
        return num_list.length >= 11 ?
                Arrays.stream(num_list).sum()
                : Arrays.stream(num_list).reduce(1,(a,b) -> a*b);
    }

    public int solution33(String str1, String str2) {
        return str2.contains(str1) ? 1 : 0;
    }

    public int solution34(int[] num_list) {
        return Arrays.stream(num_list).reduce(1,(a,b) -> a*b) < Math.pow(Arrays.stream(num_list).sum(),2) ?
                1 : 0 ;
    }

    public int solution35(int[] num_list) {


        return Arrays.stream(num_list)
                .filter(i -> i % 2 == 0)
                .reduce(0, (left, right) -> Integer.parseInt(String.valueOf(left) + String.valueOf(right)))
                +
                Arrays.stream(num_list)
                        .filter(i -> i % 2 != 0)
                        .reduce(0, (left, right) -> Integer.parseInt(String.valueOf(left) + String.valueOf(right)));
    }


    public int solution36(int a, int b) {
        int answer = 0;
        if((a+b)%2 == 0){
            // 모두 홀수 거나 모두 짝수
            if (a % 2 == 0) {
                answer = Math.abs(a-b);
            }else {
                answer = (int) (Math.pow(a, 2) + Math.pow(b,2));
            }
        }else {
            answer = 2 * (a + b);
        }
        return answer;
    }

    public int[] solution38(int start, int end) {
        return IntStream.iterate(start, i -> i <= end, i -> i + 1).toArray();
    }

    public int[] solution39(int start, int end) {
        return IntStream.iterate(start, i -> i >= end, i -> i - 1).toArray();
    }
//단어가 공백 한 개로 구분되어 있는 문자열 my_string이 매개변수로 주어질 때
// my_string에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.
    public String[] solution40(String my_string) {
        return my_string.split("");
    }

//정수 리스트 num_list와 정수 n이 주어질 때,
// n 번째 원소부터 마지막 원소까지의 모든 원소를 담은 리스트를 return하도록 solution 함수를 완성해주세요.

    public int[] solution41(int[] num_list, int n) {
        return Arrays.stream(num_list).skip(n).toArray();
    }
//문자열 my_string이 매개변수로 주어집니다.
// my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.
    public int solution42(String my_string) {
        Stream<String> answer = Arrays.stream(my_string.split("")).filter(s -> s.matches("[0-9]"));
        return answer.map(Integer::parseInt).reduce(0, Integer::sum);
    }
// 한 자리 정수로 이루어진 문자열 num_str이 주어질 때, 각 자리수의 합을 return하도록 solution 함수를 완성해주세요.
    public int solution43(String num_str) {
        return Arrays.stream(num_str.split("")).map(Integer::parseInt).reduce(0, Integer::sum);
    }
/*
정수 n과 문자열 control이 주어집니다.
control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며,
control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

"w" : n이 1 커집니다.
"s" : n이 1 작아집니다.
"d" : n이 10 커집니다.
"a" : n이 10 작아집니다.
위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return 하는 solution 함수를 완성해 주세요.
 */
    public static int solution44(int n, String control) {
        Map<String, Integer> map = new HashMap<>();
        map.put("w", 1);
        map.put("s", -1);
        map.put("d", 10);
        map.put("a", -10);
        return Arrays.stream(control.split("")).map(map::get).reduce(n, Integer::sum);
    }

    /*
    정수 배열 numbers와 정수 n이 매개변수로 주어집니다.
    numbers의 원소를 앞에서부터 하나씩 더하다가
    그 합이 n보다 커지는 순간 이때까지 더했던
    원소들의 합을 return 하는 solution 함수를 작성해 주세요.
     */
    public int solution47(int[] numbers, int n) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            if(sum > n){
                break;
            }
        }
        return sum;
    }
/*
정수로 이루어진 리스트 num_list가 주어집니다.
num_list에서 가장 작은 5개의 수를 제외한 수들을 오름차순으로
담은 리스트를 return하도록 solution 함수를 완성해주세요.
 */
    public int[] solution48(int[] num_list) {
        return Arrays.stream(num_list).sorted().skip(5).toArray();
    }
/*
양의 정수 n이 매개변수로 주어질 때,
n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고
n이 짝수라면 n 이하의 짝수인
모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.
 */
    public int solution49(int n) {
        return n%2 == 0 ?
        Arrays.stream(IntStream.iterate(2, i -> i <= n, i -> i + 2)
                .toArray()).map(a->a*a).sum()
        : Arrays.stream(IntStream.iterate(1, i -> i <= n, i -> i + 2)
                .toArray()).sum()
        ;
    }

    public int[] solution50(int n, int k) {
        return IntStream.iterate(1, i -> i <= n, i -> i+k).toArray();
    }
/*
    정수 배열 arr가 주어집니다.
    arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고
    50보다 작은 홀수라면 2를 곱합니다.
    그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
 */
    public int[] solution51(int[] arr) {
        return Arrays.stream(arr).map(value -> {
            if (value >= 50) {
                if (value % 2 == 0) {
                    value = value/2;
                }
            }else{
                if (value % 2 != 0) {
                    value = value*2;
                }
            }
            return value;
        }).toArray();
    }
/*
문자열 str1, str2가 매개변수로 주어집니다. str1 안에
str2가 있다면 1을 없다면 2를 return하도록
solution 함수를 완성해주세요.
 */
    public int solution52(String str1, String str2) {
        return str1.contains(str2) ? 1: 2;
    }
    /*
    영소문자로 이루어진 문자열 my_string과
    영소문자 1글자로 이루어진 문자열 alp가 매개변수로 주어질 때,
    my_string에서 alp에 해당하는 모든 글자를 대문자로 바꾼 문자열을
    return 하는 solution 함수를 작성해 주세요.
     */
    public String solution53(String my_string, String alp) {
        return my_string.replaceAll(alp, alp.toUpperCase());
    }
/*
개미 군단이 사냥을 나가려고 합니다.
개미군단은 사냥감의 체력에 딱 맞는 병력을 데리고 나가려고 합니다.
장군개미는 5의 공격력을, 병정개미는 3의 공격력을
일개미는 1의 공격력을 가지고 있습니다.
예를 들어 체력 23의 여치를 사냥하려고 할 때,
일개미 23마리를 데리고 가도 되지만, 장군개미 네 마리와
병정개미 한 마리를 데리고 간다면 더 적은 병력으로 사냥할 수 있습니다.
사냥감의 체력 hp가 매개변수로 주어질 때,
사냥감의 체력에 딱 맞게 최소한의 병력을 구성하려면
몇 마리의 개미가 필요한지를 return하도록 solution 함수를 완성해주세요.
 */
    public int solution54(int hp) {
        int 장군 = hp/5;
        int 병정 = (hp%5)/3;
        int 일 = (hp%5)%3;

        return 장군 + 병정 + 일;
    }

    public int solution55(int n) {
        return Math.sqrt(n) % 1 == 0 ? 1 : 2;
    }

    public String solution56(String cipher, int code) {
        StringBuilder a = new StringBuilder();
        for (int i = code; i <= cipher.length(); i = i+code) {
            a.append(cipher.charAt(i - 1));
        }
        return a.toString();
    }
    public String solution57(String my_string) {
        return Arrays.stream(my_string.split("")).map(s -> {
            if(Character.isUpperCase(s.charAt(0))){
                return s.toLowerCase();
            }else {
                return s.toUpperCase();
            }
        }).collect(Collectors.joining());
    }

    public int solution(int n, int t) {
        return (int) (n*Math.pow(2, t));
    }

    public List<Integer> solution58(String my_string) {
        Stream<Integer> stream = Arrays.stream(my_string.split(""))
                .filter(s -> s.matches("[0-9]")).map(Integer::parseInt).sorted();
        return stream.collect(Collectors.toList());
    }

    public int solution59(int[] numbers) {
        int temp = 0;
        int max = numbers[0] * numbers[1];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i == j){
                    continue;
                }
                temp = numbers[i] * numbers[j];
                if (max < temp) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public int[] solution60(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(i -> i%n!=0).toArray();
    }
}
