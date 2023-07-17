package TwentyThree.July;

import java.util.ArrayList;

public class VisitLength {
    /*
    방문 길이
문제 설명
게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.

U: 위쪽으로 한 칸 가기

D: 아래쪽으로 한 칸 가기

R: 오른쪽으로 한 칸 가기

L: 왼쪽으로 한 칸 가기

캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.

.
.
.
.
dirs는 string형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
dirs의 길이는 500 이하의 자연수입니다.

     */
    public static void main(String[] args) {

    }

    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        ArrayList<String> visit = new ArrayList<String>();

        //dir 길이만큼  for문 반복
        for (int i = 0; i < dirs.length(); i++) {
            //현재 x, y 좌표를 초깃값으로 갖는 변수 선언
            int reX = x;
            int reY = y;
            // dirs i번째 문자 가져오기
            char s = dirs.charAt(i);

            // s와 범위 체크하고 해당하는 좌표 +-
            if (s == 'U' && y < 5)
                y++;
            else if (s == 'D' && y > -5)
                y--;
            else if (s == 'R' && x < 5)
                x++;
            else if (s == 'L' && x > -5)
                x--;

            // arrayList에 저장할 변수 선언
            // st = x + y + reX + reY
            // nd = reX + reY + x + y
            String xy = Integer.toString(x);
            xy += Integer.toString(y);
            String reXY = Integer.toString(reX);
            reXY += Integer.toString(reY);
            String st = xy + reXY;
            String nd = reXY + xy;

            // visit에 존재하지 않고 st와 ed가 같지 않으면 visit에 add
            if (!visit.contains(st) && !visit.contains(nd) && !st.equals(nd)) {
                visit.add(st);
                visit.add(nd);
            }

        }

        // 이동 한 번에 2개의 값을 저장했으므로 /2한 값 반환
        answer = visit.size() / 2;
        return answer;
    }
}
