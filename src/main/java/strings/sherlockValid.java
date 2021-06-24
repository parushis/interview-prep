package strings;


import java.util.HashMap;
import java.util.Map;

public class sherlockValid {
    public static void main(String args[]) {
//        String input = "abcdefghhgfedecba";
//        String expected = "YES";
//        System.out.println("Output: " + sherlockValid(input) + " Expected: " + expected);
//
//        String input2 = "aabbccddeefghi";
//        String expected2 = "NO";
//        System.out.println("Output: " + sherlockValid(input2) + " Expected: " + expected2);
//
//        String input3 = "aabbcd";
//        String expected3 = "NO";
//        System.out.println("Output: " + sherlockValid(input3) + " Expected: " + expected3);

        String input4 = "dabcd";
        String expected4 = "YES";
        System.out.println("Output: " + sherlockValid(input4) + " Expected: " + expected4);

    }

    private static String sherlockValid(String s) {
        int[] alphabet = preProcess(s);

        // Step 3: Use minimum and maximum values to determine if valid
        if(offByOne(alphabet)) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

    /**
     * Preprocesses the string into counts for each letter seen in a string
     * @param s
     * @return
     */
    private static int[] preProcess(String s) {
        // Step 1: create array with 26 characters
        int[] alphabet = new int[32];

        // Step 2: iterate through string and count how many times you see a character,
        // set min and max
        for(int i = 0; i < s.length(); i++) {
            int index = s.toUpperCase().charAt(i) - 'A';
            alphabet[index] += 1;
        }
        return alphabet;
    }

    /**
     * Private helepr method that will take in the alphabet counts and determine if only one index
     * can be deleted by 1 so that all counts are  the same.
     * @param alphabet
     * @return
     */
    private static boolean offByOne(int[] alphabet) {
        Map<Integer,Integer> filteredInput = new HashMap<>();
        int maxCount = 0;
        int minCount = 0;
        for (int count: alphabet) {
            if(count !=0) {
                // First time we've seen this so frequency is 1.
                int frequency = 1;
                if (filteredInput.containsKey(count)) {
                    int current = filteredInput.get(count);
                    filteredInput.replace(count, current += 1);
                    // Set min and max counts here


                } else {
                    filteredInput.put(count, frequency);
                }
            }

        }
        int numLettersOfMinLength = filteredInput.get(minCount);
        int numLettersOfMaxLength = filteredInput.get(maxCount);

        // If there is only the difference of 1 between the frequency of characters
        // then return true.

        if(numLettersOfMaxLength == 1 || numLettersOfMinLength == 1) {
            if(minCount == 1 && numLettersOfMinLength == 1) {
                return true;
            }
            if( maxCount - minCount == 1 || numLettersOfMaxLength - numLettersOfMinLength == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * If not all numbers are same, there can only be one number who is different
     * ex: {2,2,1} vs. {2,2,1,1} or {3,3,3,1} vs {3,3,1,1}
     * @param uniqueValues
     * @return
     */
    private static boolean removeOnlyOne(Map<Integer,Integer> uniqueValues)     {

        // If there are more than 2 unique values in key set, it'll take more than 1 delete.
        // Of the two if the difference between values > 1 then false
        if(uniqueValues.keySet().size() > 3) {
            return false;
        } else {
            // Of the two one of the values needs to be one.
            int maxCount = 0;
            int minCount = 0;
            for (Map.Entry<Integer,Integer> entry: uniqueValues.entrySet()) {
                if(entry.getKey() > maxCount) {
                    minCount = maxCount;
                    maxCount = entry.getKey();
                }
            }
            int numLettersOfMinLength = uniqueValues.get(minCount);
            int numLettersOfMaxLength = uniqueValues.get(maxCount);

            // If there is only the difference of 1 between the frequency of characters
            // then return true.

            if(numLettersOfMaxLength == 1 || numLettersOfMinLength == 1) {
                if(minCount == 1 && numLettersOfMinLength == 1) {
                    return true;
                }
                if( maxCount - minCount == 1 || numLettersOfMaxLength - numLettersOfMinLength == 1) {
                    return true;
                }
            }
        }
        return false;

    }

//    private static String sherlockValidString(String input) {
//        // Step 1: create map
//        Map<Integer,Integer> filteredInput = filterInput(input);
//
//        // Step 2: determine valid if each frequency is the same, or each frequency is the same except 1 frequency is
//        // plus 1.
////
////        // OKAY: {2,2,1} {1,1,1} {2,2,2} NOT OKAY: {2,2,1,1}
//
//        if(removeOnlyOne(filteredInput)){
//            return "YES";
//        }
//        else {
//            return "NO";
//        }
//
//    }
//
//    /**
//     * This helper method will return a map with letter as key, and frequency as int.
//     * @param input
//     * @return
//     */
//    private static Map<Integer, Integer> filterInput(String input) {
//        Map<Integer,Integer> filteredInput = new HashMap<Integer, Integer>();
//
//        // create string array
//        String[] letters = input.split("");
//
//        // Iterate through and set counter & add to map
//        for (int i = 0; i < letters.length; i ++) {
//            int count = 1;
//
//            for (int j = i + 1; j < letters.length; j++) {
//                if (letters[i].equals(letters[j])) {
//                    count++;
//                }
//            }
//            // First time we've seen this so frequency is 1.
//            int frequency = 1;
//            if (filteredInput.containsKey(count)) {
//                int current = filteredInput.get(count);
//                filteredInput.replace(count, current += 1);
//            } else {
//                filteredInput.put(count, frequency);
//            }
//
//        }
//
//        return filteredInput;
//
//    }


}
