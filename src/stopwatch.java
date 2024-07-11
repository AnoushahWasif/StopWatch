public class stopwatch {
    private long startTime;
    private long elapsedTime;
    private boolean isRunning;

    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    public void stop() {
        if (isRunning) {
            elapsedTime += System.currentTimeMillis() - startTime;
            isRunning = false;
        }
    }

    public void reset() {
        elapsedTime = 0;
        isRunning = false;
    }

    public long getElapsedTime() {
        if (isRunning) {
            return elapsedTime + (System.currentTimeMillis() - startTime);
        } else {
            return elapsedTime;
        }
    }
}
