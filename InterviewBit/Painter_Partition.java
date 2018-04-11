public class Painter_Partition {
    public int paint(int B, int T, int[] A) {
        int n=A.length;
        
        long sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+((long)T*(long)A[i]));
            //sum=sum% 10000003;
        }
        long low=0;
        long high=sum;
        long mid=0;
        long result=Long.MAX_VALUE;
        while(low<=high){
            mid=(low+high)/2;
            if(possible(A,B,mid,T)){
                result=Math.min(result,mid);
                high=(mid)-1;
            }
            else
                low=(mid)+1;
        }
        //System.out.println(result);
        return (int)(result% 10000003);
    }
    boolean possible(int A[],int B,long curr_min,int T){
        int n=A.length;
        long curr_sum=0;
        int students=1;
        for(int i=0;i<n;i++){
            if(((long)A[i]*(long)T)>curr_min)
                return false;
            
            if((((long)A[i]*(long)T)+curr_sum)>curr_min){
                
                students++;
                curr_sum=((long)T*(long)A[i]);
                if(students>B)
                    return false;
            }
            
            else{
                curr_sum=(curr_sum+((long)T*(long)A[i]));
            }
            
        }
        return true;
    }
}
