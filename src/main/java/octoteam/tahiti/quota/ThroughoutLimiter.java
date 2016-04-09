package octoteam.tahiti.quota;
import com.google.common.util.concurrent.RateLimiter;

/**
 * 基于吞吐率的限流器。获得令牌超过每秒的吞吐率阈值限制后，就停止提供服务.
 */
public class ThroughoutLimiter extends QuotaLimiter {

    private final double QPS;
    private final RateLimiter rl;

    /**
     * 根据传入数值设置吞吐率阈值.
     *
     * @param QPS 每秒吞吐率阈值.
     */
    public ThroughoutLimiter(double QPS) {
        this.QPS = QPS;
        rl = RateLimiter.create(QPS);
    }

    /**
     * 尝试获取令牌,判断是否到达吞吐率阈值,
     * 请求RateLimiter, 超过阈值会被阻塞.
     *
     * @return 如果未超出阈值返回 true, 否则返回 false.
     */
    public boolean tryAcquire() {
        return rl.tryAcquire();
    }

    /**
     * 获取预设的吞吐率阈值.
     *
     * @return 返回预设的吞吐率阈值.
     */
    public double getQPS() {
        return this.QPS;
    }

}
