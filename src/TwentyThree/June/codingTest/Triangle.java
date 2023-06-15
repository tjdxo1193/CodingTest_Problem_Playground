package TwentyThree.June.codingTest;
public class Triangle {

    public static void main(String[] args) {
        Triangle tr = new Triangle();
        System.out.println();
    }

    // DP 문제
    // 재귀냐 반복문이냐
    public int solution(int[][] triangle) {
        int result = 0;
        int depth = 0;
        // 몇층
        int dp[][] = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= triangle[i].length; j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == triangle[i].length) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }

                if(result < dp[i][j]){
                    result = dp[i][j];
                }
            }
        }

        return result;
    }
}
