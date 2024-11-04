package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class UniqueNDigitNumbersGeneratorTest {

    @Test
    void testGenerateTwoDigitNumbers() {
        int[] nums = {1, 2, 3};
        int n = 2;
        Set<Integer> result = UniqueNDigitNumbersGenerator.generateNDigitNumbers(nums, n);

        Set<Integer> expected = new HashSet<>(Arrays.asList(12, 13, 21, 23, 31, 32));
        assertEquals(expected, result, "resulting set is incorrect.");
    }

    @Test
    void testGenerateThreeDigitNumbers() {
        int[] nums = {1, 2, 3, 4};
        int n = 3;
        Set<Integer> result = UniqueNDigitNumbersGenerator.generateNDigitNumbers(nums, n);
        assertEquals(24, result.size(), "the size of resulting set is incorrect.");
    }
}