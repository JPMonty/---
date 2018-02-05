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

}
