package TwentyThree.December;

public class BubbleSort {
    public static void main(String[] args) {
        int i;
        int[] list = new int[]{7, 4, 5, 1, 3};

        // 버블 정렬 수행
        bubble_sort(list);

        // 정렬 결과 출력
        for(i=0; i<5; i++){
            System.out.println((list[i]));
        }
    }

    static void bubble_sort(int list[]){
        int temp = 0;
        int n = list.length;
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] > list[j + 1]) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j+1] = temp;
                }
            }
        }
    }
}
