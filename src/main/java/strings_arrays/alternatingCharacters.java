package strings_arrays;

public class alternatingCharacters {

    public static void main(String args[]) {
        String input = "AABAAB";

        String input1 = "AAAA";
        String input2 = "BBBBB";
        String input3 = "ABABABAB";
        String input4 = "BABABA";
        String input5 = "AAABBB";

        System.out.println(minimumAjoiningDelete(input));
        System.out.println("----");

        System.out.println(minimumAjoiningDelete(input1));

        System.out.println(minimumAjoiningDelete(input2));

        System.out.println(minimumAjoiningDelete(input3));

        System.out.println(minimumAjoiningDelete(input4));

        System.out.println(minimumAjoiningDelete(input5));

    }

    private static int minimumAjoiningDelete(String input) {
        // Step 1: create input array
        String[] letters = input.split("");

        int deleteCounter = 0;
        // Step 2: calculate deletes required by iterating array
        for(int i = 0; i < letters.length - 1; i ++) {
            // if letter is same next to it increase delete counter
            if(letters[i].equals(letters[i+1])){
                deleteCounter++;
            }
        }
        return deleteCounter;
    }
}
