package TwentyThree.September;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NoPeopleIsland {
    /*
    문제 설명
메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다.
지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다.
지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며,
격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다.
지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다.
이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
지도의 각 칸에 적힌 숫자는 식량을 나타내는데,
상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다.
어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.

지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때,
각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요.
만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
     */

    public static void main(String[] args) {
        NoPeopleIsland island = new NoPeopleIsland();

        System.out.println(Arrays.toString(island.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    static private Integer islandCount = 0;
    public int[] solution(String[] maps) {
        int[] answer = new int[maps.length*maps[0].length()];
        // 양옆은 그냥 pos -> -1 , +1 이지만, 위 아래가 문제인데 , 위는 index -1 에 자기 위치  ,아래는 +1 에 자기 위치

        HashMap<Integer, Integer> islandMap = new HashMap<>();

        for (int i = 0; i < maps.length; i++) {
            for (int k = 0; k < maps[0].length(); k++) {
                if (maps[i].charAt(k) != 'X') {
                    // 위아래 양옆이 같은 맵,섬인지 ?
                    // 왼 같은 index에 같은 포지션에 -1
                    if (islandMap.containsKey(i*(k-1))) {
                        islandMap.put(i * k, islandMap.get(i * (k - 1)));
                        continue;
                    }
                    // 오
                    if (islandMap.containsKey(i*(k+1))) {
                        islandMap.put(i * k, islandMap.get(i*(k+1)));
                        continue;
                    }
                    // 위
                    if (islandMap.containsKey((i-1)*k)) {
                        islandMap.put(i * k, islandMap.get((i-1)*k));
                        continue;
                    }
                    // 아래
                    if (islandMap.containsKey((i+1)*k)) {
                        islandMap.put(i * k, islandMap.get((i+1)*k));
                        continue;
                    }
                    islandMap.put(i*k, islandCount++);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : islandMap.entrySet()) {
            answer[entry.getValue()] += Character.getNumericValue((maps[entry.getValue() / maps[0].length()].charAt(entry.getValue() % maps[0].length())));
        }

        return answer;
    }

}
