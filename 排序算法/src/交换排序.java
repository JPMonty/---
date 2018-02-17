import org.junit.Test;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/2/12 下午3:45
 */
public class 交换排序 extends 排序 {
    /**
     * O(n2)
     */
    @Test
    public void 冒泡排序() {

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (after_queue[j] > after_queue[j + 1]) {
                    int tmp = after_queue[j];
                    after_queue[j] = after_queue[j + 1];
                    after_queue[j + 1] = tmp;
                }
            }
        }
    }


    @Test
    public void 快速排序() {

        quick_sort(1, size - 1, 0);

    }


    private void quick_sort(int i, int j, int base) {

        if (i > j) return;
        if (i == j) {
            if (after_queue[i] < after_queue[base]) {
                int tmp = after_queue[i];
                after_queue[i] = after_queue[base];
                after_queue[base] = tmp;
            }
            return;
        }

        int start = i;
        int end = j;
        int absolute_base = base;

        while (i < j) {

            while (after_queue[j] >= after_queue[base] && i < j) {
                j--;
            }

            while (after_queue[i] <= after_queue[base] && i < j) {
                i++;
            }

            if (i != j) {
                int tmp = after_queue[i];
                after_queue[i] = after_queue[j];
                after_queue[j] = tmp;
            } else {

                if (after_queue[i] < after_queue[base]) {

                    int tmp = after_queue[i];
                    after_queue[i] = after_queue[base];
                    after_queue[base] = tmp;

                    // 重要：标志新的base位置
                    base = i;
                }

            }
        }

        quick_sort(start, base - 1, absolute_base);

        quick_sort(base + 2, end, base + 1);

    }


    @Test
    public void 归并排序() {

        mergeSort(0, size - 1);

    }


    /**
     *
     *   i。。。。。。。。。。。。。。。。j
     *          s = j - i
     *   k.......i+s/2,i+s/2+1........m
     *
     *
     * @param i
     * @param j
     */
    private void mergeSort(int i, int j) {
        if (i >= j) return;
        int s = j - i;
        mergeSort(i, i + s / 2);
        mergeSort(i + s / 2 + 1, j);

        int[] tmp = new int[j - i + 1];

        int k = i;
        int m = i + s / 2 + 1;

        for (int n = 0; n < tmp.length; n++) {
            if (k > i + s / 2) {
                tmp[n] = after_queue[m++];
            } else if (m > j) {
                tmp[n] = after_queue[k++];
            } else {
                tmp[n] = after_queue[k] > after_queue[m] ? after_queue[m++] : after_queue[k++];
            }
        }

        for (int n = i, x = 0; n <= j; n++) {
            after_queue[n] = tmp[x++];
        }
    }


}
