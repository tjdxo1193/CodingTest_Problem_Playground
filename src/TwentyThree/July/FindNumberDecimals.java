package TwentyThree.July;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindNumberDecimals {
    /*


     */
    public static void main(String[] args) {

    }
    public static int solution(int n, int k) {
        List<String> nums = init(n, k);
        int answer = 0;

        for (String s : nums) {
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static String toBinary(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    private static List<String> init(int num, int binary) {
        StringTokenizer st = new StringTokenizer(toBinary(num, binary), "0");
        List<String> nums = new ArrayList<>();

        while (st.hasMoreTokens()) {
            nums.add(st.nextToken());
        }

        return nums;
    }

}
