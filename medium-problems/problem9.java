public class problem9 {

    private static void row(int matrix[][],int value,int row){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[row][i]!=0){
            matrix[row][i]=value;
            }
        }
    }

    private static void column(int matrix[][],int value,int col){
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][col]!=0){
                matrix[i][col]=value;
            }
        }
    }
    
    // optimal approach: time complexity: O(M*N*(M+N) + MxN ) )  ~= O(N^3) in worst case time complexity
    public static void bruteForceSolution(int matrix[][]){
        // time complexity: O(MxN)
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row(matrix,-1,i);  // time complexity: O(M)
                    column(matrix,-1,j);   // time complexity: O(N)
                }
            }
        }

        // // time complexity: O(MxN)
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
               if(matrix[i][j]==-1){
                matrix[i][j]=0;
               }
            }
        }

        // print solution
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    // better aapproach : time complexity O(N*M) with space complexity O(N+M)
    public static void betterSolution(int matrix[][]){
        int row[] = new int [matrix.length];
        int column[] = new int[ matrix[0].length];        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    column[j]=1;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(row[i]==1 || column[j]==1){
                    matrix[i][j]=0;
                }
            }
        }


        // print
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        

    }

    // optimal solution: time complexity O(N*M) with space complexity O(1)
    public static void optimalSolution(int matrix[][]){
        int col0=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }
                    else{
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }


        // print
        System.out.println();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }        
    }
    public static void main(String[] args) {
        // int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};
        int matrix[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        // bruteForceSolution(matrix);
        // betterSolution(matrix);
        optimalSolution(matrix);
    }
}
/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
