package TwentyThree.June.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class NExpressed {

    public static void main(String[] args) {
        NExpressed nExpressed = new NExpressed();
        System.out.println(nExpressed.solution(5, 12));
    }

    private class NCalculator{
        private Integer num;

        public NCalculator(int num) {
            this.num = num;
        }
        private Integer plus(int num){
            return this.num + num;
        }

        private Integer minus(int num) {
            return this.num - num;
        }

        private Integer multiple(int num) {
            return this.num * num;
        }

        private Integer divide(int num) {
            return this.num / num;
        }

        private Integer merge(int digit, int num) {
            if (digit != 1) {
                num = num * 10 + this.num;
                return merge(digit - 1, num);
            }
            return num;
        }

    }
    public int solution(int N, int number) {
        int answer = -1;
        int dp[][] = new int[8][];


        NCalculator nCalculator = new NCalculator(N);
        ArrayList<BiFunction<NCalculator, Integer, Integer>> biList = new ArrayList<>();
        biList.add(NCalculator::plus);
        biList.add(NCalculator::minus);
        biList.add(NCalculator::multiple);
        biList.add(NCalculator::divide);

        dp[0][0] = 0;
        dp[1][0] = N;
        for (int i = 2; i <= 8; i++) { // N 의 개수
            dp[i][0] = nCalculator.merge(i, N);
            for (int j = 1; j < dp[i - 1].length; j++) { // dp[i]의 경우의 수
                for (int k = 1; k <= 6; k++) { // 그에 대한 수식 개수
                    dp[i][j*k] = dp[i-1][j];
                }
            }
        }

        return answer;
    }


}
