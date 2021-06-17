package strings_arrays;

public class compareSubString {
    // Test with first example given
    public static void main(String args[]) {

        // Input for comparing substring
        String k = "welcomeToJava";
        int length = 3;

        // # 2 Comparing substring
        String output = getSmallestAndLargest(k,length);
        System.out.println(output);
    }

    /**
     *
     * Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest
     * and largest substrings of length .
     * @param s
     * @param k
     * @return
     */
    private static String getSmallestAndLargest(String s, int k) {
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        // Step 1: create array from string
        String [] letters = s.split("");
        // Step 2: iterate to build an array of sub-strings of correct length from letters in letters array
        int totalExpected = letters.length - (k - 1);
        String[] subStrings = new String[totalExpected];
        preProcessLexSort(k, letters, subStrings, totalExpected);
        // Step 3: Find first and last string and set smallest and largest
        lexSort(subStrings);

        return subStrings[0] + "\n" + subStrings[subStrings.length - 1];
    }

    private static void preProcessLexSort(int k, String[] letters, String[] subStrings, int totalExpected) {
        for(int i = 0; i < letters.length; i++) {
            String sub = "";
            // go forward by k, so to position i + k only if i + k < letters.length
            int end = i + k;
            if (end <= letters.length) {
                for (int j = i; j < end ; j++) {
                    sub += letters[j];
                }

            }
            if (i < totalExpected) {
                subStrings[i] = sub;
            }
        }
    }

    private static void lexSort(String[] subStrings) {
        for(int i =0; i <subStrings.length; i++) {
            for(int j = i + 1; j < subStrings.length; j++) {
                if(subStrings[i].compareTo(subStrings[j]) > 0) {
                    String temp = subStrings[i];
                    subStrings[i] = subStrings[j];
                    subStrings[j] = temp;
                }
            }
        }
    }
}
