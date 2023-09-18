package TwentyThree.September;

import java.util.*;

public class NoPeopleIsland {
    public static void main(String[] args) {
        NoPeopleIsland noPeopleIsland = new NoPeopleIsland();
        System.out.println(Arrays.toString(noPeopleIsland.solution(new String[]{"X5XX5X", "111111", "XXXXXX", "111111"})));
    }

    // 잘못된 풀이 ( 반례 : "X5XX5X", "111111", "XXXXXX", "111111" ) 첫 줄 5 랑 그다음 5가 같은 섬인지 모름 )
    private static int islandCount = 0;
    int[] X = {0, 0, 1, -1};
    int[] Y = {1, -1, 0, 0};
    public int[] solution(String[] maps) {

        int strLength = maps[0].length();
        boolean[][] visited = new boolean[maps.length][strLength];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < strLength; j++) {
                if (maps[i].charAt(j) == 'X' || visited[i][j]) {
                    continue;
                }

                list.add(dfsForSum(i, j, maps, visited));
            }
        }

        if (list.size() == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    private int dfsForSum(int x, int y, String[] maps, boolean[][] visited) {
        int sum = 0;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] prev = stack.pop();

            int prevX = prev[0];
            int prevY = prev[1];


            if (visited[prevX][prevY]) {
                continue;
            }

            visited[prevX][prevY] = true;

            sum += maps[prevX].charAt(prevY) - '0';

            for (int i = 0; i < 4; i++) {
                int curX = X[i] + prevX;
                int curY = Y[i] + prevY;

                if (curX < 0
                        || curY < 0
                        || curX >= maps.length
                        || curY >= maps[curX].length()
                        || maps[curX].charAt(curY) == 'X'
                        || visited[curX][curY]) {

                    continue;
                }

                stack.push(new int[]{curX, curY});
            }
        }

        return sum;
    }

    public int[] solution1_fail(String[] maps) {
        int strLength = maps[0].length();
        // 키를 위치(index = maps의 인덱스 * String의 길이(maps[0].length()) + String의 인덱스) 벨류를 섬 인덱스로 지정
        HashMap<Integer, Integer> islandMap = new HashMap<>();


        for (int i = 0; i < maps.length; i++) {
            for (int k = 0; k < strLength; k++) {
                if (maps[i].charAt(k) != 'X') {
                    // 위
                    if (islandMap.containsKey((i-1)*strLength+k)) {
                        islandMap.put(i * strLength + k, islandMap.get((i-1)*strLength+k));
                        continue;
                    }
                    // 아래
                    if (islandMap.containsKey((i+1)*strLength+k)) {
                        islandMap.put(i * strLength + k, islandMap.get((i+1)*strLength+k));
                        continue;
                    }
                    // 왼쪽
                    if (islandMap.containsKey(i*strLength+(k-1))) {
                        islandMap.put(i * strLength + k, islandMap.get(i*strLength+(k-1)));
                        continue;
                    }
                    // 오른쪽
                    if (islandMap.containsKey(i*strLength+(k+1))) {
                        islandMap.put(i * strLength + k, islandMap.get(i*strLength+(k+1)));
                        continue;
                    }
                    // 없으면 새로운 섬 !
                    islandMap.put(i * strLength + k, islandCount++);
                }
            }
        }

        if(islandCount == 0 ){
            return new int[] {-1};
        }
        int[] answer = new int[islandCount];
        for (Map.Entry<Integer, Integer> integerEntry : islandMap.entrySet()){
            int islandNum = integerEntry.getValue();
            int sourcesPos = integerEntry.getKey();
            answer[islandNum] += Character.getNumericValue(maps[sourcesPos / strLength].charAt(sourcesPos % strLength));
        }

        return Arrays.stream(answer).sorted().toArray();
    }



}
