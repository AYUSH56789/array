public class problem11 {
    // optimal approach: time complexity O(N) with space complexity O(1)
    public static int optimalSolution(int arr[]){
        // step1: create two pointer counter and max
        int counter=0 , max=0;
        // step2: iterate on the array and check if arr[i]==1 than counter++ else counter->0 and if counter>max tham max->counter
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                counter++;
            }
            else{
                counter=0;
            }
            if (counter>max) {
                max=counter;
            }
        }
        System.out.println(max);
        // step3: return max
        return max;
    }
    public static void main(String[] args) {
        int arr[]={1,0,1,1,0,1};
        optimalSolution(arr);
    }
}


/*
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
*/
