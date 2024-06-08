public class Problem3 {
    // better approach-O(N)
    public static boolean solution(int arr[],int n){
        boolean isSort=true;
        for(int i=0;i<=n-2;i++){
            if(arr[i]<=arr[i+1]){
                continue;
            }
            else{
                isSort=false;
                break;
            }
        }
        System.out.println(isSort);
        return isSort;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,3,0};  // non-descending order
        solution(arr,arr.length);
    }
}


