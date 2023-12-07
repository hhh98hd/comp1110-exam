package comp1110.exam;

// dev: imports used by testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;
import java.util.HashSet;

public class Q6ExpressionTest {

    static final String[] cases = {
	"2",
	"2 0 *",
	"0 2 +",
	"2 0 2 * +",
	"2 0 2 + *",
	"2 0 2 + +",
	"1 2 + 3 4 + +",
	"1 2 + 3 4 + *",
	"1 2 * 3 4 * +",
	"1 2 + 3 + 4 +",
	"1 2 3 4 + + +",
	"1 3 + 2 4 + +",
	"1 3 + 2 + 4 +",
	"1 3 2 4 + + +",
	"4 3 + 1 2 + +",
	"3 4 + 1 2 + *",
	"3 4 * 2 1 * +",
	"5 6 + 7 8 + +",
	"5 6 + 7 + 8 +",
	"5 6 7 8 + + +"
    };

    static String[] readable = new String[]{
	"2",
	"(2 * 0)",
	"(0 + 2)",
	"(2 + (0 * 2))",
	"(2 * (0 + 2))",
	"(2 + (0 + 2))",
	"((1 + 2) + (3 + 4))",
	"((1 + 2) * (3 + 4))",
	"((1 * 2) + (3 * 4))",
	"(((1 + 2) + 3) + 4)",
	"(1 + (2 + (3 + 4)))",
	"((1 + 3) + (2 + 4))",
	"(((1 + 3) + 2) + 4)",
	"(1 + (3 + (2 + 4)))",
	"((4 + 3) + (1 + 2))",
	"((3 + 4) * (1 + 2))",
	"((3 * 4) + (2 * 1))",
	"((5 + 6) + (7 + 8))",
	"(((5 + 6) + 7) + 8)",
	"(5 + (6 + (7 + 8)))"
    };

    public static Q6Expression parse(String s) {
	String[] tokens = s.split(" ");
	Stack<Q6Expression> stack = new Stack<Q6Expression>();
	for (int i = 0; i < tokens.length; i++) {
	    if (tokens[i].equals("+")) {
		Q6Expression rhs = stack.pop();
		Q6Expression lhs = stack.pop();
		stack.push(new Operator(OperatorType.SUM, lhs, rhs));
	    }
	    else if (tokens[i].equals("*")) {
		Q6Expression rhs = stack.pop();
		Q6Expression lhs = stack.pop();
		stack.push(new Operator(OperatorType.PRODUCT, lhs, rhs));
	    }
	    else {
		int v = Integer.parseInt(tokens[i]);
		stack.push(new Constant(v));
	    }
	}
	return stack.pop();
    }

    @Test
    void testEquals() {
	// two copies of each expression should be equal
	for (int i = 0; i < cases.length; i++) {
	    Q6Expression exp1 = parse(cases[i]);
	    Q6Expression exp2 = parse(cases[i]);
	    assertTrue(exp1.equals(exp2), readable[i] + " equals " + readable[i]);
	    assertTrue(exp2.equals(exp1), readable[i] + " equals " + readable[i]);
	}
	// each pair of different expressions should be not equal
	for (int i = 0; i + 1 < cases.length; i++)
	    for (int j = i + 1; j < cases.length; j++) {
		Q6Expression exp1 = parse(cases[i]);
		Q6Expression exp2 = parse(cases[j]);
		assertFalse(exp1.equals(exp2), readable[i] + " equals " + readable[j]);
		assertFalse(exp2.equals(exp1), readable[j] + " equals " + readable[i]);
	    }
    }

    @Test
    void testHashEq() {
	// two copies of each expression should hash to same value
	for (int i = 0; i < cases.length; i++) {
	    Q6Expression exp1 = parse(cases[i]);
	    Q6Expression exp2 = parse(cases[i]);
	    assertTrue(exp2.hashCode() == exp1.hashCode(), readable[i] + ".hashCode() == " + readable[i] + ".hashCode()");
	}
    }

    @Test
    void testHash2() {
	HashSet<Integer> values = new HashSet<Integer>();
	for (int i = 0; i < cases.length; i++) {
	    Q6Expression exp = parse(cases[i]);
	    values.add(exp.hashCode());
	}
	System.out.println(cases.length + " expressions hashed to " + values.size() + " distinct values");
	assertTrue(values.size() >= 2, Integer.toString(cases.length) + " expressions hashed to " + Integer.toString(values.size()) + " < 2 distinct values");
    }

    @Test
    void testHash6() {
	HashSet<Integer> values = new HashSet<Integer>();
	for (int i = 0; i < cases.length; i++) {
	    Q6Expression exp = parse(cases[i]);
	    values.add(exp.hashCode());
	}
	System.out.println(cases.length + " expressions hashed to " + values.size() + " distinct values");
	assertTrue(values.size() >= 6, Integer.toString(cases.length) + " expressions hashed to " + Integer.toString(values.size()) + " < 6 distinct values");
    }
    
    @Test
    void testHash16() {
	HashSet<Integer> values = new HashSet<Integer>();
	for (int i = 0; i < cases.length; i++) {
	    Q6Expression exp = parse(cases[i]);
	    values.add(exp.hashCode());
	}
	System.out.println(cases.length + " expressions hashed to " + values.size() + " distinct values");
	assertTrue(values.size() >= 16, Integer.toString(cases.length) + " expressions hashed to " + Integer.toString(values.size()) + " < 16 distinct values");
    }

}
