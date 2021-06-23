package array;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dsArray  {
    public static void main(String args[]) {
        List<List<Integer>> input2 = new ArrayList<>();
        List<Integer> one = new ArrayList<>(Arrays.asList(1,1,1,0,0,0));
        List<Integer> two = new ArrayList<>(Arrays.asList(0,1,0,0,0,0));
        List<Integer> three = new ArrayList<>(Arrays.asList(1,1,1,0,0,0));
        List<Integer> four = new ArrayList<>(Arrays.asList(0,9,2,-4,-4,0));
        List<Integer> five = new ArrayList<>(Arrays.asList(0,0,0,-2,0,0));
        List<Integer> six = new ArrayList<>(Arrays.asList(0,0,-1,-2,-4,0));


        input2.add(one);
        input2.add(two);
        input2.add(three);
        input2.add(four);
        input2.add(five);
        input2.add(six);

        System.out.println(findMaxHour(input2));
    }

    private static int findMaxHour(List<List<Integer>> input) {
        int maxCount = 0;

        // Step 1: Iterate through input
        for(int i = 0; i < input.size() - 2; i++) {
            for(int j = 0; j < input.size() - 2; j++) {
                // Step 2: Identify hourglass shape
                // Choose a 3x3 square of input
                int topLayer = input.get(i).get(j) + input.get(i).get(j + 1) + input.get(i).get(j + 2);
                int middleLayer = input.get(i + 1).get(j + 1);
                int bottomLayer = input.get(i + 2).get(j) + input.get(i + 2).get(j + 1) + input.get(i + 2).get(j + 2);

                // sum of 3 across top and 3 bottom row, and middle value of middle row
                int sum = topLayer + middleLayer + bottomLayer;

                // Step 3: Update total max int.
                if(sum > maxCount) {
                    maxCount = sum;
                }
            }
        }

        // Step 4: return sum.
        return maxCount;
    }

}
