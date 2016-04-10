package octoteam.tahiti.quota;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 基于吞吐率的限流器。获得令牌超过每秒的吞吐率阈值限制后，就停止提供服务.
 */
public class ThroughputLimiter extends QuotaLimiter {

    private final double QPS;
    private final RateLimiter rl;

    /**
     * 根据传入数值设置吞吐率阈值.
     *
     * @param QPS 每秒吞吐率阈值.
     */
    public ThroughputLimiter(double QPS) {
        this.QPS = QPS;
        rl = RateLimiter.create(QPS);
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
    public boolean tryAcquire() {
        return rl.tryAcquire();
    }

    /**
     * 获取预设的吞吐率阈值.
     *
     * @return 吞吐率阈值
     */
    public double getQPS() {
        return this.QPS;
    }

}
