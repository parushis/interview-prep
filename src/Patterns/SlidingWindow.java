package Patterns;

// Perform a required operation on a specific window size.
public class SlidingWindow {

    // Implement moving forward by one on a window size.
    public int maximumSubArray(int [] input, int windowSize) {
        // The sum of a subarray may be lower than what we've seen, so only keep
        // highest sum found.
        int ans = 0;

        // First loop will act as our window
        for (int i= 0; i < input.length; i++) {
            int sum = 0;
            // Second loop will be our calculation of that window
            for(int j =i; j < windowSize; j++) {
                sum += input[j];
            }
            // Check if greater than before and return new highest.
            if (sum > ans) {
                ans = sum;
            }

        }

        return ans;
    }
}
