package octoteam.tahiti.quota;

import org.junit.Test;

import static org.junit.Assert.*;

public class CapacityLimiterTest {

    @Test
    public void testCapacityLimiter() {
        CapacityLimiter limiter = new CapacityLimiter(4);
        assertEquals(4, limiter.getCapacity());
        assertTrue(limiter.tryAcquire());
        assertTrue(limiter.tryAcquire());
        assertTrue(limiter.tryAcquire());
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
    }

}