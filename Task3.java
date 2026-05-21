import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    // FIX: Use AtomicInteger for thread-safe increment operation
    private AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<StatementRecord> records) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {

            executor.submit(() -> {
                processRecord(record);

                // FIX: processedCount++ is not thread-safe
                // AtomicInteger ensures atomic increment
                processedCount.incrementAndGet();
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {
        return processedCount.get();
    }

    private void processRecord(StatementRecord record) {
        // Existing logic
    }
}
