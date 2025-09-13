import java.util.*;

public class Question3_MinDistanceBetween {

    /**
     * Finds the distance between the two closest minimum values in the array.
     */
    public static int minDistance(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int lastIndex = -1;
        int minDist = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                if (lastIndex != -1) minDist = Math.min(minDist, i - lastIndex);
                lastIndex = i;
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2};
        System.out.println("Min distance: " + minDistance(arr)); // Expected: 3
    }
}
