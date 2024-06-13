public class problem13 {
    public static void bruteForceSolution(int []arr,int k){
        int sLength=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int l=i;l<=j;l++){
                    sum+=arr[l];
                    System.out.print(sLength+" "+(j-i)+" "+sum);
                    System.out.println();
                } 
                if(sLength<j-i && sum==k){
                    sLength=j-i+1;
                }
            }
        }
        System.out.println(sLength);
    }
    public static void betterSolution(int arr[],int k){
    // pending
    }
    public static void optimalSolution(int arr[],int k){
    // pending
    }
    public static void main(String[] args) {
        int arr[]= {10, 5, 2, 7, 1, 9};
        int k=15;
        bruteForceSolution(arr,k);
        betterSolution(arr,k);
        optimalSolution(arr,k);
    }
}
/*
Given an array containing N integers and an integer K., Your task is to find the length of the longest Sub-Array with the sum of the elements equal to the given value K.

 

Example 1:
 

Input :
A[] = {10, 5, 2, 7, 1, 9}
K = 15
Output : 4
Explanation:
The sub-array is {5, 2, 7, 1}.

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function lenOfLongSubarr() that takes an array (A), sizeOfArray (n),  sum (K)and returns the required length of the longest Sub-Array. The driver code takes care of the printing.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1<=N<=105
-105<=A[i], K<=105
 
*/