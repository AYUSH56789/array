import java.util.Arrays;
import java.util.HashMap;

public class problem1 {
    // brute force approach: time complexity O(N^2) with space complexity O(1);
    public static int[] bruteForceSolution(int nums[],int target){
        int ans[]=new int[2];
        for (int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    // for type-1: return "true"
                    // for type-2: return following
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
        return ans;
    }

    // better approach: time complexity O(N) with space complexity O(N);
    // for type2: it is optimal solution
    public static int[] betterSolution(int nums[],int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans[]=new int [2];
        for (int i = 0; i < nums.length; i++) {
            int more=target-nums[i];
            if(map.containsKey(more)){
                // for type-1: return "true";
                // for type-2: return following
                ans[0]=map.get(more);
                ans[1]=i;
                break;
            }else{
                map.put(nums[i], i);
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
        return ans;
    }
    // for type1: it is the optimal solution having time complexity O(N) with space complexity O(1)
    public static boolean optimalSolution(int nums[],int target){
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        int s=0;
        while(l<r){
            s=nums[l]+nums[r];
            if(s<target){
                l++;
            }
            else if(s>target){
                r--;
            }
            else{
                System.out.println(true);
                return true;
            }
        }
        System.out.println(false);
        return false;

    }
    public static void main(String[] args) {
        int arr[]={2,7,11,15};
        int target=9;
        bruteForceSolution(arr,target);
        betterSolution(arr,target);
        optimalSolution(arr,target);
    }
}
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

->> this problem have two type :
type1: in this target is exist or not.
type2: in this we need to returnc both index that's sum is equal to target.
*/
