package strings_arrays;

import java.util.regex.PatternSyntaxException;

public class regexProblems {

    public static void main (String args[]) {
        System.out.println("---- Problem # 1 ----");
        String input = "He is a very very good boy, isn't he?";
        splitIntoTokens(input);

        System.out.println("---- Problem # 2 ----");
        String parse1 = "([A-Z])(.+)";
        String parse2 = "[AZ[a-z](a-z)";
        String parse3 = "batcatpat(nat";

        validRegex(parse1);
        validRegex(parse2);
        validRegex(parse3);

        System.out.println("---- Problem # 3 ----");
        String valid1 = "000.12.12.034";
        String valid2 = "121.234.12.12";
        String valid3 = "23.45.12.56";
        String invalid1 = "00.12.123.123123.123";
        String invalid2 = "122.23";
        String invalid3 = "Hello.IP";
        System.out.println(validIPRegex(valid1));
        System.out.println(validIPRegex(valid2));
        System.out.println(validIPRegex(valid3));
        System.out.println(validIPRegex(invalid1));
        System.out.println(validIPRegex(invalid2));
        System.out.println(validIPRegex(invalid3));
    }

    /**
     * Given a string, , matching the regular expression [A-Za-z !,?._'@]+,
     * split the string into tokens. We define a token to be one or more
     * consecutive English alphabetic letters. Then, print the number of tokens,
     * followed by each token on a new line.
     * @param input
     */
    private static void splitIntoTokens(String input) {
        String[] split = input.split("[ !,?._'@]");
        int total = split.length;

        for (String token: split) {
            if(token.isEmpty()) {
                total--;
            }
        }

        System.out.println(total);
        for (String token: split) {
            if(!token.isEmpty()) {
                System.out.println(token);
            }
        }
    }

    /**
     * For each test case, print Valid if the syntax of the given pattern is correct.
     * Otherwise, print Invalid. Do not print the quotes.
     * @param pattern
     */
    private static void validRegex(String pattern) {
      try {
          String[] split = pattern.split(pattern);
          System.out.println("Valid");
      } catch (PatternSyntaxException e) {
          System.out.println("Invalid");
      }
    }


    /**
     *  You need to write a regular expression and assign it to the pattern such that it can be used to validate
     *  an IP address. Use the following definition of an IP address:
     *
     *  IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
     *  Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
     * @param pattern
     */
    private static boolean validIPRegex(String pattern) {
        String[] split = pattern.split("\\.");
        if (split.length != 4) {
            return false;
        }
        boolean valid = false;
        for (String token : split) {
            if(Integer.valueOf(token) < 0 && Integer.valueOf(token) > 255 || token.length() > 3) {
                valid =false;
            } else {
                valid = true;
            }
        }
        return valid;
    }

}
