package TwentyThree.September;

import java.util.Arrays;

public class ConvertNumbers {

    /*
    문제 설명
자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.

x에 n을 더합니다
x에 2를 곱합니다.
x에 3을 곱합니다.
자연수 x, y, n이 매개변수로 주어질 때,
x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요.
이때 x를 y로 만들 수 없다면 -1을 return 해주세요.


 이문제는 dp로 푸는 문제임
     */

    public static void main(String[] args) {
        ConvertNumbers numbers = new ConvertNumbers();

        System.out.println(numbers.solution(10, 40, 30));

    }
    public int solution(int x, int y, int n) {
        int[] dp = new int[1_000_001];
        Arrays.fill(dp, -1);
        dp[x] = 0;

        for(int i = x; i<=y; i++) {
            if(dp[i] != -1) {
                if(i+n <= y) {
                    if(dp[i + n] == -1) {
                        dp[i + n] = dp[i] + 1;
                    } else if(dp[i + n] != -1){
                        dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
                    }
                }
                if(i*2 <= y) {
                    if(dp[i * 2] == -1) {
                        dp[i * 2] = dp[i] + 1;
                    } else if(dp[i*2] != -1) {
                        dp[i*2] = Math.min(dp[i] + 1, dp[i*2]);
                    }
                }
                if(i*3 <= y) {
                    if(dp[i*3] == -1) {
                        dp[i * 3] = dp[i] + 1;
                    } else if(dp[i*3] != -1) {
                        dp[i*3] = Math.min(dp[i] + 1, dp[i*3]);
                    }
                }
            }
        }

        return dp[y];
    }
    int[] dp = new int[3000003];
    int INF = 1000002;
    public int solution2(int x, int y, int n) {
        int answer = 0;
        Arrays.fill(dp, INF);
        dp[x] = -1;
        dp[y] = 0;
        for(int num = Math.max(y - n, Math.max(y / 2, y / 3)); num >= x; num--){
            dp[num] = Math.min(dp[num + n] + 1, Math.min(dp[num * 2] + 1, dp[num * 3] + 1));
        }
        return dp[x] >= INF ? -1 : dp[x];
    }
}
