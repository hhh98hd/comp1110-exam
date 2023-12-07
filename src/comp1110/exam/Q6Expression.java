package comp1110.exam;

/**
 * The class Q6Expression represents an arithmethic expression, made
 * up of integer constants and two binary operators (+ and *). The
 * class is abstract: any Expression instance must be an instance
 * of one of the two subclasses Constant or Operator, defined below.
 *
 * You must implement the `equals` and `hashCode` methods of the two
 * subclasses.
 *
 * Two Expressions are equal if they represent the exact same expression,
 * including ordering and grouping of terms. For example, 1 + 2 and 2 + 1
 * are not considered equal, even if they evaluate to the same value.
 *
 * Your hash functions do not have to be perfect, but they should be
 * non-trivial (hashing a collection of different Expressions should
 * yield a number of different hash values, although not necessarily
 * as many as the number of Expressions hashed).
 *
 * Remember that two objects that are equal must have the same hash
 * value.
 */
public abstract class Q6Expression {

    /*
     * Returns the value of the Expression.
     */
    public abstract int evaluate();

}

class Constant extends Q6Expression {
    int value;

    Constant(int value) {
	this.value = value;
    }

    public int evaluate() {
	return value;
    }

    public boolean equals(Object other) {
	// FIXME
	return false;
    }

    public int hashCode() {
	// FIXME
	return 0;
    }
}

enum OperatorType {
    SUM, PRODUCT;

    public String toString() {
	switch (this) {
	case SUM:
	    return "+";
	case PRODUCT:
	    return "*";
	}
	return "?";
    }
}

class Operator extends Q6Expression {
    OperatorType type;
    Q6Expression left;
    Q6Expression right;

    Operator(OperatorType type, Q6Expression left, Q6Expression right) {
	this.type = type;
	this.left = left;
	this.right = right;
    }

    public int evaluate() {
	int lv = left.evaluate();
	int rv = right.evaluate();
	switch (type) {
	case SUM:
	    return lv + rv;
	case PRODUCT:
	    return lv * rv;
	}
	return 0;
    }

    public boolean equals(Object other) {
	// FIXME
	return false;
    }

    public int hashCode() {
	// FIXME
	return 0;
    }
}
