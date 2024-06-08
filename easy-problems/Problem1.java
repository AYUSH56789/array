import java.util.Arrays;

public class Problem1{

    
    // Brute force approach: O(NlogN)
    public static int bruteForceSolution(int arr[], int n){
        // step1: sort an array
        Arrays.sort(arr);
        // step2: after sorting last element of an array is the largest number from the array
        int max=arr[n-1];
        // step3: return max number
        return max;
    }


    // Optimal approach: O(NlogN)
    public static int optimalSolution(int arr[], int n){
        // step1: assume array first element from the array is the largest element
        int max=arr[0];
        // step2: iterate from index 1 to n-1 and update max if any element from the array is greater than max
        for (int i = 1; i <=n-1; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int arr[]={1, 8, 7, 56, 90};
        bruteForceSolution(arr,arr.length);
        optimalSolution(arr,arr.length);
    }
}
/*
Problem Statement: Given an array A[] of size n. The task is to find the largest element in it.
 
Example 1:

Input:
n = 5
A[] = {1, 8, 7, 56, 90}
Output:
90
Explanation:
The largest element of given array is 90.
 */