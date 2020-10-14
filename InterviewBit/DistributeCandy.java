public class Solution {
    public int candy(int[] A) {
        int n=A.length;
        if(n==0)
            return 0;
        int left[]=new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            if(A[i]>A[i-1]){
                left[i]=left[i-1]+1;
            }
            else if(A[i]<=A[i-1]){
                left[i]=1;
            }
            
        }
        int right[]=new int[n];
        right[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(A[i]>A[i+1]){
                right[i]=right[i+1]+1;
            }
            else if(A[i]<=A[i+1]){
                right[i]=1;
            }
            
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+Math.max(left[i],right[i]);
        }
        return sum;
    }
}

