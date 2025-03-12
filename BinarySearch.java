import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter the number of elements in an array: ");
        int size = scnr.nextInt();
        int[] numArray = new int[size];
        System.out.printf("Enter %d elements\n", size);
        for (int i = 0; i < size; i++) {
            numArray[i] = scnr.nextInt(); // asking for user input
        }
        
        Arrays.sort(numArray); // sort numbers in ascending order
        System.out.printf("Sorted array: %s\n", Arrays.toString(numArray)); // print sorted array

        System.out.print("Enter the target number: "); // target number for binary search
        int target = scnr.nextInt();
        scnr.close();

        System.out.println("Searching by Iteration...");
        System.out.printf("%d found at index %d\n", target, byLoop(numArray, target));

        System.out.println("Searching by Recursion...");
        System.out.printf("%d found at index %d\n", target, byRecursion(numArray, target, 0, numArray.length - 1));
    }

    public static int byLoop(int[] numArray, int target) {
        int left = 0; // left pointer
        int right = numArray.length - 1; // right pointer

        while (left <= right) {
            int midpoint = left + (right - left) / 2; // avoid integer overflow

            if (numArray[midpoint] < target) {
                left = midpoint + 1; // search the right half
            } else if (numArray[midpoint] > target) {
                right = midpoint - 1; // search the left half
            } else {
                return midpoint; // target found
            }
        }
        return -1; // target not in numArray
    }

    public static int byRecursion(int[] numArray, int target, int left, int right) {
        if (left > right) {
            return -1; // BASE CASE: target not found
        }

        int midpoint = left + (right - left) / 2; // avoid integer overflow

        if (numArray[midpoint] < target) {
            return byRecursion(numArray, target, midpoint + 1, right); // search the right half
        } else if (numArray[midpoint] > target) {
            return byRecursion(numArray, target, left, midpoint -1); // search the left half
        } else {
            return midpoint; // BASE CASE: target found
        }
    }
}
