import org.junit.Test;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/1/17 下午4:46
 */
public class 选择排序 extends 排序 {


    /**
     *  O(n2)
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


}
