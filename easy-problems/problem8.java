import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class problem8 {

    
    // brute force approach : time complexity O(N+M) with space complexity : O(N+M)
    public static ArrayList bruteForceSolution(int arr1[],int arr2[]){
        // step1: create a set from TreeSet<>() -> becuase we want to maintain order in sorted order
        Set<Integer> arraySet=new TreeSet<>();
        // step2: create a ArrayList from ArraList<>();
        ArrayList<Integer> result=new ArrayList<>();
        // step3: add  arr1 to arraySet
        for(int i=0;i<arr1.length;i++){
            arraySet.add(arr1[i]);
            }
        // step4: add arr2 to arraySet
        for(int i=0;i<arr2.length;i++){
            arraySet.add(arr2[i]);
        }
        //  step5: use iterator on the arraySet and extract element from the arraySet and add it to the result arraylist
        Iterator<Integer> it =arraySet.iterator();
        while (it.hasNext()){
            result.add(it.next());
        }
        for (Integer item : result) {
            System.out.print(item +" ");
        }
        // step6: return result
        return result;
    }


    //optimal approach : time complexity O(N+M) with space complexity : O(1)
    public static void optimalSolution(int arr1[],int arr2[]){
        // pending...
    }
    public static void main(String[] args) {
        int arr1[]={-7, 8};
        int arr2 [] = {-8, -3, 8};
        bruteForceSolution(arr1,arr2);
        optimalSolution(arr1,arr2);
    }
}

/*
Given two sorted arrays of size n and m respectively, find their union. The Union of two arrays can be defined as the common and distinct elements in the two arrays. Return the elements in sorted order.

Example 1:

Input: 
n = 5, arr1[] = {1, 2, 3, 4, 5}  
m = 5, arr2 [] = {1, 2, 3, 6, 7}
Output: 
1 2 3 4 5 6 7
Explanation: 
Distinct elements including both the arrays are: 1 2 3 4 5 6 7.

Your Task: 
You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays.

Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).

Constraints:
1 <= n, m <= 105
-109 <= arr1[i], arr2[i] <= 109
*/
