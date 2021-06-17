package strings_arrays;

public class checkUnique {
    public static void main(String args[]) {
        String testString = "abcdef";
        System.out.println("---- Problem # 1 ----");
        System.out.println(isStringUnique(testString));
        System.out.println("---- Problem # 2 ----");
        System.out.println(isStringUniqueNoExtraDataStructures(testString));
    }

    /**
     * Determine if string has all unique characters  @param testString
     * @return
     */
    private static boolean isStringUnique(String testString) {
        // Step 2: compare with characters next to it and make sure it's not equal
        char[] characters = testString.toCharArray();
        for( int i =0; i < characters.length; i ++) {
            for( int j = i + 1; j <characters.length; j ++) {
                if (characters[i] == (characters[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /** What if no extra data structures allowed?
     * @param testString
     * @return
     */
    private static boolean isStringUniqueNoExtraDataStructures(String testString) {
        // using no data structures means we will have to iterate the string without converting
        // it into an array.
        for(int i = 0; i < testString.length(); i ++) {
            for (int j = i + 1; j < testString.length(); j++) {
                if (testString.charAt(i) == testString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}