package TwentyThree.March;

import java.util.ArrayList;
import java.util.List;

public class EmoticonDiscountEvent {
    /*
    이모티콘 할인행사
    문제 설명
        카카오톡에서는 이모티콘을 무제한으로 사용할 수 있는 이모티콘 플러스 서비스 가입자 수를 늘리려고 합니다.
        이를 위해 카카오톡에서는 이모티콘 할인 행사를 하는데, 목표는 다음과 같습니다.

        이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
        이모티콘 판매액을 최대한 늘리는 것.
        1번 목표가 우선이며, 2번 목표가 그 다음입니다.

        이모티콘 할인 행사는 다음과 같은 방식으로 진행됩니다.

        n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매합니다.
        이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
        카카오톡 사용자들은 다음과 같은 기준을 따라 이모티콘을 사거나, 이모티콘 플러스 서비스에 가입합니다.

        각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘을 모두 구매합니다.
        각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
        다음은 2명의 카카오톡 사용자와 2개의 이모티콘이 있을때의 예시입니다.

        사용자	비율	가격
        1	40	10,000
        2	25	10,000
        이모티콘	가격
        1	7,000
        2	9,000
        1번 사용자는 40%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.
        2번 사용자는 25%이상 할인하는 이모티콘을 모두 구매하고, 이모티콘 구매 비용이 10,000원 이상이 되면 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입합니다.

        1번 이모티콘의 가격은 7,000원, 2번 이모티콘의 가격은 9,000원입니다.

        만약, 2개의 이모티콘을 모두 40%씩 할인한다면, 1번 사용자와 2번 사용자 모두 1,2번 이모티콘을 구매하게 되고, 결과는 다음과 같습니다.

        사용자	구매한 이모티콘	이모티콘 구매 비용	이모티콘 플러스 서비스 가입 여부
        1	1, 2	9,600	X
        2	1, 2	9,600	X
        이모티콘 플러스 서비스 가입자는 0명이 늘어나고 이모티콘 판매액은 19,200원이 늘어납니다.

        하지만, 1번 이모티콘을 30% 할인하고 2번 이모티콘을 40% 할인한다면 결과는 다음과 같습니다.

        사용자	구매한 이모티콘	이모티콘 구매 비용	이모티콘 플러스 서비스 가입 여부
        1	2	5,400	X
        2	1, 2	10,300	O
        2번 사용자는 이모티콘 구매 비용을 10,000원 이상 사용하여 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입하게 됩니다.
        따라서, 이모티콘 플러스 서비스 가입자는 1명이 늘어나고 이모티콘 판매액은 5,400원이 늘어나게 됩니다.

        카카오톡 사용자 n명의 구매 기준을 담은 2차원 정수 배열 users, 이모티콘 m개의 정가를 담은 1차원 정수 배열 emoticons가 주어집니다. 이때, 행사 목적을 최대한으로 달성했을 때의 이모티콘 플러스 서비스 가입 수와 이모티콘 매출액을 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해주세요.

    제한사항
        1 ≤ users의 길이 = n ≤ 100
        users의 원소는 [비율, 가격]의 형태입니다.
        users[i]는 i+1번 고객의 구매 기준을 의미합니다.
        비율% 이상의 할인이 있는 이모티콘을 모두 구매한다는 의미입니다.
        1 ≤ 비율 ≤ 40
        가격이상의 돈을 이모티콘 구매에 사용한다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입한다는 의미입니다.
        100 ≤ 가격 ≤ 1,000,000
        가격은 100의 배수입니다.
        1 ≤ emoticons의 길이 = m ≤ 7
        emoticons[i]는 i+1번 이모티콘의 정가를 의미합니다.
        100 ≤ emoticons의 원소 ≤ 1,000,000
        emoticons의 원소는 100의 배수입니다.
    입출력 예
        users	emoticons	result
        [[40, 10000], [25, 10000]]	[7000, 9000]	[1, 5400]
        [[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]	[1300, 1500, 1600, 4900]	[4, 13860]
    입출력 예 설명
    입출력 예 #1

        문제의 예시와 같습니다.

    입출력 예 #2

        다음과 같이 할인하는 것이 이모티콘 플러스 서비스 가입자를 최대한 늘리면서, 이모티콘 판매액 또한 최대로 늘리는 방법입니다.

        이모티콘	할인율
        1	40
        2	40
        3	20
        4	40
        위와 같이 할인하면 4명의 이모티콘 플러스 가입자와 13,860원의 판매액을 달성할 수 있습니다. 다른 할인율을 적용하여 이모티콘을 판매할 수 있지만 이보다 이모티콘 플러스 서비스 가입자를 최대한 늘리면서, 이모티콘 판매액 또한 최대로 늘리는 방법은 없습니다.
        따라서, [4, 13860]을 return 하면 됩니다.
     */

    // 4 4 4 4 ... 4


    // dc는 전체 할인율
    // 1. 가입을 얼마나 할 수 있는지 부터 계산 , 최소 비율로 할인
    // 2. 그다음 매출액
    // users[i][0] -> 비율 , users[i][1] -> 이모티콘 구매 비용의 합
    // [[40, 10000], [25, 10000]]


