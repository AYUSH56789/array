public class problem4 {

    // bruteForce approach: time complexity O(N^3) with space complexity O(1)
    public static void bruteForceSolution(int arr[]){
        int max=-1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                sum=0;
                for(int k=i;k<=j;k++){
                    sum=sum+arr[k];
                }
                if(sum>max){
                        max=sum;
                }
            }
        }
        System.out.println(max);
    }

    // better approach: time complexity O(N^2) with space complexity O(1)
    public static void betterSolution(int arr[]){
        int max=-1;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum=sum+arr[j];
                if(sum>max){
                        max=sum;
                }
            }
        }
        System.out.println(max);
    }

    // optimal approach: time complexity O(N) with space complexity O(1) : Kadanes algorithm
    public static void optimalSolution(int arr[]){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int arr[]={5,4,-1,7,8};
        bruteForceSolution(arr);
        betterSolution(arr);
        optimalSolution(arr);
    }
}

/*
Given an integer array nums, find the subarray
with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
