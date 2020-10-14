public class Solution {
    public int maxp3(int[] A) {
        Arrays.sort(A);
        int n=A.length;
        
        int prod=A[n-1]*A[n-2]*A[n-3];
        if(n==3){
            return prod;
        }
        if(prod>=0){
            if(A[0]<0 && A[0]*A[1]>0){
                prod=Math.max(A[0]*A[1]*A[n-1],prod);
            }
            return prod;
        }
        if(prod<0){
            if(A[n-1]<0){
                return prod;
            }   
            else{
                prod=Math.max(A[0]*A[1]*A[n-1],prod);
            }
        }
        return prod;
    }
}

