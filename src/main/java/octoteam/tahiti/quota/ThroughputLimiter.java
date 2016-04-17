package octoteam.tahiti.quota;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 基于吞吐率的限流器。获得令牌超过每秒的吞吐率阈值限制后，就停止提供服务.
 */
public class ThroughputLimiter extends QuotaLimiter {

    private double QPS;
    private RateLimiter rl;

    /**
     * 根据传入数值设置吞吐率阈值.
     *
     * @param QPS 每秒吞吐率阈值.
     */
    public ThroughputLimiter(double QPS) {
        this.QPS = QPS;
        reset();
    }

    /**
     * 根据 RateLimiter 对象创建限流器
     *
     * @param limiter RateLimiter 对象
     */
    public ThroughputLimiter(RateLimiter limiter) {
        this.QPS = limiter.getRate();
        rl = limiter;
    }

    /**
     * {@inheritDoc}
     */
    public boolean tryAcquire(int permits) {
        return rl.tryAcquire(permits);
    }

    /**
     * 获取当前吞吐率阈值.
     *
     * @return 吞吐率阈值
     */
    public double getQPS() {
        return this.QPS;
    }

    /**
     * 设定吞吐率阈值 (仅对后续请求生效)
     *
     * @param QPS 吞吐率阈值
     */
    public void setQPS(double QPS) {
        this.QPS = QPS;
        rl.setRate(QPS);
    }

    /**
     * {@inheritDoc}
     */
    public void reset() {
        rl = RateLimiter.create(QPS);
    }

}
