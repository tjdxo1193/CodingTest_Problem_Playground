package TwentyThree.September;

import java.util.Arrays;

public class BaseStationInstallation {

    /*

기지국 설치
문제 설명
N개의 아파트가 일렬로 쭉 늘어서 있습니다. 이 중에서 일부 아파트 옥상에는 4g 기지국이 설치되어 있습니다.
기술이 발전해 5g 수요가 높아져 4g 기지국을 5g 기지국으로 바꾸려 합니다. 그런데 5g 기지국은 4g 기지국보다 전달 범위가 좁아,
4g 기지국을 5g 기지국으로 바꾸면 어떤 아파트에는 전파가 도달하지 않습니다.

예를 들어 11개의 아파트가 쭉 늘어서 있고, [4, 11] 번째 아파트 옥상에는 4g 기지국이 설치되어 있습니다.
만약 이 4g 기지국이 전파 도달 거리가 1인 5g 기지국으로 바뀔 경우 모든 아파트에 전파를 전달할 수 없습니다.
(전파의 도달 거리가 W일 땐, 기지국이 설치된 아파트를 기준으로 전파를 양쪽으로 W만큼 전달할 수 있습니다.)

초기에, 1, 2, 6, 7, 8, 9번째 아파트에는 전파가 전달되지 않습니다.

이때, 우리는 5g 기지국을 최소로 설치하면서 모든 아파트에 전파를 전달하려고 합니다. 위의 예시에선 최소 3개의 아파트 옥상에 기지국을 설치해야 모든 아파트에 전파를 전달할 수 있습니다.

아파트의 개수 N, 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations, 전파의 도달 거리 W가 매개변수로 주어질 때, 모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국 개수의 최솟값을 리턴하는 solution 함수를 완성해주세요

제한사항
     */


    public static void main(String[] args) {
        BaseStationInstallation installation = new BaseStationInstallation();
        System.out.println(installation.solution(5, new int[]{1, 2, 3, 4, 5}, 0));
    }
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        answer += func(1, Math.max(0, stations[0] - w - 1), 2 * w + 1);

        for (int i = 1; i < stations.length; i++) {
            answer += func(stations[i - 1] + w + 1, stations[i] - w - 1, 2 * w + 1);
        }

        answer += func(stations[stations.length - 1] + w + 1, n, 2 * w + 1);

        return answer;
    }
    static public int func(int start, int end, int w) {
        int num = end - start + 1;
        if (num <= 0) {
            return 0;
        }
        if (num % w == 0) {
            return (num / w);
        } else {
            return (num /w) + 1;
        }
    }
    // 어느계산에서 실수해서 오답이 나온것을 보인다...
    public int solution_오답(int n, int[] stations, int w) {
        int answer = 0;
        int count = 0;
        int targetInstallPlaceMin = 1;
        int targetInstallPlaceMax = 1;
        for (int i = 0; i < stations.length; i++) {
            targetInstallPlaceMax = Math.max(stations[i] - w - 1, 1);
            count = (int) Math.ceil((double) (targetInstallPlaceMax - targetInstallPlaceMin + 1) / (w * 2 + 1));
            if (count > 0) {
                answer += count;
            }
            count = 0;
            targetInstallPlaceMin = targetInstallPlaceMax + 2*w+1;
        }
        if (targetInstallPlaceMin < n) {
            answer += (int) Math.ceil((double) (n - targetInstallPlaceMin) / (w * 2 + 1));
        }

        return answer;
    }


}
