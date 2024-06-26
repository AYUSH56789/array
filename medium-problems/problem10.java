public class problem10 {

    // bruteForce approach : time complexity O(N*M) with space complaxity O(N*M)
    public static void bruteForceSolution(int matrix[][]) {
        int result[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=matrix[0].length-1;j>=0;j--){
                result[i][(matrix[0].length-1)-j]=matrix[j][i];
            }
        }

        // print result
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    // optimal approach : time complexity O(N*M) with space complaxity O(1)
    public static void optimalSolution(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // transpose the given matrix
                if(i!=j && !(i>j)){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][(matrix[0].length-1)-j];
                matrix[i][(matrix[0].length-1)-j]=temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // int matrix[][] = {{1,2,3},
                        //   {4,5,6},
                        //   {7,8,9}   };
               int matrix[][]={{5,1,9,11},
                                {2,4,8,10},
                                {13,3,6,7},
                                {15,14,12,16}};
        // bruteForceSolution(matrix);
        optimalSolution(matrix);
    }
}


/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
*/
