package strings;

public class checkPermutation {
    public static void main(String args[]) {
        String testInputOne = "abcdef";
        String testInputTwo = "acbefd";

        System.out.println(isPermutation(testInputOne,testInputTwo));
    }

    /**
     * given two strings write a method to decide if one is a permutation of the other.
     * @param testInputOne
     * @param testInputTwo
     * @return
     */
    protected static boolean isPermutation(String testInputOne, String testInputTwo) {

        // Step 2: Iterate through arrays and find the number of times a letter is used.
         int[] stringOneCounts = countLetters(testInputOne);
         int[] stringTwoCounts = countLetters(testInputTwo);

        // Step 3: Compare number of times a letter is used, if it is same then both strings
        //          are permutations of each other.
        if (stringOneCounts.length != stringTwoCounts.length) {
            return false;
        }
        for(int i = 0; i < stringOneCounts.length; i++) {
            if(!(stringOneCounts[i] == stringTwoCounts[i])){
                return false;
            }
        }
        return true;
    }

    /**
     * This helper method is going to return an array of integers of how many times
     * a letter is seen.
     * @param stringOne
     * @return
     */
    private static int[] countLetters(String stringOne) {
        int[] counts = new int[26]; // assume letters in alphabet

        // iterate through string and update counter in counts array
        for(int i = 0; i < stringOne.length(); i ++){
            int letterIndex = stringOne.toUpperCase().charAt(i) - 'A';
            counts[letterIndex]++;
        }
    return counts;
    }
}
