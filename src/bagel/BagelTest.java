package bagel;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runners.JUnit4;

public class BagelTest {

    @Test
    public void testBagel() {
        Bagel bagel = BagelSolver.getBagel();

        org.junit.Assert.assertEquals(
            bagel.getValue() == 4,
            java.lang.Boolean.TRUE
        );
    }

}