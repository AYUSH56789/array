import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Problem4 {


    // brute force approach : O(N) with space complexity: O(N)
    public static int bruteForceSolution(int arr[],int n){
        // step1: create set data structure (which is used to store data uniquily)
        Set<Integer> setArray=new HashSet<>(); // {space complexity : O(M),where M represent number of unique element in the array, in worst case it can be "O(N)"}
        // step2: add array element into the set {time complexity O(N), , where n represent number of element in the array}
        for(int i=0;i<=arr.length-1;i++) {
            setArray.add(arr[i]);
        }
        // step3: create some variable that are used to fulfill our approach
        int i=0;
        int counter=0;
        // step4: create a iterator to iterate over set and get value from the set and that value also assign to the array "arr" and increment i and counter variable by one. {time complexity O(M) , where M represent number of element in the set}
        Iterator<Integer> it=setArray.iterator();
        while(it.hasNext()){
            arr[i]=it.next();
            i++;
            counter++;
        }
        // step5: return the size of the setArray that is our unique element
        return counter;
    }



    // optimal approach : O(N) with space complexity O(1)
    public static int optimalSolution(int arr[],int n){
        // step1: assume pointer "i" on the first array element.
        int i=0;
        // step2: create counter to count number of unique element in the array
        int counter=1;
        // step3: iterate from index 0 to n-1 and check arr[j]!= arr[i] than increment i pointer by 1 and assign arr[i]=arr[j] ans also increment counter by one.
        for (int j = 0; j <= n-1; j++) {
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
                counter++;
            }
        }
        // step4: return counter by one
        return counter;
    }


    public static void main(String[] args) {
        int arr[]={1,1,2};  // non-descending order
        System.out.println(bruteForceSolution(arr,arr.length));
        System.out.println(optimalSolution(arr,arr.length));
    }
}

/*
 Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
 */