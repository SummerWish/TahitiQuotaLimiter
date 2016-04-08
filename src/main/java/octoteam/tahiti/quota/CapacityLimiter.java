package octoteam.tahiti.quota;

/**
 * 基于容量的限流器。获得令牌超过允许容量阈值限制后，就停止提供服务.
 */
public class CapacityLimiter extends QuotaLimiter {

    private final int capacity;
    private int acquired = 0;

    /**
     * 根据传入数值设置容量阈值
     *
     * @param capacity int 容量阈值
     */
    public CapacityLimiter(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 尝试获取令牌,判断是否到达容量阈值.
     *
     * @return 如果未超出阈值返回 true, 否则返回 false.
     */
    public boolean tryAcquire() {
        if (acquired < capacity) {
            acquired++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取预设的容量阈值.
     *
     * @return 返回预设的容量阈值.
     */
    public int getCapacity() {
        return this.capacity;
    }

}

