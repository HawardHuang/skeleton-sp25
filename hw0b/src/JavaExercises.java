import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        int total = 0;
        for (int num : L) {
            total += num;
        }
        return total;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenList = new ArrayList<>();
        for (int num : L) {
            if (num % 2 == 0) {
                evenList.add(num);
            }
        }
        return evenList;
    }

    /** Returns a list containing the common items of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> commonList = new ArrayList<>();
        for (int num : L1) {
            if (L2.contains(num) && !commonList.contains(num)) {
                commonList.add(num);
            }
        }
        return commonList;
    }

    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (ch == c) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test sum
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("Sum: " + sum(numbers)); // Expected: 15

        // Test evens
        List<Integer> mixedNumbers = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Evens: " + evens(mixedNumbers)); // Expected: [2, 4, 6]

        // Test common
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = List.of(3, 4, 5, 6, 7);
        System.out.println("Common: " + common(list1, list2)); // Expected: [3, 4, 5]

        // Test countOccurrencesOfC
        List<String> words = List.of("apple", "banana", "cherry");
        System.out.println("Occurrences of 'a': " + countOccurrencesOfC(words, 'a')); // Expected: 4
    }
}
