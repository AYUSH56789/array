import java.util.Arrays;

public class Problem2 {
    
    
    // Brute force approach: O(NlogN)
    public static int bruteForceSolution(int arr[], int n){
        // step1: sort an array
        Arrays.sort(arr);
        // step2: assume second largest as -1
        int secondLargest=-1;
        // step3: after sorting an array , iterate on it from n-1 to 1 by comparing arr[n-1] is same as arr[n-2] . if same than "continue" iteration .else second larget is arr[n-2]
        for (int i : arr) {
            System.out.print(i+" ");
        }
        for(int i=n-1;i>=1;i--){
            if(arr[i]!=arr[i-1]){
                secondLargest=arr[i-1];
                break;
            }
        }
        System.out.println("\n"+secondLargest);
        return secondLargest;
    }


    // Optimal approach: O(NlogN)
    public static int optimalSolution(int arr[], int n){
        int secondLargest=-1;
        int largest=arr[0];
        for(int i=1;i<=n-1;i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }
            else if(arr[i]>secondLargest && arr[i]<largest){
                secondLargest=arr[i];
            }
        }
        System.out.println(secondLargest);
        return secondLargest;
    }


    public static void main(String[] args) {
        int arr[]={12, 35, 1, 10, 34, 1};
        bruteForceSolution(arr,arr.length);
        optimalSolution(arr,arr.length);
    }
}
/*
 Given an array Arr of size N, print the second largest distinct element from an array. If the second largest element doesn't exist then return -1.

Example 1:

Input: 
N = 6
Arr[] = {12, 35, 1, 10, 34, 1}
Output: 34
Explanation: The largest element of the 
array is 35 and the second largest element
is 34.

Hints:
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ N ≤ 10^5
1 ≤ Arri ≤ 10^5

NOTE: according to the constaints ,the given array have atleast two element. 
 */
