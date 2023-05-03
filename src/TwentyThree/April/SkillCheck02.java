package TwentyThree.April;
public class SkillCheck02 {
    /*
    조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
입출력 예
name	return
"JEROEN"	56
"JAN"	23
     */

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }

    static int solution(String name) {
        int answer = 0;
        /*
        ▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

         */

        char[] chArray = name.toCharArray();
        char currentPoint = 'A';
        for (int i = 0; i < chArray.length; i++) {
            char goalStr = chArray[i];
            int cterm = Math.abs((int) currentPoint - (int) goalStr);
            int aterm = Math.abs((int) 'A' - (int) goalStr);
            int zterm = Math.abs((int) 'Z' - (int) goalStr);

            System.out.println("현재글자와의 차이는: " +cterm);
            System.out.println("a글자와의 차이는: " +aterm);
            System.out.println("z글자와의 차이는: " +zterm);

            // 위아래 먼저
            // 좌우 그다음
            if (cterm == 0) {
                continue;
            }else if(cterm > aterm || cterm > zterm ){
                answer++;
                if (aterm < zterm) {
                    // A -> goal 까지
                    answer += aterm;
                    System.out.println("A로 이동");
                }else{
                    System.out.println("Z로 이동");
                    // Z -> goal 까지
                    answer += zterm;
                }
            }else {
                // term 이 13같거나 작으면 차이만큼이동
                answer += cterm;
                System.out.println("현재만");
            }
            currentPoint = chArray[i];
            System.out.println("현재글자 : " + currentPoint);
            System.out.println("이동수 : " + answer);

        }
        return answer;
    }
    class Solution {
        public int solution(String n_str) {
            int answer = Integer.parseInt(n_str);
            return answer;
        }
    }
}
