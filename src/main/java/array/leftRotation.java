package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leftRotation {
    public static void main(String args[]) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int move = 4;

        List<Integer> output = rotate(input,move);
//        for (int x: output) {
//            System.out.println(x);
//        }
    }


    private static List<Integer> rotate(List<Integer> input, int move) {
        // Since we are just rotating it will be same length
            for(int i = input.size(); i > 0; i--) {
                int newIndex;
                if(i - move >= 0) {
                    newIndex = i - move;
                    System.out.println(newIndex);
                } else {
                    newIndex = input.size() - i;
                    System.out.println(newIndex);
                }

            }
        return input;
    }
}
