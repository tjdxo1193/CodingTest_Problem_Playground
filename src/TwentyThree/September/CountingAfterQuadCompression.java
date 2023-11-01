package TwentyThree.September;

import java.util.HashMap;
import java.util.Map;

public class CountingAfterQuadCompression {

    /*
        문제 설명
        0과 1로 이루어진 2n x 2n 크기의 2차원 정수 배열 arr이 있습니다.
        당신은 이 arr을 쿼드 트리와 같은 방식으로 압축하고자 합니다. 구체적인 방식은 다음과 같습니다.

        당신이 압축하고자 하는 특정 영역을 S라고 정의합니다.
        만약 S 내부에 있는 모든 수가 같은 값이라면, S를 해당 수 하나로 압축시킵니다.
        그렇지 않다면, S를 정확히 4개의 균일한 정사각형 영역(입출력 예를 참고해주시기 바랍니다.)으로 쪼갠 뒤,
        각 정사각형 영역에 대해 같은 방식의 압축을 시도합니다.
        arr이 매개변수로 주어집니다. 위와 같은 방식으로 arr을 압축했을 때,
        배열에 최종적으로 남는 0의 개수와 1의 개수를 배열에 담아서 return 하도록 solution 함수를 완성해주세요.

        제한사항
        arr의 행의 개수는 1 이상 1024 이하이며, 2의 거듭 제곱수 형태를 하고 있습니다.
        즉, arr의 행의 개수는 1, 2, 4, 8, ..., 1024 중 하나입니다.
        arr의 각 행의 길이는 arr의 행의 개수와 같습니다. 즉, arr은 정사각형 배열입니다.
        arr의 각 행에 있는 모든 값은 0 또는 1 입니다.

     */



    public static void main(String[] args) {

    }


    int [][] graph;
    Map<Integer, Integer> hashMap = new HashMap<>();
    public void dfs(int y, int x, int lastY, int lastX, int size){
        boolean checkFlag = true;
        int tmpNumber = graph[y][x];
        /* Check Quad (Total) */
        for(int i=y;i<lastY;i++){
            for(int j=x;j<lastX;j++){
                if(tmpNumber != graph[i][j]) {
                    checkFlag = false;
                    break;
                }
            }
            if(!checkFlag) break;
        }
        /* If Quad ? return */
        if(checkFlag) {
            hashMap.put(tmpNumber,hashMap.get(tmpNumber)+1);
            return;
        }
        /* If Atomic ? count */
        if(size==2){
            for(int i=y;i<lastY;i++){
                for(int j=x;j<lastX;j++){
                    hashMap.put(graph[i][j],hashMap.get(graph[i][j])+1);
                }
            }
            return;
        }
        /* Slice */
        /* y, x means offset*/
        dfs(y,x,(y+lastY)/2,(x+lastX)/2, size/2);
        dfs((y+lastY)/2,x,lastY,(lastX+x)/2, size/2);
        dfs(y,(x+lastX)/2,(y+lastY)/2,lastX, size/2);
        dfs((y+lastY)/2,(x+lastX)/2, lastY, lastX, size/2);

    }

    public int[] solution(int[][] arr) {
        int[] answer = new int [2];
        hashMap.put(0,0);
        hashMap.put(1,0);
        graph = arr;
        dfs(0,0,arr[0].length,arr[0].length, arr[0].length);
        answer[0] = hashMap.get(0);
        answer[1] = hashMap.get(1);
        return answer;
    }
}
