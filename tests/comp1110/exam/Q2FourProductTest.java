package comp1110.exam;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Q2FourProductTest {

    public static void doTest(String in, int out) {
        assertEquals(out, Q2FourProduct.fourProduct(in), "fourProduct(" + in + ")");
    }

    @Test
    public void testFourProduct() {
        doTest("1414", 8);
        doTest("2222", 8);
        doTest("44", 8);
        doTest("8221", 12);
        doTest("81", 8);
        doTest("8", 0);
        doTest("1", 1);
        doTest("3453", 11);
        doTest("0", 0);
        doTest("-1", -1);
        doTest("", -1);
        doTest("bar", -1);
        doTest("3bar", -1);
    }
}
