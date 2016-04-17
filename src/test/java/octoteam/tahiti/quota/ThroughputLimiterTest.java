package octoteam.tahiti.quota;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ThroughputLimiterTest {

    @Test
    public void testAcquireOneToken() {
        RateLimiter mockRateLimiter = mock(RateLimiter.class);

        ThroughputLimiter limiter = new ThroughputLimiter(mockRateLimiter);
        limiter.tryAcquire();

        verify(mockRateLimiter).tryAcquire(1);
    }

    @Test
    public void testAcquireMultipleToken() {
        RateLimiter mockRateLimiter = mock(RateLimiter.class);

        ThroughputLimiter limiter = new ThroughputLimiter(mockRateLimiter);
        limiter.tryAcquire(10);

        verify(mockRateLimiter).tryAcquire(10);
    }

    @Test
    public void testReset() {
        ThroughputLimiter limiter = new ThroughputLimiter(1.0);
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
        limiter.reset();
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
    }

    @Test
    public void testGetQPS() {
        ThroughputLimiter limiter = new ThroughputLimiter(10.0);
        assertEquals(10.0, limiter.getQPS(), 0.0);
    }

    @Test
    public void testSetQPS() {
        RateLimiter rl = RateLimiter.create(10.0);
        ThroughputLimiter limiter = new ThroughputLimiter(rl);
        limiter.setQPS(20.0);
        assertEquals(20.0, limiter.getQPS(), 0.0);
        assertEquals(20.0, rl.getRate(), 0.0);
    }

}