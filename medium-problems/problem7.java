import java.util.ArrayList;

public class problem7 {
    // bruteForce Approach: time complexity O(N^2) with space complexity O(N) 
    public static void bruteForceSolution(int arr[]){
        int n=arr.length;
        ArrayList<Integer> leaders=new ArrayList<>();
        for (int i = n-1; i>=0; i--) {
            boolean isLeader=true;
            for(int j=i;j<n-1;j++){
                if(arr[i]>=arr[j+1]){
                    isLeader=true;
                }
                else{
                    isLeader=false;
                    break;
                }
            }
            if(isLeader){
                leaders.add(0,arr[i]);
            }
        }
    }

    // optimal approach : time complpexity O(N) with space complexity O(N)
    public static void optimalSolution(int arr[]){
        int n=arr.length;
        ArrayList<Integer> leaders=new ArrayList<>();
        int newLeader=-1;
        for(int i=n-1;i>=0;i--){
            if(arr[i]>=newLeader){
                leaders.add(0,arr[i]);
                newLeader=arr[i];
            }
        }
    }
    public static void main(String[] args) {
        // int arr[] = {10,4,2,4,1};
        // int arr[] = {5, 10, 20, 40};
        int arr[] = {16, 17, 4, 3, 5, 2};
        bruteForceSolution(arr);
        optimalSolution(arr);
    }
}

/*
Given an array arr of n positive integers, your task is to find all the leaders in the array. An element of the array is considered a leader if it is greater than all the elements on its right side or if it is equal to the maximum element on its right side. The rightmost element is always a leader.

Examples

Input: n = 6, arr[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.
Input: n = 5, arr[] = {10,4,2,4,1}
Output: 10 4 4 1
Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side
Input: n = 4, arr[] = {5, 10, 20, 40} 
Output: 40
Explanation: When an array is sorted in increasing order, only the rightmost element is leader.
Input: n = 4, arr[] = {30, 10, 10, 5} 
Output: 30 10 10 5
Explanation: When an array is sorted in non-increasing order, all elements are leaders.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 107
0 <= arr[i] <= 107
*/
