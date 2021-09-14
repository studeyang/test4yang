package timingwheel;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author darren
 * @date 2016/11/17
 */
public class Main implements TimerTask {

    public static void main(String[] args) {

        Timer timerWheel = new TimerWheel();

        TimerTask timerTask = new Main();

        System.out.println(new Date());

        for (int i = 0; i < 10; i++) {
            timerWheel.newTimeout(timerTask, 1, TimeUnit.SECONDS, "" + i);
        }

    }

    @Override
    public void run(Timeout timeout, String argv) {

        System.out.println("timeout, argv = " + argv + ", current = " + new Date());
    }

}