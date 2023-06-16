package TwentyThree.June.codingTest;

import java.util.HashMap;
public class PersonalityTypeTest {
    /*
        1번 지표	라이언형(R), 튜브형(T)
        2번 지표	콘형(C), 프로도형(F)
        3번 지표	제이지형(J), 무지형(M)
        4번 지표	어피치형(A), 네오형(N)
     */
    // 4개의 지표
    // 각설문지 survey
    // 점수 계산 및 성격유형 정하기 choices

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        PersonalityTypeTest typeTest = new PersonalityTypeTest();
        System.out.println(typeTest.solution(survey, choices));
    }

    private class Testor{
        private String partType;
        private String winType;
        private int leftScore;
        private int rightScore;
        public Testor(String partType, int leftScore, int rightScore) {
            this.partType = partType;
            this.leftScore = leftScore;
            this.rightScore = rightScore;
        }
        private void setWinType(){
            this.winType = leftScore >= rightScore ? this.partType.substring(0, 1) : this.partType.substring(1, 2);
        }

        private void plusLeftScore(int plusNum) {
            this.leftScore += plusNum;
        }

        private void plusRightScore(int plusNum) {
            this.rightScore += plusNum;
        }
    }
    private HashMap<String, Testor> INDICATORS_FOUR = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        // 기본 셋팅
        String RT = "RT";
        String CF = "CF";
        String JM = "JM";
        String AN = "AN";

        INDICATORS_FOUR.put(RT, new Testor(RT, 0, 0));
        INDICATORS_FOUR.put(CF, new Testor(CF, 0, 0));
        INDICATORS_FOUR.put(JM, new Testor(JM, 0, 0));
        INDICATORS_FOUR.put(AN, new Testor(AN, 0, 0));
        String type;
        int lChoice;
        int rChoice;
        for (int i = 0; i < survey.length; i++) {

            if(INDICATORS_FOUR.containsKey(survey[i])){
                type = survey[i];
                lChoice = (choices[i] - 4 < 0 ? Math.abs(choices[i] - 4) : 0);
                rChoice = (4 - choices[i] < 0 ? Math.abs(4 - choices[i]) : 0);
            }else {
                type = survey[i].substring(1,2) + survey[i].substring(0,1);
                lChoice = (4 - choices[i] < 0 ? Math.abs(4 - choices[i]) : 0);
                rChoice = (choices[i] - 4 < 0 ? Math.abs(choices[i] - 4) : 0);
            }

            INDICATORS_FOUR.get(type).plusLeftScore(lChoice);
            INDICATORS_FOUR.get(type).plusRightScore(rChoice);
        }

        INDICATORS_FOUR.get(RT).setWinType();
        INDICATORS_FOUR.get(CF).setWinType();
        INDICATORS_FOUR.get(JM).setWinType();
        INDICATORS_FOUR.get(AN).setWinType();

        return INDICATORS_FOUR.get(RT).winType + INDICATORS_FOUR.get(CF).winType + INDICATORS_FOUR.get(JM).winType + INDICATORS_FOUR.get(AN).winType;
    }
}
