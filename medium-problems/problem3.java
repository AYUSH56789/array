import java.util.HashMap;
import java.util.Iterator;

public class problem3 {
    // Brute Force approach: time complexity O(N^2) sapce complexity O(1)
    public static void bruteForceSolution(int arr[]){
        int max=-1;
        int majorityElement=0;
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>max){
                max=count;
                majorityElement=arr[i];
            }
        }
        System.out.println(majorityElement);
    }
    // better approach: time complexity O(2N) with space complexity O(N)
    public static void betterSolution(int arr[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int max=-1;
        int majorityElement=0;
        for (Integer key : map.keySet()) {
            if(map.get(key)>max){
                max=map.get(key);
                majorityElement=key;
            }
        }
        System.out.println(majorityElement);
    }

     // optimal approach: time complexity O(N) with space complexity O(1) : Boyer moore's voting algorithm
    public static void optimalSolution(int arr[]){
           int element=0;
           int count=0;
           for (int i = 0; i < arr.length; i++) {
                if(count==0){
                    element=arr[i];
                    count++;
                }
                else if(element==arr[i]){
                    count++;
                }else {
                    count--;
                }
           }
           System.out.println(element);
    }
    public static void main(String[] args) {
        int arr[]={2,2,1,1,1,2,2};
        // int arr[]={6,5,5};
        bruteForceSolution(arr);
        betterSolution(arr);
        optimalSolution(arr);
    }
}
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 

Follow-up: Could you solve the problem in linear time and in O(1) space?
*/
