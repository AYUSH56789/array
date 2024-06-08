import java.util.ArrayList;

public class Problem7 {
    // brute force approach: time complexity O(N) with in O(N) 
    public static void bruteForceSolution(int arr[]){
        // step1: create temp array list
        ArrayList<Integer> temp=new ArrayList<>();
        // step2: add non-zero value to temp array
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
        }
        // step3: again , add temp array value to original array
        for (int i = 0; i < temp.size(); i++) {
            arr[i]=temp.get(i);
        }
        // step4: assign zero to rest
        for (int i = arr.length-temp.size()+1; i < arr.length; i++) {
            arr[i]=0;
        }
    }


    // optimal solution: time complexity O(N) with in O(1) 
    public static void optimalSolution(int arr[]){
        // step1: create a pointer "j" and assign to 0
        int j=0;
        // step2: iterate from index 0 to arr.length-1 on the and check if arr[i]!=0 than swap arr[i] with arr[j] and j++ else i++
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                // swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                // j++
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={0,1,0,3,12};
        bruteForceSolution(arr);
        optimalSolution(arr);
    }
}

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 
*/
