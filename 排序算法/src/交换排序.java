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


    /**
     *  归并排序 - 递归实现
     */
    @Test
    public void 归并排序_recycle() {

        mergeSort_recycle(0, size - 1);

    }


    /**
     *  归并排序 - 迭代实现
     */
    @Test
    public void 归并排序_iterate() {
        int n = 2;
        for (; n - 1 <= size; n *= 2) {
            mergeSort_iterate(n);
        }

        mergeSort_iterate(n);
    }

    private void mergeSort_iterate(int n) {
        if (n / 2 > size) return;

        for (int i = 0; i < size; i += n) {
            int j  = i + n - 1;
            if (j > size - 1) {
                j = size - 1;
            }

            if (j == i) continue;

            int s = n / 2;
            int k = i;
            int m = i + s;

            int[] tmp = new int[j - i + 1];

            for (int tn = 0; tn < j - i + 1; tn++) {
                if (k > i + s - 1) {
                    tmp[tn] = after_queue[m++];
                } else if (m > j) {
                    tmp[tn] = after_queue[k++];
                } else {
                    tmp[tn] = after_queue[m] > after_queue[k] ? after_queue[k++] : after_queue[m++];
                }
            }

            for (int x = i, tn = 0; x <= j; x++) {
                after_queue[x] = tmp[tn++];
            }

        }
    }


    /**
     *
     *   i。。。。。。。。。。。。。。。。j
     *           s = j - i
     *   i。。。。i+s/2,i+s/2+1。。。。。j
     *
     *   k = i         m = i+s/2+1
     *   k----------->,m-------------->
     *
     *
     * @param i
     * @param j
     */
    private void mergeSort_recycle(int i, int j) {
        if (i >= j) return;
        int s = j - i;
        mergeSort_recycle(i, i + s / 2);
        mergeSort_recycle(i + s / 2 + 1, j);

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
