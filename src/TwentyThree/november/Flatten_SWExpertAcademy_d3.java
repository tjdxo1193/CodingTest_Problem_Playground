package TwentyThree.november;

import java.util.*;
import java.util.stream.Collectors;

public class Flatten_SWExpertAcademy_d3 {

/*
※ SW Expert 아카데미의 문제를 무단 복제하는 것을 금지합니다.

한 쪽 벽면에 다음과 같이 노란색 상자들이 쌓여 있다.

높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업을 평탄화라고 한다.

평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내가 된다.

평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때,
제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.


A’부분의 상자를 옮겨서, C부분에 덤프하였다. 이때 C 대신 C’부분에 덤프해도 무방하다.

2회의 덤프 후, 최고점과 최저점의 차이는 8 – 2 = 6 이 되었다 (최초덤프 이전에는 9 – 1 = 8 이었다).

덤프 횟수가 2회로 제한된다면, 이 예시 문제의 정답은 6이 된다.

[제약 사항]

가로 길이는 항상 100으로 주어진다.

모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.

덤프 횟수는 1이상 1000이하로 주어진다.

주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상
덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).

[입력]

총 10개의 테스트 케이스가 주어지며, 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수가 주어진다.
그리고 다음 줄에 각 상자의 높이값이 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 최고점과 최저점의 높이 차를 출력한다.

 */
    static int answer;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int count;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            count = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            List<Integer> inputArray = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            inputArray.sort(Comparator.reverseOrder());
            answer = differenceMaxAndMin(inputArray, count);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static int differenceMaxAndMin(List<Integer> inputArray, int count) {
        int max = 0;
        int min = 0;
        int maxIndex = inputArray.size()-1;
        for (int i = 0; i < count; i++) {
            inputArray.set(0, inputArray.get(0) - 1);
            inputArray.set(inputArray.size()-1, inputArray.get(maxIndex) + 1 );
            inputArray.sort(Comparator.reverseOrder());
        }
        max = inputArray.get(0);
        min = inputArray.get(maxIndex);
        return max - min;
    }


}
