package octoteam.tahiti.quota;

/**
 * 所有限流类的抽象类, 提供了通用接口
 */
public abstract class QuotaLimiter {

    /**
     * 尝试获取令牌 (判断是否到达阈值)
     *
     * @return 如果未超出阈值返回 true，否则返回 false。
     */
    public abstract boolean tryAcquire();

}
