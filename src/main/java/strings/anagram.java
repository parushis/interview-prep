package strings;

import java.util.HashMap;
import java.util.Map;

public class anagram {

    public static void main(String args[]) {
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        System.out.println(minimumDeletions(a,b));
    }

    private static int minimumDeletions(String a, String b) {
        // Create letter/frequency pre-processing for both strings
        Map<String,Integer> letterFrequencyOfa = frequency(a);
        Map<String,Integer> letterFrequencyOfb = frequency(b);

        // Identify common letters/frequency
        Map<String,Integer> common = findCommon(letterFrequencyOfa,letterFrequencyOfb);

        // Calculate # of deletions to achieve set defined in step 2.
        return determineMinimum(common,letterFrequencyOfa,letterFrequencyOfb);
    }

    /**
     * This private helper function will take in a string and return a map of
     * letter as key and frequency as value.
     * @param a
     * @return
     */
    private static Map<String, Integer> frequency(String a) {
        // set up map
        Map<String, Integer> lettersAndFrequency = new HashMap<String, Integer>();
        // convert string a to array for ease of iteration
        String[] letters = a.split("");

        // iterate through letters and count
        for(int i = 0; i < letters.length; i++) {
            // key is the letter at i
            String key = letters[i];
            // Value is the count that will be updated
            int value = 0;

            // If we see the letter again we want to update the counter
            for(int j=0; j< letters.length; j++) {
                if(letters[j].equals(key)) {
                    value++;
                }
            }

            // add to map
            lettersAndFrequency.put(key,value);

        }
        return lettersAndFrequency;
    }


    /**
     * This private helper function will take the maps of letters,frequency and filter
     * to provide the actual common set we are looking for in both strings.
     * @param letterFrequencyOfa
     * @param letterFrequencyOfb
     * @return
     */
    private static Map<String, Integer> findCommon(Map<String, Integer> letterFrequencyOfa, Map<String, Integer> letterFrequencyOfb) {
        // iterate through maps and find common letter/frequency and store in another map
        Map<String,Integer> filteredMap = new HashMap<String, Integer>();

        for (Map.Entry<String,Integer> entry : letterFrequencyOfa.entrySet()) {
            String aKey = entry.getKey();
            int aFrequency = entry.getValue();

            // check if letter in a is a key in b
            if(letterFrequencyOfb.containsKey(aKey)) {
                // letter exists, and frequency is same
                int bFrequency = letterFrequencyOfb.get(aKey);

                // If frequency is different pick the lower frequency
                if(bFrequency == aFrequency || bFrequency > aFrequency ){
                    filteredMap.put(aKey,aFrequency);
                } else if( bFrequency < aFrequency) {
                    filteredMap.put(aKey,bFrequency);
                }
            }
        }

        return filteredMap;
    }


    /**
     * This private helper function will take the common map and parse the strings
     * to determine minimum deletions to get the string to match the common letter/frequency.
     * @param common
     * @param a
     * @param b
     * @return
     */
    private static int determineMinimum(Map<String, Integer> common, Map<String,Integer> a, Map<String,Integer> b) {
        // set up variable to keep track of minimum
        int deletion = 0;

        // iterate through strings and keep track of deletions required to get to letter,frequency
        // declared in common map.

        // string ie. "cde" , common map {"c" -> 1}, deletions required = 2;
        for (Map.Entry<String,Integer> entry: a.entrySet()) {
            String letter = entry.getKey(); // c ,
            int frequency = entry.getValue();// 1 ,

            // if the letter is present in common list
            if(common.containsKey(letter)){
                // if minimum is looking for deletes we want to see
                // difference required to get to common frequency.

                // ie. frequency desired is 1, actual in string is 2. deletion required is 1.
                // can frequency be 2 and desired be 1? no. because common map is already set to look
                // at minimum common values we want to see.
                deletion += frequency - common.get(letter); // 0

            } else {
                // not a common letter and must be deleted
                deletion += frequency;
            }

        }

        // string ie. "abc" , common map {"c" -> 1}, deletions required = 2;
        for (Map.Entry<String,Integer> entry: b.entrySet()) {
            String letter = entry.getKey(); // a ,
            int frequency = entry.getValue();// 1 ,

            // if the letter is present in common list
            if(common.containsKey(letter)){
                // if minimum is looking for deletes we want to see
                // difference required to get to common frequency.

                // ie. frequency desired is 1, actual in string is 2. deletion required is 1.
                // can frequency be 2 and desired be 1? no. because common map is already set to look
                // at minimum common values we want to see.
                deletion += frequency - common.get(letter); // 0

            } else {
                // not a common letter and must be deleted
                deletion += frequency;
            }

        }


        return deletion;
    }




}
