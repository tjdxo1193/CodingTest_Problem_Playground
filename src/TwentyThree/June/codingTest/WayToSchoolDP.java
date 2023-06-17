package TwentyThree.June.codingTest;

public class WayToSchoolDP {
    /*
    가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.

격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다. 오른쪽과 아래쪽으로만 움직여 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.

제한사항
격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
물에 잠긴 지역은 0개 이상 10개 이하입니다.
집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
     */
    public static void main(String[] args) {
        WayToSchoolDP wayToSchool = new WayToSchoolDP();
        int[][] pu = {{2,2}};
        System.out.println(wayToSchool.solution(4, 3, pu));
    }
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] dp = new int[n][m];

        // 웅덩이 있는 곳 -1 로 초기화
        for(int[] puddle : puddles) {
            dp[puddle[1]-1][puddle[0]-1] = -1;
        }

        // 집 초기화
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (dp[i][j] == -1) { // 웅덩이면 0
                    dp[i][j] = 0;
                    continue;
                }

                if (i != 0) { // 위쪽 값 더해주기
                    dp[i][j] += dp[i - 1][j] % mod;
                }

                if (j != 0) { // 왼쪽 값 더해주기
                    dp[i][j] += dp[i][j - 1] % mod;
                }
            }
        }
        return dp[n-1][m-1] % mod;
    }
}
