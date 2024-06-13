// this logic is only valid for sorted order
import java.util.ArrayList;

public class problem9 {


    //brute force approach : time complexity O(N*M) with space complexity : O(N) or O(M) , where k may be N{arr1.length} or M{arr2.length} in worst case; 
    public static ArrayList bruteForceSolution(int arr1[],int arr2[]){
        // step1: create arraylist for storing result array{which contain intersection of both};
        ArrayList<Integer> result=new ArrayList<>();
        // step2: iterate on the arr1  and extract element from it . and apply linear search on the arr2 if match found than add that element into result array; 
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    if (result.size()==0) {
                        result.add(arr1[i]);
                    }
                    else{
                        if (result.get(result.size()-1)!=arr1[i]) {
                            result.add(arr1[i]);
                        }
                    }
                }
            }
        }
        for (Integer item : result) {
            System.out.print(item+" ");
        }
        // step3: return result
        return result;
    }



    //optimal approach : time complexity O(N+M) with space complexity : O(N) or O(M) , where k may be N{arr1.length} or M{arr2.length} in worst case
    public static ArrayList optimalSolution(int arr1[],int arr2[]){
        // step1: create arraylist for storing result array{which contain intersection of both};
        ArrayList<Integer> result=new ArrayList<>();
        // step2: create two pointer i->arr1 and j->arr2 
        int i=0 ,j=0;
        // step3: iterate on both array simultaneous and if match found than add that element in the result array
        while (i<arr1.length && j<arr2.length) {
            if(arr2[j]<arr1[i]){
                j++;
            }
            else if (arr2[j]>arr1[i]) {
                i++;
            }
            else if(arr1[i]==arr2[j]){
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        // step4: return result array
        return result;
    }


    public static void main(String[] args) {
        int arr1[]={1, 2, 3, 4, 5};
        int arr2 [] = {1, 2, 3, 6, 7};
        bruteForceSolution(arr1,arr2);
        optimalSolution(arr1,arr2);
    }
}
/*
Given two sorted arrays of size n and m respectively, find their intersection. Return the elements in sorted order.

Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 
Explanation: 
Elements including both the arrays are: 1 2 3 .

Constraints:
1 <= n, m <= 105
-109 <= arr1[i], arr2[i] <= 109
*/
