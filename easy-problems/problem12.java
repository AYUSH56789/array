import java.util.Arrays;

public class problem12 {
    // brute force approach: time complexity O(N) with space complexity O(N)
    public static void bruteForceSolution(int arr[]){
        // pending...
    }
    // optimal approach: time complexity O(N) with space complexity O(1)
    public static void optimalSolution(int arr[]){
        int xor=0;
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
        }
        System.out.println(xor);
    }
    public static void main(String[] args) {
        int arr[]={4,1,2,1,2};
        bruteForceSolution(arr);
        optimalSolution(arr);
    }
}

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1

Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
*/
