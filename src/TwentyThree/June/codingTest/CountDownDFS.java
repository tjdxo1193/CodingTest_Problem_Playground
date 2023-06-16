package TwentyThree.June.codingTest;
import java.util.Arrays;
import java.util.HashMap;

public class CountDownDFS {

    public static void main(String[] args) {
        CountDownDFS cd = new CountDownDFS();
        System.out.println(Arrays.toString(cd.solution(58)));
    }

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
