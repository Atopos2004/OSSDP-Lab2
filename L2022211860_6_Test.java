import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution6Test {

    @Test
    public void testHappyPath() {
        Solution6 solution = new Solution6();
        
        List<List<String>> input1 = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"),
                Arrays.asList("google", "facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon")
        );
        List<Integer> expected1 = Arrays.asList(0, 1, 4);
        Assertions.assertEquals(expected1, solution.peopleIndexes(input1));

        List<List<String>> input2 = Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("leetcode", "amazon"),
                Arrays.asList("facebook", "google")
        );
        List<Integer> expected2 = Arrays.asList(0, 1);
        Assertions.assertEquals(expected2, solution.peopleIndexes(input2));

        List<List<String>> input3 = Arrays.asList(
                Arrays.asList("leetcode"),
                Arrays.asList("google"),
                Arrays.asList("facebook"),
                Arrays.asList("amazon")
        );
        List<Integer> expected3 = Arrays.asList(0, 1, 2, 3);
        Assertions.assertEquals(expected3, solution.peopleIndexes(input3));
    }

    @Test
    public void testEdgeCases() {
        Solution6 solution = new Solution6();

        List<List<String>> input4 = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"),
                Arrays.asList("c")
        );
        List<Integer> expected4 = Arrays.asList(0, 1, 2);
        Assertions.assertEquals(expected4, solution.peopleIndexes(input4));

        List<List<String>> input5 = Arrays.asList(
                Arrays.asList("abc"),
                Arrays.asList("abc", "def"),
                Arrays.asList("abc", "def", "ghi")
        );
        List<Integer> expected5 = Arrays.asList(0);
        Assertions.assertEquals(expected5, solution.peopleIndexes(input5));

        List<List<String>> input6 = Arrays.asList(
                Arrays.asList("apple"),
                Arrays.asList("apple", "banana", "cherry"),
                Arrays.asList("banana"),
                Arrays.asList("banana", "cherry", "date")
        );
        List<Integer> expected6 = Arrays.asList(0);
        Assertions.assertEquals(expected6, solution.peopleIndexes(input6));
    }
}