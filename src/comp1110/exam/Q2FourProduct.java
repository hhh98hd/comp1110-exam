package comp1110.exam;

public class Q2FourProduct {

    /**
     * Input to the method is a string.
     *
     * Return the sum of the even-valued digits if the string represents a
     * FourProduct number.
     * Return the sum of the odd-valued digits if the string represents a
     * number that is not a FourProduct number.
     *
     * In any other case (for example, if the input string empty or does
     * not represent a number) return -1.
     *
     * A FourProduct number is defined recursively by the following rules:
     * a) is a non-negative integer with an even number of digits (strings
     * with leading zeros are equivalent to their integer value, e.g. 00044
     * equivalent to 44);
     * b) the product of its first and last digits are divisible by four;
     * c) after removing the first and last digits, the remaining digits are
     * still a FourProduct number, or an empty string
     *
     * Examples of FourProduct numbers: "1414", "2222", "44", "8221", "88",
     * "84", "1540". As these are FourProduct numbers this method should
     * return 8, 8, 8, 12, 16, 12, 4, respectively.
     *
     * Examples that are NOT FourProduct numbers: "444", "22", "1", "3453",
     * "1234". As these aren't FourProduct numbers this method should return
     * 0, 0, 1, 11, 4, respectively.
     *
     * @param number A string
     * @return The sum of the even-valued digits if the string represents
     * a FourProduct number, the sum of the odd-valued digits if the string
     * represents a number that is not a FourProduct number, and -1 in any
     * other case.
     */

    public static int fourProduct(String number) {
	// FIXME: implement this method
	return 0;
    }

}
