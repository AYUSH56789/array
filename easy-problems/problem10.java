public class problem10 {


    // brute force approach : time complexity O(N^2) with space complexity : O(1)
    public static int bruteForceSolution(int arr[]){
        int result=-1;
        // step1: iterate i from 0 to N and for each i apply linear search if match found than assign isFound->true and break; after that loop if isFound->false than assign result->i and break from outer loop;
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
        // step2: return result
        return result;
    }


    //better approach : time complexity O(2N) with space complexity : O(N)
    public static int betterSolution(int arr[]){
        int result=-1;
        // step1: create temp array of size arr.length+1
        int temp[]=new int[arr.length+1];
        // step2: iterate from 0 to arr.length-1 and assign temp[arr[i]]->1
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]=1;
        }
        // step3: now iterate on the temp array from the 0 to temp.length and check if temp[i]==0 than assign result->i
        for(int i=0;i<temp.length;i++){
            if(temp[i]==0){
                result=i;
            }
        }
        // step4: return result;
        return result;
    }


    //optimal approach1 : time complexity O(N) with space complexity : O(1)
    public static int optimalSolution1(int arr[]){
        // step1: create n->arr.length and s->0 variable 
        int n=arr.length;
        int s=0;
        // step2: iterate arr from 0 to arr.length-1 and find sum of all
        for (int i = 0; i < arr.length; i++) {
            s+=arr[i];
        }
        // step3: calculate total sum for arr.length
        int ts=(n*(n+1))/2;
        System.out.println(ts-s);
        // step4: ts-s is the result that is our missing value
        return ts-s;
    }


    //optimal approach2 : time complexity O(N) with space complexity : O(1)
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
