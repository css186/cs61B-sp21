package flik;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestFlik {

    @Test
    public void testEqual() {
        assertTrue(Flik.isSameNumber(128, 128));
    }
}
