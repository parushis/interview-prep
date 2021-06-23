package strings;


import java.util.ArrayList;
import java.util.List;

public class checkPalindrome {

    public static void main (String args[]) {
        System.out.println("---- Problem # 1 ----");
        // Input
        String input = "madam";

        if(isPalindrome(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println("---- Problem # 2 ----");
       // String inputPalindromePermutation = "Tact Coa";
       // System.out.println(isPalindromePermutation(inputPalindromePermutation));
    }

    /**
     * Given a string , print Yes if it is a palindrome, print No otherwise.
     * Edge case: string can be multiple words.
     * @param input
     * @return
     */
    private static boolean isPalindrome(String input) {
        boolean isPalindrome = false;
        String[] letters = input.split("");
        // Check if corresponding letters are the same
        for(int i = 0; i < letters.length; i ++) {
            for(int j = letters.length -1 ; j >= 0  ; j--) {
                if(letters[i].equals(letters[j])) {
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                }
            }
        }
        return isPalindrome;
    }

    /**
     * Given a string write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards,
     * a permutation is a rearrangement of letters.
     */
    private static boolean isPalindromePermutation(String input) {
        boolean isPP = false;
        // Step 1: If phrase split into words
        String[] words = input.split(" ");

        // Step 2: for each word determine permutations
        for (String word: words) {
           isPP = findPermutations(word);
        }
        // Step 4: return true if any permutations are palindromes
        return isPP;
    }

    // TODO: Finish writing this function
    private static boolean findPermutations(String word) {
        // Step 3: create permutations
        List<String> permutations = new ArrayList<>();
        for ( int i = 0; i < word.length(); i ++) {
            for( int j = 0; i < word.length() - 1; j++) {
                char temp = word.charAt(i);
                String temp1 = word.replace(word.charAt(i),word.charAt(j));
                permutations.add(temp1.replace(word.charAt(j),temp));
            }
        }

        // Step 3.1: for each permutation determine if palindrome

        return false;
    }
}
