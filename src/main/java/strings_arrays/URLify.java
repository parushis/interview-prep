package strings_arrays;

public class URLify {

    public static void main (String args[]) {
        String input = "Mr John Smith    ";
        int trueLength = 13;

        System.out.println(URLify(input,trueLength));
    }

    private static String URLify(String input, int trueLength) {
        String urlify = "";
        // Remove empty space from end of string
        String trimmed = input.trim();
        // replace all spaces with '%20' use character array
        for(int i = 0; i < input.length(); i++) {
           if (Character.isWhitespace(input.charAt(i))) {
               urlify = trimmed.replace(" ", "%20");
           }
        }
        return urlify;
    }


}
