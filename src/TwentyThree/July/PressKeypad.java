package TwentyThree.July;

import java.util.HashMap;

public class PressKeypad {
/*
[카카오 인턴] 키패드 누르기
문제 설명
스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.

kakao_phone1.png

이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

[제한사항]
numbers 배열의 크기는 1 이상 1,000 이하입니다.
numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
hand는 "left" 또는 "right" 입니다.
"left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
 */

    public static void main(String[] args) {
        PressKeypad keypad = new PressKeypad();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(keypad.solution(numbers, "right"));
    }

        public String solution(int[] numbers, String hand) {
            StringBuffer sb = new StringBuffer();
            int[] position = new int[]{10,12}; // position[0] = 왼손위치 , position[1] = 오른손위치

            for(int i = 0; i<numbers.length;i++) {
                int number = numbers[i]==0?11:numbers[i]; //0인 경우 치환

                switch(numbers[i]) {
                    case 1: case 4: case 7: sb.append("L"); position[0] = numbers[i]; break;
                    case 3: case 6: case 9: sb.append("R"); position[1] = numbers[i]; break;
                    default :
                        if(isLeft(number, position[0], position[1], hand)){
                            sb.append("L"); position[0] = numbers[i];
                        } else {
                            sb.append("R"); position[1] = numbers[i];
                        }
                        break;
                }
            }
            return sb.toString();
        }

        public Boolean isLeft(int number, int leftPos, int rightPos, String hand) {
            int leftDistance = 0;              // 왼손의 필요 거리
            int rightDistance = 0;             // 오른손 필요 거리

            //왼손, 오른손 중 위치가 0인경우 11로 치환
            if(leftPos == 0) {
                leftPos = 11;
            } else if(rightPos == 0) {
                rightPos = 11;
            }
            //경로 절대값 구하기
            leftDistance = Math.abs(number-leftPos);
            rightDistance = Math.abs(number-rightPos);

            //절대값/3 의 몫 : 세로거리, 절대값/3 의 나머지 : 가로거리
            leftDistance = (leftDistance/3) + (leftDistance%3);
            rightDistance = (rightDistance/3) + (rightDistance%3);

            if(leftDistance < rightDistance) { //왼손이 가까움
                return true;
            } else if(leftDistance > rightDistance) { //오른손이 가까움
                return false;
            } else { //동일 거리 : hand 비교
                if("left".equals(hand)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

//    private static final String L = "L";
//    private static final String R = "R";
//    public String solution(int[] numbers, String hand) {
//        StringBuilder answer = new StringBuilder();
//        HashMap<Integer, String> handKeyNumMap = new HashMap<>(); // 369
//        HashMap<String, Integer> handLocation = new HashMap<>(); // 147
//        String userHand = hand.equals("right") ? R : L;
//
//        handLocation.put(R, 10);
//        handLocation.put(L, 12);
//        handKeyNumMap.put(3, R);
//        handKeyNumMap.put(6, R);
//        handKeyNumMap.put(9, R);
//        handKeyNumMap.put(1, L);
//        handKeyNumMap.put(4, L);
//        handKeyNumMap.put(7, L);
//        handKeyNumMap.put(2, "");
//        handKeyNumMap.put(5, "");
//        handKeyNumMap.put(8, "");
//        handKeyNumMap.put(0, "");
//        int strLen = 0;
//        int rpos = -1;
//        int lpos = -1;
//        for (int i = 0; i < numbers.length; i++) {
//            strLen = answer.length();
//            rpos = handLocation.get(R);
//            lpos = handLocation.get(L);
//            answer.append(handKeyNumMap.get(numbers[i]));
//
//            if (strLen == answer.length()) {
//                if (
//                    (Math.abs(numbers[i] - lpos) == Math.abs(numbers[i] - rpos))||  // 두 대각선, 한줄,
//                    ((lpos+2) == rpos) ||// 2차이
//
//                ) {
//                    answer.append(userHand);
//                }else{
//                    if (numbers[i] == 0) {
//                        answer.append(rpos > lpos ? R : L);
//                    }else{
//                        answer.append(Math.abs(rpos - numbers[i]) < Math.abs(lpos - numbers[i]) ? R : L);
//                    }
//                }
//            }
//            System.out.println(answer.substring(answer.length()-1));
//            handLocation.put(answer.substring(answer.length()-1), numbers[i]);
//        }
//
//
//        return answer.toString();
//    }
}
