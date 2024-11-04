package org.example;

import java.util.HashSet;
import java.util.Set;

/**
 * UniqueNDigitNumbersGenerator
 *
 * 该工具类用于生成由给定整数数组中的元素组成的所有可能的唯一 n 位数集合。
 *
 * <p> 输入一个整数数组（其中每个数字必须介于 1 到 9 之间）和一个整数 n，生成由数组中的元素组成的所有 n 位唯一数。
 * 数组中的每个数字在生成的 n 位数中只能使用一次，结果以无重复的集合形式返回。
 *
 * <p> 使用示例：
 * <pre>{@code
 * int[] nums = {1, 2, 3};
 * int n = 2;
 * Set<Integer> result = UniqueNDigitNumbersGenerator.generateNDigitNumbers(nums, n);
 * System.out.println(result); // [12, 13, 21, 23, 31, 32]
 * }</pre>
 *
 * <p> 注意事项：
 * <ul>
 *   <li> 数组中的每个数字必须介于 1 到 9 之间，否则会抛出 {@code IllegalArgumentException}。
 *   <li> n 必须大于 0 且小于等于数组长度。
 * </ul>
 *
 * @author Alan Tang
 */

public class UniqueNDigitNumbersGenerator {
    public static Set<Integer> generateNDigitNumbers(int[] nums, int n) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        if (nums == null || nums.length == 0 || n <= 0 || n > nums.length) {
            return uniqueNumbers;
        }

        for (int num : nums) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("All the numbers in the array must be single digits.");
            }
        }

        boolean[] used = new boolean[nums.length];
        generateNDigitNumbers(nums, n, new StringBuilder(), uniqueNumbers, used);
        return uniqueNumbers;
    }

    private static void generateNDigitNumbers(int[] nums, int n, StringBuilder current, Set<Integer> uniqueNumbers, boolean[] used) {
        if (current.length() == n) {
            uniqueNumbers.add(Integer.parseInt(current.toString()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.append(nums[i]);

                generateNDigitNumbers(nums, n, current, uniqueNumbers, used);

                // 回溯，重置状态
                current.deleteCharAt(current.length() - 1);
                used[i] = false;
            }
        }
    }
}
