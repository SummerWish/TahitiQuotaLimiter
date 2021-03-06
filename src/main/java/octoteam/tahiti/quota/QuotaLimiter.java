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
    public boolean tryAcquire() {
        return tryAcquire(1);
    }

    /**
     * 尝试获取给定数量的一批令牌, 如果能被获取且获取后不会超出限额
     *
     * @param permits 请求的令牌数量
     * @return 如果请求的令牌都能立即获取则返回 true
     */
    public abstract boolean tryAcquire(int permits);

    /**
     * 按当前配置重置令牌
     */
    public abstract void reset();

}
