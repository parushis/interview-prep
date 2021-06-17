package strings_arrays;

import java.util.List;

public class extractContent {
    public static void main(String args[]) {
        String input = "<h1>Nayeem loves counseling</h1>";
        String input2 = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        String input3 = "<Amee>safat codes like a ninja</amee>";
        String input4 = "<SA premium>Imtiaz has a secret crush</SA premium>";

//        System.out.println(stripHtml(input));
//        System.out.println(stripHtml(input2));
//        System.out.println(stripHtml(input3));
//        System.out.println(stripHtml(input4));
    }

    /**
     * In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag
     * like <tag>contents</tag>. Note that the corresponding end tag starts with a /.
     *
     * Given a string of text in a tag-based language, parse this text and retrieve the contents
     * enclosed within sequences of well-organized tags meeting the following criterion:
     *
     * The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid,
     * because the text starts with an h1 tag and ends with a non-matching h2 tag.
     *
     * Tags can be nested, but content between nested tags is considered not valid.
     * For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.
     *
     * Tags can consist of any printable characters.
     * //TODO: Finish writing this function
     * @param input
     */
    private static String stripHtml(String input) {
        String sentence = "";
        try {
            if (!(input.startsWith("<") || input.endsWith(">"))) {
                return input;
            } else {
                         String[] split2 = input.split("<\\D\\d>|</\\D\\d>");
                for (String token : split2) {
                    sentence += token;
                }
                return stripHtml(sentence);
            }
        } catch (Exception e) {
            return "None";
        }
    }
}
