import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


public class problem12 {
    // brute force approach: time complexity O(2N) ~= O(N) with space complexity O(N)
    public static int bruteForceSolution(int arr[]){
        // step1: assume result is -1;
        int result=-1;
        // step2: create hashmap 
        HashMap<Integer,Integer> map=new HashMap<>();
        // step3: iterate on the array and store all element as key and store its frequency as its value
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1 );
        }
        // step4: iterate on the array that get map value by passing key and check if getting value is 1 than result is that key
        for (int i = 0; i < arr.length; i++) {
            if(map.get(arr[i])==1){
                result= arr[i];
            }
        }
        // step5: return result
        return result;
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
