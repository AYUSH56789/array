import java.util.Arrays;
import java.util.HashSet;

public class problem8 {
    // bruteForce approach: time complexity O(NlogN + N) with space complexity O(1)
    public static void bruteForceSolution(int arr[]){
        Arrays.sort(arr);
        int max = 0;
        int start=0;
        int end=0;
        for(int i=0;i<arr.length-1;i++){
            if( arr[i+1]-arr[i]==1 ){
                end=i+1;
                if((end-start)+1>max){
                    max=(end-start)+1;
                } 
            }
            else{
                end=i;
                start=i+1;
            }
        }
        if(start==0 && end==0){
            max=1;
        }
        System.out.println(max);
    }
    public static void optimalSolution(int arr[]){
        HashSet<Integer> set=new HashSet<>();
        int length=1;
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int element:set) {
            if(!set.contains(element-1)){
            int item=element;
            int count=1;
            while (set.contains(item+1)) {
                item=item+1;
                count=count+1;
            }
            length=Math.max(length,count);
            }
        }
        System.out.println(length);
    }
    public static void main(String[] args) {
        // int arr[]={100,4,200,1,3,2};
        int arr[]={0,3,7,2,5,8,4,6,0,1};
        bruteForceSolution(arr);
        optimalSolution(arr);
    }
}
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
*/
