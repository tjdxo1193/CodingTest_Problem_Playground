package TwentyThree.June.codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LifeBoat {
    /*
    문제 설명
        무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
        예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
        구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
        사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

    제한사항
        무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
        각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
        구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
        구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
    입출력 예
        people	limit	return
        [70, 50, 80, 50]	100	3
        [70, 80, 50]	100	3
     */

    // 탐욕적 알고리즘으로 풀어야함.
    // 탐욕적 알고리즘은, 가장 높은 값을 먼저 사용해서 푸는 것.
    // 그래서 정렬을 사용해서 앞에서 부터 제거하며 해를 구함. DP와 거의 비슷하지만,
    // 알고리즘을 사용해도 되는 2가지 조건을 가지고 있다.
    // 1. 탐욕적 선택 속성(Greedy Choice Property) : 앞의 선택이 이후의 선택에 영향을 주지 않는다.
    // 2. 최적 부분 구조(Optimal Substructure) : 문제에 대한 최종 해결 방법은 부분 문제에 대한 최적 문제 해결 방법으로 구성된다.

    public static void main(String[] args) {
        LifeBoat lifeBoat = new LifeBoat();
        System.out.println(lifeBoat.solution(new int[]{70, 50, 80, 50}, 100));
    }

    public int solution(int[] people, int limit) {
        // 구명 보트의 무게 limit , 사람들의 무게 people[i]
        // 사람들의 무게를 내림차순으로 정렬해서 limit에 맞추어 제거하며 구한다.
        Integer[] peopleToInteger = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(peopleToInteger, Collections.reverseOrder());

        List<Integer> boat = new ArrayList<>();
        int startPoint = 0;
        int endPoint = people.length-1;
        int count = 0;

        while (startPoint <= endPoint){
            // 부분문제의 최적에 해 : 가장 몸무게가 큰 친구를 태운 보트가, 가장 작은 몸무게의 친구를 태우는 것.
            boat.add(people[startPoint++]);
            if (limit - boat.get(count) >= people[endPoint]) {
                boat.set(count, boat.get(count) + people[endPoint]);
                endPoint--;
            }else {
                count++;
            }
        }

        return boat.size();
    }
}
