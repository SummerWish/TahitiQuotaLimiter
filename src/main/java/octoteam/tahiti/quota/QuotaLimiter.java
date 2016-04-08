package octoteam.tahiti.quota;

/**
 * 所有类型的 Limiter 都应该继承该抽象类, 使用 tryAcquire() 判断是否到达阈值,
 * 基于已收到的消息数量和预设的阈值来判断是否继续提供服务.
 */
public abstract class QuotaLimiter {

    /**
     * 尝试获取令牌,判断是否到达阈值
     *
     * @return 如果未超出阈值返回 true，否则返回 false。
     */
    public abstract boolean tryAcquire();

}
