package octoteam.tahiti.quota;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ThroughputLimiterTest {

    @Test
    public void testThroughputLimiter() {
        RateLimiter mockRateLimiter = mock(RateLimiter.class);
        when(mockRateLimiter.tryAcquire()).thenReturn(true);

        ThroughputLimiter limiter = new ThroughputLimiter(mockRateLimiter);
        limiter.tryAcquire();

        verify(mockRateLimiter).tryAcquire();
    }

    @Test
    public void testGetQPS() {
        ThroughputLimiter limiter = new ThroughputLimiter(10.0);
        assertEquals(10.0, limiter.getQPS(), 0.0);
    }

}