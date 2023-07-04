package TwentyThree.June.codingTest;

import java.util.Arrays;
import java.util.Stack;

public class DartGame {

    /*
카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

다트 게임은 총 3번의 기회로 구성된다.
각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

     */


    public static void main(String[] args) {
        DartGame dartGame = new DartGame();
        System.out.println(dartGame.solution("1D2S0T"));
    }

    private static final String SINGLE = "S";
    private static final String DOUBLE = "D";
    private static final String TRIPLE = "T";
    private static final String STAR_AWARD = "*";
    private static final String ALAS = "#";
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        String[] strArray = dartResult.split("");
        Integer temp1 = 0;
        Integer temp2 = 0;

        for (int i = 0; i < strArray.length ; i++) {
            // 1이 이미 들어간 상태
            if (strArray[i].equals("0") && stack.size() > 0 && stack.peek() == 1) {
                stack.pop();
                stack.push(10);
                continue;
            }
            if (strArray[i].equals(SINGLE)) {
                continue;
            }
            if (strArray[i].equals(DOUBLE)) {
                stack.push(stack.peek() * stack.pop());
                continue;
            }
            if (strArray[i].equals(TRIPLE)) {
                stack.push(stack.peek()*stack.peek()*stack.pop());
                continue;
            }
            if (strArray[i].equals(STAR_AWARD)) {
                temp2 = stack.pop()*2; // 쉬프트 연산 해도딤
                if(!stack.isEmpty()){
                    temp1 = stack.pop()*2;
                    stack.push(temp1);
                }
                stack.push(temp2);
                continue;
            }

            if (strArray[i].equals(ALAS)) {
                stack.push(stack.pop() * -1);
                continue;
            }

            stack.push(Integer.valueOf(strArray[i]));
        }

        while (stack.size() != 0){
            answer += stack.pop();
        }

        return answer;
    }
}
