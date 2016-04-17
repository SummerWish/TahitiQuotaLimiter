package octoteam.tahiti.quota;

/**
 * 基于容量的限流器。获得令牌超过允许容量阈值限制后，就停止提供服务.
 */
public class CapacityLimiter extends QuotaLimiter {

    private int capacity;
    private int acquired;

    /**
     * 根据传入数值设置容量阈值
     *
     * @param capacity int 容量阈值
     */
    public CapacityLimiter(int capacity) {
        this.capacity = capacity;
        reset();
    }

    /**
     * {@inheritDoc}
     */
    public boolean tryAcquire(int permits) {
        if (acquired + permits <= capacity) {
            acquired += permits;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取当前容量阈值.
     *
     * @return 容量阈值
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * 设置容量阈值, 仅对后续请求有效
     *
     * @param capacity 容量阈值
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * {@inheritDoc}
     */
    public void reset() {
        acquired = 0;
    }
}

