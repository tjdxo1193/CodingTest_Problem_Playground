package TwentyThree.June.codingTest;
import java.util.Arrays;
import java.util.HashMap;

public class CountDownDP {

    public static void main(String[] args) {
        CountDown cd = new CountDown();
        System.out.println(Arrays.toString(cd.solution(58)));
        // assert [1,0]
        // 1 - 20 까지의 점수
        // 주어진 점수를 0점으로 만드는 것
        // 우선순위
        // 1. 최소한의 다트를 사용하는 것.
        // 2. 싱글, 불을 최대한 많이 맞추는 것.
        // return [ 다트 수 , 싱글 + 볼] (개수)
    }

    // DP/DFS 고려해볼수 있음.
    // 50
    // single, bul, double, triple
    // x 1 , x 2 , x 3
    // 1-20 까지 [1, 1]
    // 21, 22, 24, 26, 27, 28, 30, 32, 33, 34, 36, 38, 39, 40, 42, 45, 48, 51, 54, 57, 60
    // 23(2,2), 25(2,2), 29(2,2), 31(2,2), 35(2,2), 37(2,2),
    // 41(2, 1), 43(2, 1), 44(2, 1), 46(2, 1), 47(2, 1), 49(2, 1),
    // 52(2,2), 53(2,2), 55(2,2), 56(2,2), 58(2,2), 59(2,2) = 18개의 경우
    // 50보다 크면 불하나 싱글하나, 50보다 작고 40보다 큰것,  40보다 작은것 싱글 두개.

    // 61 ~ 70 - 싱글 , 불 2, 2
    // 71 ~ 80 = 싱글, 트리플 2, 1
    // 81 ~  = 60, 21 ..

    private HashMap<Integer, BasicResult> BASIC_SCORE_LIST = new HashMap<>() ;
    private final static int DART_COUNT_ORDER = 0;
    private final static int SINGLE_OR_BUL_COUNT_ORDER = 1;
    private final static int NONE = -1;

    private class BasicResult {
        private int dartCnt;
        private int singleOrBulCnt;

        BasicResult(int dartCnt, int singleOrBulCnt) {
            this.dartCnt = dartCnt;
            this.singleOrBulCnt = singleOrBulCnt;
        }
    }

    public int[] solution(int target) {
        int dartCount = 0;
        int singleOrBulCount = 0;
        int[][] dp = new int[target+1][2];

        for (int i = 1; i <= 60; i++) {
            boolean isDoubleScore = (i%2 == 0) && i <= 40;
            boolean isTripleScore =  i%3 == 0;
            if (i <= 20){
                BASIC_SCORE_LIST.put(i, new BasicResult(1, 1));
            }else{
                if (isDoubleScore || isTripleScore) {
                    BASIC_SCORE_LIST.put(i, new BasicResult(1,0));
                }else{
                    if(i < 40){ // 21-39
                        BASIC_SCORE_LIST.put(i, new BasicResult(2,2));
                    }else if (i < 50) {// 41-49
                        BASIC_SCORE_LIST.put(i, new BasicResult(2,1));
                    }else if (i == 50){
                        BASIC_SCORE_LIST.put(i, new BasicResult(1,1));
                    }else {
                        BASIC_SCORE_LIST.put(i, new BasicResult(2,2));
                    }
                }
            }
        }

        dp[0][DART_COUNT_ORDER] = dartCount;
        dp[0][SINGLE_OR_BUL_COUNT_ORDER] = singleOrBulCount;

        for (int j = 1; j <= target && j <= 60; j++) {
            if (BASIC_SCORE_LIST.get(j) != null) {
                dp[j][DART_COUNT_ORDER] = BASIC_SCORE_LIST.get(j).dartCnt;
                dp[j][SINGLE_OR_BUL_COUNT_ORDER] = BASIC_SCORE_LIST.get(j).singleOrBulCnt;
            }
        }

        if (target > 60) {
            for (int k = 61; k <= target; k++) {
                if (dp[k - 50][DART_COUNT_ORDER] <= dp[k - 60][DART_COUNT_ORDER]) {
                    dp[k][DART_COUNT_ORDER] = dp[k - 50][DART_COUNT_ORDER] + 1;
                    dp[k][SINGLE_OR_BUL_COUNT_ORDER] = dp[k - 50][SINGLE_OR_BUL_COUNT_ORDER] + 1;
                } else {
                    dp[k][DART_COUNT_ORDER] = dp[k - 60][DART_COUNT_ORDER] + 1;
                    dp[k][SINGLE_OR_BUL_COUNT_ORDER] = dp[k - 60][SINGLE_OR_BUL_COUNT_ORDER];
                }
            }
        }

        return dp[target];
    }
}
