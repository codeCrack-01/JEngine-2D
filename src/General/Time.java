package General;

public class Time {
    private long startTime;
    private long lastTime;
    public static double deltaTime;
    private double timeScale;

    public Time() {
        this.startTime = System.nanoTime();
        this.lastTime = this.startTime;
        this.deltaTime = 0;
        this.timeScale = 1.0;
    }

    public void update() {
        long currentTime = System.nanoTime();
        this.deltaTime = (currentTime - this.lastTime) / 1_000_000_000.0 * this.timeScale;
        this.lastTime = currentTime;
    }

    public double getDeltaTime() {
        return deltaTime;
    }

    public void setTimeScale(double timeScale) {
        this.timeScale = timeScale;
    }

    public double getTimeScale() {
        return this.timeScale;
    }
}

