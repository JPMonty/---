import org.junit.Test;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/1/17 下午4:46
 */
public class 选择排序 extends 排序 {
    /**
     * O(n2)
     */
    @Test
    public void 简单选择排序() {

        for (int i = 0; i < size; i++) {
            int k = i;
            // 找最小值的下标
            for (int j = i + 1; j < size; j++) {
                if (after_queue[j] < after_queue[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int x = after_queue[k];
                after_queue[k] = after_queue[i];
                after_queue[i] = x;
            }
        }

    }


    /**
     * O(n2)
     */
    @Test
    public void 二元选择排序() {

        for (int i = 0; i < size / 2; i++) {
            int min = i;
            int max = i;

            for (int j = i + 1; j < size - i; j++) {

                if (after_queue[j] > after_queue[max]) {
                    max = j;
                    continue;
                }
                if (after_queue[j] < after_queue[min]) {
                    min = j;
                }
            }
            // 重要！
            // 需要考虑特殊情况
            // 序列的最小值和最大值正好在序列的两端
            if (max == i) {
                int tmp;
                tmp = after_queue[max];
                after_queue[max] = after_queue[size - i - 1];
                after_queue[size - i - 1] = tmp;

                if (min != size - i - 1) {
                    tmp = after_queue[i];
                    after_queue[i] = after_queue[min];
                    after_queue[min] = tmp;
                }
            } else if (min == size - i - 1) {
                int tmp;
                tmp = after_queue[i];
                after_queue[i] = after_queue[min];
                after_queue[min] = tmp;

                if (max != i) {
                    tmp = after_queue[max];
                    after_queue[max] = after_queue[size - i - 1];
                    after_queue[size - i - 1] = tmp;
                }
            } else {
                int tmp;
                tmp = after_queue[i];
                after_queue[i] = after_queue[min];
                after_queue[min] = tmp;
                tmp = after_queue[size - i - 1];
                after_queue[size - i - 1] = after_queue[max];
                after_queue[max] = tmp;
            }

        }
    }



    /**
     * 树形选择排序
     * O(nlog2(n))
     */
    @Test
    public void 堆排序() {
        // 构建大顶堆
        for (int i = size / 2 - 1; i >= 0; i--) {
            // 从第一个非叶子节点从下至上，从右至左调整结构
            adjustHeap(after_queue, i, size);
        }

        // ---------
        // after_queue已成大顶堆形态
        // ---------

        // 调整堆结构（交换堆顶元素和末尾元素）
        for (int j = size - 1; j > 0; j--) {
            // 交换
            int tmp = after_queue[j];
            after_queue[j] = after_queue[0];
            after_queue[0] = tmp;
            // 重新调整大顶堆
            adjustHeap(after_queue, 0, j);
        }
    }

    /**
     * 调整大顶堆 （仅是调整过程，建立在大顶堆已构建的基础上）
     * @param after_queue
     * @param i
     * @param length      堆大小
     */
    private void adjustHeap(int[] after_queue, int i, int length) {

        // 存放住
        int tmp = after_queue[i];

        // k=2*i+1; k是左节点，k+1是右节点
        // 如果k > length - 1就是说明 [i] 自身是个子节点，直接退出循环
        for (int k = 2 * i + 1; k <= length - 1; k = 2 * i + 1) {

            if (k + 1 <= length - 1 && after_queue[k + 1] > after_queue[k]) { // 如果左子节点小于右子节点，k指向右子节点
                k = k + 1;
            }

            if (after_queue[k] > tmp) {  // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                after_queue[i] = after_queue[k];
                i = k;
            } else {
                break;
            }
        }

        after_queue[i] = tmp;
    }

}
