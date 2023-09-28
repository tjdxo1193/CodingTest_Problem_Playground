package TwentyThree.September;

public class NoMoreThanTwoDifferentBits {
    /*

2개 이하로 다른 비트
문제 설명
양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.

x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
예를 들어,

f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
수	비트	다른 비트의 개수
2	000...0010
3	000...0011	1
f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
수	비트	다른 비트의 개수
7	000...0111
8	000...1000	4
9	000...1001	3
10	000...1010	3
11	000...1011	2
정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ numbers의 길이 ≤ 100,000
0 ≤ numbers의 모든 수 ≤ 1015


짝수일때는 간단합니다.
짝수를 2진수로 변홨했을때 1의 자리수가 0이기 때문에 +1 해주면 됩니다.
ex) 2 -> 10 -> 11 -> output data : 3
ex) 4 -> 100 -> 101 ->output data : 5
ex) 6 -> 110 -> 111 -> output data : 7

input data가 홀수
input data를 2진수 변환했을때 가장 먼저 나오는 0의 자리를 1로 나머지는 0으로
이 숫자를 input data에 더하고 이 숫자를 /2 한 값을 빼주시면 됩니다.
ex) 5 -> 101 -> 가장 먼저 나오는 0을 탐색(2의 1승자리) -> 101 + 10 - 1 -> 110 ->output data : 6
ex) 3 -> 11 -> 가장 먼저 나오는 0을 탐색(2의 2승자리) -> 11 + 100 - 10 -> 101 ->output data : 5

신기했다.
     */

    public static void main(String[] args) {

    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 4 != 3) {
                answer[i] = numbers[i] + 1;
                continue;
            }

            String bit = Long.toBinaryString(numbers[i]);
            if (!bit.contains("0")) {
                bit = 0 + bit;
                bit = String.valueOf(bit.charAt(1)) + bit.charAt(0) + bit.substring(2);
            }else{
                int x = bit.lastIndexOf("0");
                bit = bit.substring(0, x) + "10" + bit.substring(x + 2);
            }

            answer[i] = toBinary(bit);


        }

        return answer;
    }
    private static long toBinary(String bit) {
        bit = new StringBuilder(bit).reverse().toString();
        long ans = 0;
        long x = 1L;
        for (int i = 0; i < bit.length(); i++) {
            if (bit.charAt(i) == '1') {
                ans += x;
            }
            x *= 2;
        }

        return ans;
    }
}
