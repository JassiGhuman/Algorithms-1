public class Median_Of_Array {
	// DO NOT MODIFY BOTH THE LISTS
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    double result=0;
	    int n1=a.size();
	    int n2=b.size();
        if(n1>n2){
            return findMedianSortedArrays(b,a);
        }
	    int count=n1+n2;
	    int low=0;
	    int high=n1;
	    int mid_a=0;
	    int mid_b=0;
	    while(low<=high){
	        mid_a=(low+high)/2;
	        mid_b=(count+1)/2 - mid_a;
	        int max_left_a=0;
	        if(mid_a==0){
	            max_left_a=Integer.MIN_VALUE;
	        }
	        else{
	            max_left_a=a.get(mid_a-1);
	        }
	        int min_right_a=0;
	        if(mid_a==n1){
	            min_right_a=Integer.MAX_VALUE;
	        }
	        else{
	            min_right_a=a.get(mid_a);
	        }
	        
	        int max_left_b=0;
	        if(mid_b==0){
	            max_left_b=Integer.MIN_VALUE;
	        }
	        else{
	            max_left_b=b.get(mid_b-1);
	        }
	        
	        int min_right_b=0;
	        if(mid_b==n2){
	            min_right_b=Integer.MAX_VALUE;
	        }
	        else{
	            min_right_b=b.get(mid_b);
	        }
	        
	        if(max_left_a <= min_right_b && max_left_b <= min_right_a  ){
	            double min=Math.max(max_left_a,max_left_b);
	            double max=Math.min(min_right_b,min_right_a);
	            if(count%2==0){
	                return (min+max)/2;     
	            }
	            else{
	                return (double)min;
	            }
	            
	        }
	        else if(max_left_a > min_right_b){
	            high=mid_a-1;    
	        }
	        else{
	            low=mid_a+1;
	        }
	    }
	    return -1;
	}
}
