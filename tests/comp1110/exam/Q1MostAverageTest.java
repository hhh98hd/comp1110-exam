package comp1110.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.StringJoiner;

public class Q1MostAverageTest {

    public void doTest(int[] in, int out) {
	int rv = Q1MostAverage.mostAverage(in);
	StringJoiner j = new StringJoiner(", ");
	for (int n : in) j.add(Integer.toString(n));
	assertEquals(out, rv, "mostAverage({" + j.toString() + "})");
    }

    @Test
    public void set1() {
	doTest(new int[]{1, 2, 3, 4, 5}, 3);
	doTest(new int[]{3, 4, 5, 1}, 3);
	doTest(new int[]{-4, 5, 2}, 2);
	doTest(new int[]{5, 2, -3}, 2);
	doTest(new int[]{-6, 3, -4, 5, -7, 9}, 3);
	doTest(new int[]{6, -3, 4, -5, 7, 9}, 4);
    }
    
    @Test
    public void set2() {
	doTest(new int[]{3, 4, 3, 1}, 3);
	doTest(new int[]{6, 3, 4, 5, 7, 9}, 6);
    }
    
}
