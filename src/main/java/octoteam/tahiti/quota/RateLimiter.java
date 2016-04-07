package octoteam.tahiti.quota;

/**
 * TODO
 */
public class RateLimiter extends QuotaLimiter {

    /**
     * TODO
     *
     * @param QPS
     */
    public RateLimiter(double QPS) {

    }

    /**
     * TODO
     *
     * @return
     */
    public boolean tryAcquire() {
        return false;
    }

    /**
     * TODO
     *
     * @return
     */
    public double getQPS() {
        return 0.0;
    }

}
