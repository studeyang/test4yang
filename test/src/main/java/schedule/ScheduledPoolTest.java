package schedule;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lenovo
 */
public class ScheduledPoolTest {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor etc = new ScheduledThreadPoolExecutor(10, new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build());
        System.out.println("start");
        etc.scheduleWithFixedDelay(
                () -> System.out.println("running"),
                10,
                5,
                TimeUnit.SECONDS
        );
    }

}
