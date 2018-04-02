public class Allocate_Books {
    public int books(int[] A, int B) {
        int n=A.length;
        if(B>n){
            return -1;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=A[i];
        }
        int low=0;
        int high=sum;
        int mid=0;
        int result=Integer.MAX_VALUE;
        while(low<=high){
            mid=(low+high)/2;
            if(possible(A,B,mid)){
                result=Math.min(result,mid);
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return result;
    }
    boolean possible(int A[],int B,int curr_min){
        int n=A.length;
        int curr_sum=0;
        int students=1;
        for(int i=0;i<n;i++){
            if(A[i]>curr_min)
                return false;
            
            if(A[i]+curr_sum>curr_min){
                
                students++;
                curr_sum=A[i];
                if(students>B)
                    return false;
            }
            
            else{
                curr_sum+=A[i];
            }
            
        }
        return true;
    }
    
    
}
