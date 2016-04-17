package octoteam.tahiti.quota;

import org.junit.Test;

import static org.junit.Assert.*;

public class CapacityLimiterTest {

    @Test
    public void testAcquireOneToken() {
        CapacityLimiter limiter = new CapacityLimiter(4);
        assertTrue(limiter.tryAcquire());
        assertTrue(limiter.tryAcquire());
        assertTrue(limiter.tryAcquire());
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
    }

    @Test
    public void testAcquireMultipleToken() {
        CapacityLimiter limiter = new CapacityLimiter(6);
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire(6));
        assertFalse(limiter.tryAcquire(7));
        assertFalse(limiter.tryAcquire(8));
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire(6));
        assertTrue(limiter.tryAcquire(3));
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
    }

    @Test
    public void testReset() {
        CapacityLimiter limiter = new CapacityLimiter(2);
        assertTrue(limiter.tryAcquire(2));
        assertFalse(limiter.tryAcquire());
        limiter.reset();
        assertTrue(limiter.tryAcquire(2));
    }

    @Test
    public void testGetCapacity() {
        CapacityLimiter limiter = new CapacityLimiter(4);
        assertEquals(4, limiter.getCapacity());
    }

    @Test
    public void testSetCapacity() {
        CapacityLimiter limiter = new CapacityLimiter(1);
        assertTrue(limiter.tryAcquire());
        assertFalse(limiter.tryAcquire());
        limiter.setCapacity(5);
        assertEquals(5, limiter.getCapacity());
        assertTrue(limiter.tryAcquire(4));
        assertFalse(limiter.tryAcquire());
    }

}