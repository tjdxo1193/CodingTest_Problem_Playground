package TwentyThree.September;

public class NTiling {
    /*
    가로 길이가 2이고 세로의 길이가 1인 직사각형모양의 타일이 있습니다.
    이 직사각형 타일을 이용하여 세로의 길이가 2이고 가로의 길이가 n인 바닥을 가득 채우려고 합니다.
    타일을 채울 때는 다음과 같이 2가지 방법이 있습니다.

    타일을 가로로 배치 하는 경우
    타일을 세로로 배치 하는 경우

    직사각형의 가로의 길이 n이 매개변수로 주어질 때,
    이 직사각형을 채우는 방법의 수를 return 하는 solution 함수를 완성해주세요.
     */
    public static void main(String[] args) {
        NTiling nTiling = new NTiling();
        System.out.println(nTiling.solution(7));
    }

    private static int[] dp;
    public static int solution(int n) {
        dp = new int[60001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] % 1_000_000_007;
        }

        return dp[n];
    }
}
