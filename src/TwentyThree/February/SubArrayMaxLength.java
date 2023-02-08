package uplord.uplordapi.common.ct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubArrayMaxLength {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\Documents\\하이웍스 받은파일\\test2.txt";
        List<String> lines = Files.readAllLines(Paths.get(path));

        String IntegerData = lines.get(0).replaceAll("[|]", "");

        List<Integer> a = Arrays.stream(IntegerData.split("\\s"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Long start = System.currentTimeMillis();
        System.out.println(maxLength(a, 22379700));
        Long end = System.currentTimeMillis();
        Double takes = (end.doubleValue() - start.doubleValue()) / 1000;
        System.out.println("☆ takes: " + takes);
    }
// DP 문제는 바로 잘 떠오르지 않기 때문에 이 경우에 사용한다.
// 해당 문제가 복잡하고, 모든 경우ㅢ 수를 고려해야할때,
// 복잡한 문제를 하나하나씩 해치워 나가야하는데, 반복되는 계산, 또는 로직이 있을때
// 점화식을 생각 할 수 있을때 등등..

// 푸는 방식
// 1. 피보나치를 예로 들면
// f(n) = f(n-1) + f(n-2) 라는 점화식이 있다.
// 만약 이 점화식을 보고 재귀로만 푼다면, f(2^n) 이라는 엄청난 시간복잡도가 생겨날것이다..
// 하지만 DP로 푼다면 f(NlogN)라는 쏘쏘한 시간복잡도로 풀수 있다.
// 그 이유는 메모리제이션 - 계산된 값을 기억,메모 해두는 식으로 줄이는 것이다.
// f(11) = f(10) + f(9) 인데 f(10)과 f(9) 를 알면 f(11) 은 => 2번에 계산으로 끝낼수 있다.

    // 무튼 단계는 대충 이렇다.
    // 첫째는 DP로 풀 수 있는지 DP 문제인지 확인해야함
    // 두번째는 작은 테스트를 하나씩 해봄으로써 규칙을 알아가야함.
    // 변수와 점화식을 알아야함.
    // 메모할것이 무엇인지 파악해야함
    // 그리고 구현해야함

// 시작점, 끝점 startPoint , endPoint - 인덱스
//        memo의 최대 크기 => 공간복잡도 O(2n) => O(n) , O(n*n+1/2) => O(n^2) , O(n^2)
//        int[] memoByOne = new int[arrLen]
//        int[] memoByCurrentTotal = new int[arrLen-1];
//        int[] memo = new int[arrLen*(arrLen+1)/2];
    public static int maxLength(List<Integer> arr, int k){

        int arrLen = arr.size();
        int total = 0;
        int maxLength = 0;
        int depth = 0;
        int width = 0;
        int[][] memo = new int[arrLen][arrLen];

        for (int num = 0; num < arrLen; num++){
            memo[0][num] = arr.get(num);
        }

        depth++;

        for(; depth < arrLen; depth++){

            for(width = 0; depth + width < arrLen; width++){
                memo[depth][width] = memo[depth-1][width] + arr.get(depth + width);

                total = memo[depth][width];

                if(k >= total){
                    maxLength = depth + 1;
                }
            }
        }

        return maxLength;
    }
}