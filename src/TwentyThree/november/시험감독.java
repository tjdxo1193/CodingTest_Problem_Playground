package TwentyThree.november;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험감독 {
    /*

    문제
    총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다.
    i번 시험장에 있는 응시자의 수는 Ai명이다.

    감독관은 총감독관과 부감독관으로 두 종류가 있다.
    총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고,
    부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명이다.

    각각의 시험장에 총감독관은 오직 1명만 있어야 하고,
    부감독관은 여러 명 있어도 된다.

    각 시험장마다 응시생들을 모두 감시해야 한다.
    이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 시험장의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

    둘째 줄에는 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)가 주어진다.

    셋째 줄에는 B와 C가 주어진다. (1 ≤ B, C ≤ 1,000,000)
     */
    static int N;
    static int[] A;
    static int B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(count());
    }


}
