import org.junit.Test;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/2/12 下午3:45
 */
public class 交换排序 extends 排序 {
    /**
     * O(n2)
     *
     */
    @Test
    public void 冒泡排序() {

        for (int i  = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (after_queue[j] > after_queue[j + 1]) {
                    int tmp =  after_queue[j];
                    after_queue[j] = after_queue[j + 1];
                    after_queue[j + 1] = tmp;
                }
            }
        }
    }
}
