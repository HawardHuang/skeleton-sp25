import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {

    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> letterMap = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            letterMap.put(c, c - 'a' + 1);
        }
        return letterMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> squareMap = new HashMap<>();
        for (int num : nums) {
            squareMap.put(num, num * num);
        }
        return squareMap;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public static void main(String[] args) {
        // Test letterToNum
        Map<Character, Integer> letterMap = letterToNum();
        System.out.println("Letter to Number (a to z): " + letterMap);

        // Test squares
        List<Integer> numbers = List.of(1, 3, 6, 7);
        System.out.println("Squares: " + squares(numbers));

        // Test countWords
        List<String> words = List.of("apple", "banana", "apple", "cherry", "banana", "banana");
        System.out.println("Word Counts: " + countWords(words));
    }
}
