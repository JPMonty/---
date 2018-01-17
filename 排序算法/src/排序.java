import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/1/15 下午5:52
 */

public class 排序 {


    protected static final int[] before_random_queue = {83, 80, 7, 1, 30, 22, 52, 47, 15, 73, 63, 63, 21, 25, 4, 2, 76, 33, 50, 81, 27, 79, 7, 93, 75, 7, 5, 95, 0, 9, 19, 76, 34, 39, 94, 31, 64, 24, 43, 59, 65, 53, 62, 31, 91, 66, 81, 35, 1, 33, 87, 45, 90, 82, 68, 94, 20, 41, 33, 84, 80, 82, 18, 49, 51, 36, 57, 6, 53, 2, 50, 93, 22, 26, 13, 41, 18, 0, 83, 37, 91, 67, 60, 56, 74, 19, 79, 28, 27, 35, 60, 60, 97, 57, 0, 49, 26, 29, 35, 13};

    protected static final int[] sorted =
            {0, 0, 0, 1, 1, 2, 2, 4, 5, 6, 7, 7, 7, 9, 13, 13, 15, 18, 18, 19, 19, 20, 21, 22, 22, 24, 25, 26, 26, 27, 27, 28, 29, 30, 31, 31, 33, 33, 33, 34, 35, 35, 35, 36, 37, 39, 41, 41, 43, 45, 47, 49, 49, 50, 50, 51, 52, 53, 53, 56, 57, 57, 59, 60, 60, 60, 62, 63, 63, 64, 65, 66, 67, 68, 73, 74, 75, 76, 76, 79, 79, 80, 80, 81, 81, 82, 82, 83, 83, 84, 87, 90, 91, 91, 93, 93, 94, 94, 95, 97};

    protected static final int num = before_random_queue.length;

    protected int[] after_queue = Arrays.copyOf(before_random_queue, before_random_queue.length);

    protected long start_nano;

    protected long end_nano;

    @Before
    public void start() {
        start_nano = System.nanoTime();
        System.out.println("开始算法：--" + start_nano + "--ns");
    }


    @After
    public void end() {
        end_nano = System.nanoTime();
        System.out.println("结束算法：--" + end_nano + "--ns");
        System.out.println("耗时:--" + (end_nano - start_nano) + "--ns");
        System.out.println("耗时:--" + ((end_nano - start_nano) * 1.0 / 1000 / 1000 / 1000) + "--s");

        System.out.println("排序结果: =>");
        System.out.println(Arrays.toString(after_queue));
        boolean flag = Arrays.equals(sorted, after_queue);
        if (flag) {
            System.out.println("排序成功!");
        } else {
            System.out.println("排序失败!");
        }
    }



}
