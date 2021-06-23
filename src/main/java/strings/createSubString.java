package strings;


public class createSubString {

    // Test with first example given
    public static void main(String args[]) {
        // #1 Input for building substring problem
        String input = "Helloworld";
        int start = 3;
        int end = 7;

        // #1 Building substring problem output
        String result = buildSubString(input, start, end);
        System.out.println(result);
    }

    /**

     */
    /** # 1
     * This method takes in the string, input int, and output int and returns the
     * substring inclusive of those indices.
     *      * Given a string, , and two indices,  and , print a substring consisting of all characters in the inclusive range from  to.
     *      * You'll find the String class' substring method helpful in completing this challenge.
     *      *
     *      * Input Format
     *      *
     *      * The first line contains a single string denoting .
     *      * The second line contains two space-separated integers denoting the respective values of  and .
     *      *
     *      * Constraints
     *      *
     *      * String  consists of English alphabetic letters (i.e., ) only.
     *      * Output Format
     *      *
     *      * Print the substring in the inclusive range from  to .
     * @param input
     * @param start
     * @param end
     */
    private static String buildSubString(String input, int start, int end) {
        String result = "";
        // Step 1: Build array from string
        String[] word = input.split("");

        // Step 2: Iterate array given start and end index given
        for (int i= start; i< end; i++) {
            // Step 2.1: Build substring
            result += word[i];
        }

        // Step 3: Return substring
        return result;
    }


}
