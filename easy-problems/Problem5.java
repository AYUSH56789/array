import java.util.ArrayList;

public class Problem5 {
    // brute force solution: time complexity O(N) with space complexity : O(N)
    public static void bruteForceSolution(int arr[], int k) {
        // step1: create array list
        ArrayList<Integer> temp = new ArrayList<>();
        // step3: add element in the list from the array from [arr.length-k to arr.length-1]
        for (int i = arr.length - k; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        // step3: now shift array element toward right by three place
        for (int i = arr.length - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        // step4: after shifting, now assign arraylist item to the original array from [0 to arr.length - k - 1] 
        for (int i = 0; i < arr.length - k - 1; i++) {
            arr[i] = temp.get(i);
        }
    }

    // optimal solution: time complexity O(N) with space complexity : O(1)
    public static void optimalSolution(int arr[], int k) {
        // step1: modify k for handling k if greater than array.length and k is same for less than arr.length
        k = k % arr.length;
        // step2: reverse first half
        reverse(arr, 0, arr.length - k - 1);
        // step3: reverse rest half
        reverse(arr, arr.length - k, arr.length - 1);
        // step4: reverse full array
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        bruteForceSolution(arr, k);
        optimalSolution(arr,k);
    }
}

/*
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 * 
 */
