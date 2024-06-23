public class problem12 {
    // brute force approach :time complexity O(N^3) approx with space compexity O(1)
    public static void bruteForceSolution(int nums[],int k){
        int s=0,count=0;
        for(int i=0;i<nums.length;i++){
            for (int j = i; j < nums.length; j++) {
                s=0;
                for (int t = i; t <= j; t++) {
                    s+=nums[t];
                }
                if(s==k){
                    count++;
                }
            }
        }

        // print count
        System.out.println(count);
    }

    // better approach: with time complexity O(N^2) with time complexity O(1)
    public static void betterSolution(int nums[],int k){
        int s=0,count=0;
        for(int i=0;i<nums.length;i++){
            s=0;
            for (int j = i; j < nums.length; j++) {
                s+=nums[j];
                if(s==k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    public static void optimalSolution(int nums[],int k){
        // pending
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        int k = 3;
        bruteForceSolution(nums,k);
        betterSolution(nums,k);
        optimalSolution(nums,k);
    }
}

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/