    public static void main(String[] args) {
        int[][] us = {
                {40, 10000}, {25, 10000}
        };
        int[] em = {7000, 9000};
        int[] result = solution(us, em);
        for (int a : result){
            System.out.println(a);
        }
    }
   /*
       param1
           사용자 n명의 구매 기준 2차원 배열
           구성 : [n][2](가격, 비율)
       param2
           이모티콘 m개의 정가를 담은 1차원 배열

       Result
           행사목적을 최대한으로 달성했을 떄의 이모티콘 플러스 서비스 가입 수와 이모티콘 매출액을 배열로 담아
           n x [서비스 가입자 수, 이모티콘 매출액]
    */
/*
        int usersCnt = users[0].length;
        int emoticonsCnt = emoticons.length;
        int[] discountApply = new int[usersCnt]; // 할인율 변경 10 , 10 , 10 ... -> 10, 20, 10, 10, 10
        int maxLength =  (int)(Math.pow(4, emoticonsCnt));

        int[] price = new int[usersCnt];
        int[] joinYn = new int[usersCnt];
 */

    /*
       1.가입최대, 2.이윤최대
       구매할수 있게 하면서 가입을 최대로

       시간복잡도: O(u*n*4^n)
       공간복잡도: O(4^n)
    */
    // 전역 정적 객체 필요 공유(레퍼런스)
    static class 이모티콘{
        int 가격;
        int 할인율;
        이모티콘(int 가격, int 할인율){
            this.가격 = 가격;
            this.할인율 = 할인율;
        }
    }

    // 전역 정적 변수 필요 공유(레퍼런스) 중요한것은 각 탐색이 진행될때마다
    // 선택한 할인율과 이모티콘에 할인된 가격이 넘어가야함 (아니면 그때마다 계산해줘야함) -> 그러므로 이에 대한 리스트가 필요
    // 할인율이 선택된 이모티콘들의 리스트가 필요
    static List<이모티콘> 선택완료된_이모티콘_목록 = new ArrayList<>();
    // 고정 할인율 배열
    static int[] 할인율 = {10, 20, 30, 40};
    // 답 : 가입자수, 총수입
    static int 가입자수 = -1;
    static int 총수입 = -1;



    public static int[] solution(int[][] users, int[] emoticons) {
        int[] 답 = new int[2];
        /*
            root(0) 부터 e.lenth의 깊이 까지 탐색 중복으로 할인율을 선택함. 깊이가 최대까지 가면
            그때부터 사용자들에 대한 가입자 수와 총금액을 계산하여, 각각의 깊이 탐색의 해 마다 멕스값과 비교하며 스왑함.
        */
        깊이_우선_탐색(0, users, emoticons);

        답[0] = 가입자수;
        답[1] = 총수입;

        return 답;
    }

    private static void 깊이_우선_탐색(int 깊이, int[][] 사용자들, int[] 이모티콘들) {
        // 할인울 선택 완료시 return
        // 이제 해당 해를 구하고 다음 탐색을 이어간다.
        if(깊이 == 이모티콘들.length){

            int 총가입자수 = 0;
            int 총판매금 = 0;

            // 각 사용자들에 대한 이모티콘들의 판매금합과 가입여부를 COUNT 함
            for (int 사용자_순번 = 0; 사용자_순번 < 사용자들.length; 사용자_순번++) {
                // 편의상 변수 선언 한줄로 줄일 수 있음... 하지만 가독성 ..
                int 현사용자_희망_할인율 = 사용자들[사용자_순번][0];
                int 현사용자_희망_가격 = 사용자들[사용자_순번][1];
                int 현사용자_지불한_금액합 = 0;

                // 현사용자에 대한 이모티콘 구매 정보들을 계산
                for (int 임티_순번 = 0; 임티_순번 < 선택완료된_이모티콘_목록.size(); 임티_순번++) {
                    // 편의상 객체 선언 한줄로 줄일 수 있음... 하지만 가독성 ..
                    이모티콘 현이모티콘_객체 = 선택완료된_이모티콘_목록.get(임티_순번);
                    System.out.println("가격: "+ 현이모티콘_객체.가격);
                    System.out.println("할인율: "+ 현이모티콘_객체.할인율);
                    if(현이모티콘_객체.할인율 >= 현사용자_희망_할인율){
                        현사용자_지불한_금액합 += 현이모티콘_객체.가격;
                    }
                }

                if(현사용자_지불한_금액합 >= 현사용자_희망_가격){
                    총가입자수++;
                }else{
                    총판매금 += 현사용자_지불한_금액합;
                }
            }

            // 모든 사용자에 대한 계산이 끝났고, 이번 해에 총가입자수와 총판매금이 계산됬다.
            // 전역변수로 설정한 값과 비교해서 크면 넣고 아니면 넘어감
            if(총가입자수 > 가입자수){
                // 큰경우 무조건 다 바꿈
                가입자수 = 총가입자수;
                총수입 = 총판매금;
            }else if (총가입자수 == 가입자수 && 총판매금 > 총수입){
                // 가입자수가 같고 총금액이 클경우 금액만 바꿈
                총수입 = 총판매금;
            }

            return;
        }

        for(int 순번 = 0; 순번 < 할인율.length ;순번++){
            선택완료된_이모티콘_목록.add(new 이모티콘(((100 - 할인율[순번]) * (이모티콘들[깊이]) / 100), (할인율[순번])));
            깊이_우선_탐색 (깊이 +1, 사용자들, 이모티콘들);
            선택완료된_이모티콘_목록.remove(선택완료된_이모티콘_목록.size()-1);
        }

    }
}
