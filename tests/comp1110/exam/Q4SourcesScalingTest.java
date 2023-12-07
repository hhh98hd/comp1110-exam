package comp1110.exam;

import static java.lang.Math.*;
import static comp1110.exam.Q4SourcesTest.intPow;
import static comp1110.exam.Q4SourcesTest.testCounts1;

public class Q4SourcesScalingTest {
    /**
     * Test scaling behaviour: if all operations are (amortised) constant
     * time, the total time for each size (2^B .. 2^(B + M - 1)) should be
     * roughly equal.
     */
    static void testScaling() {
        final int M = 8;
        final int B = 10;
        int R = intPow(2, M) * 100;
        long[] times = new long[M];
        // primer
        for (int i = 0; i < 100; i++) {
            testCounts1(B + M - 1);
        }
        for (int s = 0; s < M; s++) {
            long t0 = System.nanoTime();
            for (int i = 0; i < R; i++) {
                testCounts1(B + s);
            }
            long t1 = System.nanoTime();
            times[s] = t1 - t0;
            R = R / 2;
        }
        for (int s = 0; s < M; s++)
            System.out.println("size " + intPow(2, B + s) + ": time = " + times[s]);
        long tmax = times[0];
        long tmin = times[0];
        double sum = times[0];
        int nInc = 0;
        for (int s = 1; s < M; s++) {
            tmax = max(tmax, times[s]);
            tmin = min(tmin, times[s]);
            sum += times[s];
            if (times[s] > times[s - 1])
                nInc += 1;
        }
        double avg = sum/M;
        double rd1 = ((double)abs(tmax - avg))/avg;
        double rd2 = ((double)abs(tmax - avg))/avg;
        System.out.println("max relative difference: " +
                (max(rd1, rd2) * 100) + "%");
        System.out.println("# increasing: " +
                nInc + " / " + (M - 1));
    }

    public static void main(String[] args) {
        testScaling();
    }

}
