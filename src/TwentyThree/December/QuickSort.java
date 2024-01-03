package TwentyThree.December;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = new int[]{5, 3, 8, 4, 9, 1, 6, 2, 7};

        quick_sort(list, 0, list.length-1);

        for(int i=0; i<list.length; i++){
            System.out.println(list[i]);
        }
    }

    static void quick_sort(int[] list, int left, int right) {
        if (left < right) {
            int q = partition(list, left, right);

            quick_sort(list, left, q - 1);
            quick_sort(list, q+1, right);
        }

    }

    private static int partition(int[] list, int left, int right) {
        int pivot, temp = 0;

        int low = left;
        int high = right + 1;

        pivot = list[left];

        do {

            // pivot이 더 작은 애가 나올때까지
            do {
                low++;
            } while (low <= right && list[low] < pivot);

            // pivot이 더 큰 애가 나올때까지
            do {
                high--;
            } while (high >= left && list[high] > pivot);

            if (low < high) {
                temp = list[low];
                list[low] = list[high];
                list[high] = temp;
            }
        } while (low < high);

        // low와 high 가 교차 했어  그러면
        temp = list[left];
        list[left] = list[high];
        list[high] = temp;

        return high;
    }
}
