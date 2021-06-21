package strings_arrays;


import java.util.HashMap;
import java.util.Map;

public class sherlockValid {
    public static void main(String args[]) {
        String input = "abcdefghhgfedecba";
        String expected = "YES";

        System.out.println(sherlockValid(input));
        System.out.println("--- Expected --- :" + expected);

        String input2 = "aabbccddeefghi";
        String expected2 = "NO";

        System.out.println(sherlockValid(input2));
        System.out.println("--- Expected --- :" + expected2);

        String input3 = "aabbcd";
        String expected3 = "NO";

        System.out.println(sherlockValid(input3));
        System.out.println("--- Expected --- :" + expected3);


    }

    private static String sherlockValid(String input) {
        // Step 1: create map
        Map<Integer,Integer> filteredInput = filterInput(input);

        // Step 2: determine valid if each frequency is the same, or each frequency is the same except 1 frequency is
        // plus 1.
//
//        // OKAY: {2,2,1} {1,1,1} {2,2,2} NOT OKAY: {2,2,1,1}

        if(removeOnlyOne(filteredInput)){
            return "YES";
        }
        else {
            return "NO";
        }

    }

    /**
     * If not all numbers are same, there can only be one number who is different
     * ex: {2,2,1} vs. {2,2,1,1} or {3,3,3,1} vs {3,3,1,1}
     * @param uniqueValues
     * @return
     */
    private static boolean removeOnlyOne(Map<Integer,Integer> uniqueValues) {

        // If there are more than 2 unique values in key set, it'll take more than 1 delete.
        // Of the two if the difference between values > 1 then false
        if(uniqueValues.keySet().size() > 2) {
            return false;
        } else {
            // Of the two one of the values needs to be one.
            int maxKey = 0;
            int minKey = 0;
            for (Map.Entry<Integer,Integer> entry: uniqueValues.entrySet()) {
                if(entry.getKey() > maxKey) {
                    minKey = maxKey;
                    maxKey = entry.getKey();
                }
            }
            int minValue = uniqueValues.get(minKey);
            int maxValue = uniqueValues.get(maxKey);

            // If there is only the difference of 1 between the frequency of characters
            // then return true.
            if(minValue == 1) {
                return true;
            }


        }
        return false;

    }

    /**
     * This helper method will return a map with letter as key, and frequency as int.
     * @param input
     * @return
     */
    private static Map<Integer, Integer> filterInput(String input) {
        Map<Integer,Integer> filteredInput = new HashMap<Integer, Integer>();

        // create string array
        String[] letters = input.split("");

        // Iterate through and set counter & add to map
        for (int i = 0; i < letters.length; i ++) {
            int count = 1;

            if(!letters[i].equals("")) {
                for (int j = i + 1; j < letters.length; j++) {
                    if (letters[i].equals(letters[j])) {
                        letters[i] = "";
                       // letters[j] = "";
                        count++;
                    }
                }
                // First time we've seen this so frequency is 1.
                int frequency = 1;
                if (filteredInput.containsKey(count)) {
                    int current = filteredInput.get(count);
                    filteredInput.replace(count, current += 1);
                } else {
                    filteredInput.put(count, frequency);
                }
            }

        }

        return filteredInput;

    }


}
