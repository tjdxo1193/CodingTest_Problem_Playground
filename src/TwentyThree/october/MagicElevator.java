package TwentyThree.october;

import javax.print.attribute.standard.Sides;

public class MagicElevator {

    /*

마법의 엘리베이터

문제 설명
마법의 세계에 사는 민수는 아주 높은 탑에 살고 있습니다.
탑이 너무 높아서 걸어 다니기 힘든 민수는 마법의 엘리베이터를 만들었습니다.
마법의 엘리베이터의 버튼은 특별합니다.
마법의 엘리베이터에는 -1, +1, -10, +10, -100, +100 등과 같이 절댓값이 10c (c ≥ 0 인 정수)
형태인 정수들이 적힌 버튼이 있습니다. 마법의 엘리베이터의 버튼을 누르면 현재
층 수에 버튼에 적혀 있는 값을 더한 층으로 이동하게 됩니다.
단, 엘리베이터가 위치해 있는 층과 버튼의 값을 더한 결과가 0보다 작으면 엘리베이터는 움직이지 않습니다.
민수의 세계에서는 0층이 가장 아래층이며 엘리베이터는 현재 민수가 있는 층에 있습니다.

마법의 엘리베이터를 움직이기 위해서 버튼 한 번당 마법의 돌 한 개를 사용하게 됩니다.예를 들어,
16층에 있는 민수가 0층으로 가려면 -1이 적힌 버튼을 6번, -10이 적힌 버튼을 1번 눌러 마법의 돌 7개를 소모하여 0층으로 갈 수 있습니다.
하지만, +1이 적힌 버튼을 4번, -10이 적힌 버튼 2번을 누르면 마법의 돌 6개를 소모하여 0층으로 갈 수 있습니다.

마법의 돌을 아끼기 위해 민수는 항상 최소한의 버튼을 눌러서 이동하려고 합니다.
민수가 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수를 알고 싶습니다.
민수와 마법의 엘리베이터가 있는 층을 나타내는 정수 storey 가 주어졌을 때, 0층으로 가기 위해
필요한 마법의 돌의 최소값을 return 하도록 solution 함수를 완성하세요.

제한사항
1 ≤ storey ≤ 100,000,000

     */

    public static void main(String[] args) {
        MagicElevator elevator = new MagicElevator();
        System.out.println(elevator.solution2(555));
    }

    public int solution(int storey) {
        int answer = 0;
        int sib = 10;


        while (storey != 0) {
            int key = storey % sib;

            if (key > 5) {
                // + 해서
                int sub = sib - key;
                answer += sub;
                storey = storey + sub;
            }else if(key == 5){
                // 두번째 자리수 확인 해야할 필요 있음
                if((storey / sib) % sib >= 5){
                    int sub = sib - key;
                    answer += sub;
                    storey = storey + sub;
                }else{
                    int plus = key;
                    answer += plus;
                    storey = storey - plus;
                }
            }else{
                int plus = key;
                answer += plus;
                storey = storey - plus;
            }
            if (storey != 0) {
                storey = storey / sib;
            }
        }

        return answer;
    }
    public int solution2(int storey) {
        int answer = 0;

        String data = String.valueOf(storey);
        boolean isUpper = false;
        int prev = 0;
        for (int i=data.length()-1; i>=0; i--) {
            int tempValue = storey % 10;
            storey /= 10;

            if (tempValue == 5) {
                if (prev == 5) {
                    answer += 4;
                    isUpper = true;
                    prev = 6;
                } else if (isUpper) {
                    answer += 4;
                    if (i == 0) {
                        answer++;
                    }
                    prev = 6;
                } else {
                    answer += 5;
                    prev = 5;
                }
            } else if (tempValue < 5) {
                if (isUpper) {
                    answer += (tempValue + 1);
                    prev = (tempValue + 1);
                } else {
                    answer += tempValue;
                    prev = tempValue;
                }
                isUpper = false;
            } else if (tempValue > 5) {
                if (prev == 5) {
                    answer += (9 - tempValue);
                    prev = (tempValue + 1);
                } else if (isUpper) {
                    answer += (9 - tempValue);
                    prev = (tempValue + 1);
                } else {
                    answer += (10 - tempValue);
                    prev = tempValue + 1;
                }
                if (i == 0) {
                    answer++;
                }
                isUpper = true;
            }
        }

        return answer;
    }


}
