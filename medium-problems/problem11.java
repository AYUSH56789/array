import java.util.ArrayList;
import java.util.List;

public class problem11 {
    // optimal solution: time complexity O(N*M) with space complexity O(N*M)
    public static void optimalSolution(int matrix[][]){
        List<Integer> list=new ArrayList<>();
        int n=matrix.length; //total rows
        int m=matrix[0].length; //total columns
        int top=0;
        int right=m-1;
        int bottom=n-1;
        int left=0;
        while(top<=bottom && left<=right){
            // top
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            // right
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            // bottom
            if(top<=bottom){
                for (int i = right; i >=left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // left
            if(left<=right){
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        // print array
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
    public static void main(String[] args) {
        // int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        optimalSolution(matrix);
    }
}

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/