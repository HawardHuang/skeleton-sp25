import java.util.ArrayList;
import java.util.List;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
        return new int[] {1, 2, 3, 4, 5, 6};
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        if ("Ergun".equalsIgnoreCase(customer)) {
            return new String[]{"beyti", "pizza", "hamburger", "tea"};
        } else if ("Erik".equalsIgnoreCase(customer)) {
            return new String[]{"sushi", "pasta", "avocado", "coffee"};
        } else {
            return new String[3]; // Empty array of size 3
        }
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return max - min;
    }

    /**
     * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
     * Hailstone sequence is described as:
     *    - Pick a positive integer n as the start
     *        - If n is even, divide n by 2
     *        - If n is odd, multiply n by 3 and add 1
     *    - Continue this process until n is 1
     */
    public static List<Integer> hailstone(int n) {
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        list.add(x);
        if (x == 1) {
            return list;
        } else if (x % 2 == 0) {
            return hailstoneHelper(x / 2, list);
        } else {
            return hailstoneHelper(3 * x + 1, list);
        }
    }

    public static void main(String[] args) {
        // Test makeDice
        System.out.println("makeDice: " + java.util.Arrays.toString(makeDice()));

        // Test takeOrder
        System.out.println("Ergun's order: " + java.util.Arrays.toString(takeOrder("Ergun")));
        System.out.println("Erik's order: " + java.util.Arrays.toString(takeOrder("Erik")));
        System.out.println("Unknown customer's order: " + java.util.Arrays.toString(takeOrder("Alice")));

        // Test findMinMax
        int[] testArray = {4, 2, 9, 1, 7};
        System.out.println("findMinMax: " + findMinMax(testArray));

        // Test hailstone
        System.out.println("Hailstone sequence (start 7): " + hailstone(7));
    }
}
