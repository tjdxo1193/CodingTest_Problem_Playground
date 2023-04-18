package TwentyThree.April;

public class SkillCheck_01 {
    /*
    대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.

제한사항
문자열 s의 길이 : 50 이하의 자연수
문자열 s는 알파벳으로만 이루어져 있습니다.
입출력 예
s	answer
"pPoooyY"	true
"Pyy"	false
입출력 예 설명
입출력 예 #1
'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.

입출력 예 #2
'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.

※ 공지 - 2021년 8월 23일 테스트케이스가 추가되었습니다.
     */

    /*
    단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
    단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

    재한사항
    s는 길이가 1 이상, 100이하인 스트링입니다.
     */


    public static void main(String[] args) {
        System.out.println(solution2("12"));
//        System.out.println(solution("PyccwuyPpY"));
    }

    static boolean solution(String s) {
        boolean answer = true;
        String upperStr = s.toUpperCase();

        long Ycnt = upperStr.chars().filter(c -> c == 'Y').count();
        long Pcnt = upperStr.chars().filter(c -> c == 'P').count();

        return Ycnt == Pcnt;
    }


    static String solution2(String s) {
        String answer = "";
        if (s.length() == 1) {
            return s;
        }

        boolean isEven = s.length()%2 == 0;
        int fmidNum = (int) Math.round((s.length()/2.0));


        return isEven ? s.substring(fmidNum-1, fmidNum+1) : s.substring(fmidNum-1, fmidNum) ;
    }
}
