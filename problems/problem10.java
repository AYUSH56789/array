public class problem10 {


    // brute force approach : time complexity O(N^2) with space complexity : O(1)
    public static int bruteForceSolution(int arr[]){
        int result=-1;
        for(int i=0;i<=arr.length;i++){
            boolean isFound=false;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==i){
                    isFound=true;
                    break;
                }
            }
            if(isFound==false){
                result=i;
                break;
            }
        }
        System.out.println(result);
        return result;
    }


    //optimal approach : time complexity O(2N) with space complexity : O(N)
    public static int betterSolution(int arr[]){
        int result=-1;
        int temp[]=new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]=1;
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]==0){
                result=i;
            }
        }
        System.out.println(result);
        return result;
    }


    //optimal approach : time complexity O(N) with space complexity : O(1)
    public static int optimalSolution1(int arr[]){
        int n=arr.length;
        int s=0;
        for (int i = 0; i < arr.length; i++) {
            s+=arr[i];
        }
        int ts=(n*(n+1))/2;
        System.out.println(ts-s);
        return ts-s;
    }


    //optimal approach : time complexity O(N) with space complexity : O(1)
    public static void optimalSolution2(int arr[]){
        int xor1=0;
        int xor2=0;
        for (int i = 0; i < arr.length; i++) {
            xor1^=arr[i];
            xor2^=(i+1);
        }
        System.out.println(xor2^xor1);
    }
    // note : from optimalSolution1 and optimalSolution2 , optimalSolution2 is better one becuse in 1 by calculating ts for last integer than "n+1" cause 'Number value out of range'  error but in 2 no error got large integer.


    public static void main(String[] args) {
        int arr[]={0,2};
        bruteForceSolution(arr);
        betterSolution(arr);
        optimalSolution1(arr);
        optimalSolution2(arr);
    }
}


/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.
 

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
*/
