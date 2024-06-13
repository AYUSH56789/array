import java.util.Arrays;

public class problem2 {
    // bruteForce approach: time complexity O(NlogN) space complexity O(N)
    public static void bruteForceSolution(int arr[]){
        // step1: just sort an array using built-in function
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    // better approach: time complexity O(2N)~=O(N) with space complexity O(1)
    public static void betterSolution(int arr[]){
        // step1: cretae variable for counting 0,1,2 in array
        int count0=0,count1=0,count2=0;
        // step1: iterate on the array to count 0,1,2 item in the array
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                count0++;
            }else if(arr[i]==1){
                count1++;
            }else{
                count2++;
            }
        }
        // step3: reassign "0" in the given array from the 0 to count0 
        for (int i = 0; i < count0; i++) {
            arr[i]=0;
        }
        // step4: reassign "1" in the given array from the count0 to count1
        for (int i = count0; i < count1; i++) {
            arr[i]=1;
        }
        // step5: reassign "2" in the given array from the count1 to count2
        for (int i = count1; i < count2; i++) {
            arr[i]=2;
        }
    }


    // optimal approach: time complexity O(N) with space complexity O(1)  -> Dutch national falg algorithm
    public static void optimalSolution(int arr[]){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while (mid<=high) {
            if(arr[mid]==0){
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low=low+1;
                mid=mid+1;
            }
            else if(arr[mid]==2){
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high=high-1;
            }
            else{
                mid=mid+1;
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {
        int arr[]={2,0,1};
        // bruteForceSolution(arr);
        // betterSolution(arr);
        optimalSolution(arr);
    }
}

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/
