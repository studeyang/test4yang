package future;

import org.junit.Test;

import java.util.concurrent.*;

public class FutureTest {

    @Test
    public void futureTest() throws ExecutionException, InterruptedException {
        Callable<String> task = new Task();
        ExecutorService executor = new ThreadPoolExecutor(
                1,
                1,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(10));
        Future<String> result = executor.submit(task);
        System.out.println("start.");
        System.out.println(result.get());
        executor.shutdown();
    }

}

class Task implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(3000);
        return "success";
    }

}
