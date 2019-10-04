public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY

    public int[] repeatedNumber(final int[] A) {
        int n=A.length;
        long sum_actual=0;
        long sum_squares=0;
        long sum_squares_correct=0;
        for(int i=0;i<n;i++){
            sum_actual+=(long)A[i];
            sum_squares+=(long)((long)A[i]*(long)A[i]);
            sum_squares_correct+=(long)((long)(i+1)*(long)(i+1));
        }
        long sum=(long)n*(long)(n+1)/2;
        long diff=sum-sum_actual;
        long diff1 = sum_squares_correct - sum_squares;
        long b_Plus_a=(long)diff1/(long)diff;
        int b=(int)((diff+b_Plus_a)/2);
        int a=(int)(b-diff);
        int result[]={a,b};
        return result;
    }
}
