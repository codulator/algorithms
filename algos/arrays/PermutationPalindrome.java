package algos.arrays;

import java.util.HashMap;

/**
 * ## Given a string, write a function to check if it is a permutation of a palindrome.
 * ## e.g.
 * ## input: "Tact Coa"
 * ## output: "Taco cat"
 *
 * Solution: if length is even every character occurs twice
 *  if length is odd one character occurs twice rest appear once
 *
 *  https://leetcode.com/articles/palindrome-permutation/
 */
public class PermutationPalindrome {
    public boolean isPermutationPalindrom(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                continue;
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        for (char key : map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        PermutationPalindrome palindrome = new PermutationPalindrome();
        boolean flag = palindrome.isPermutationPalindrom("Tact Coa".toLowerCase());
        System.out.println("Permuation Palindrome: " + flag);
    }
}
